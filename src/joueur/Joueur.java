package joueur;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import main.Grade;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Joueur {
	
	public static HashMap<UUID, Integer> money;
	public static HashMap<UUID, Grade> grade;
	public static HashMap<UUID, Grade> staffGrade;
	public static HashMap<UUID, String> server;
	public static ArrayList<UUID> doubleJump;
	public static ArrayList<UUID> mute;
	
	
	//Lance au demarage serveur pour initialiser les HAshMap
	public static void onEnable(){
		money = new HashMap<>();
		grade = new HashMap<>();
		staffGrade = new HashMap<>();
		server = new HashMap<>();
		doubleJump = new ArrayList<>();
		mute = new ArrayList<>();
	}
	
	public static boolean getJoueurData(Player p){
		checkVIP(p);
		UUID id = p.getUniqueId();
		String[] requetteList = {id.toString()};
		ArrayList<ArrayList<String>> list = main.Api.BdDsendRequette("SELECT * FROM `listJoueur` WHERE `UUID` = ?", requetteList);
		for(ArrayList<String> l : list){
			if(l.get(1).equalsIgnoreCase(id.toString()) && l.get(0).equalsIgnoreCase(p.getName())){ //Le joueur est deja venu sur le serveur
				Joueur.grade.put(id, main.Grade.getGrade(l.get(2)));
				Joueur.money.put(id, Integer.parseInt(l.get(3)));
				Joueur.staffGrade.put(id, main.Grade.getGrade(l.get(5)));
				Joueur.server.put(id, Bukkit.getServerName());
				return true;
			}
		}
		return false; //Le joueur n'est jamais venu sur le serveur
	}
	
	private static void checkVIP(Player p){
		String requette ="SELECT * FROM `Vip` WHERE `uuid` = ?";
		String[] list = {p.getUniqueId().toString()};
		ArrayList<ArrayList<String>> l = main.Api.BdDsendRequette(requette, list);
		
		if(l.isEmpty()){
			return;
		}
		
		Date d = new Date(System.currentTimeMillis());
		
		Date dl = new Date(Long.parseLong(l.get(0).get(4)));
		if(d.compareTo(dl) > 0){ //Le joueur n'est plus vip
			Grade g = Grade.getGrade("Joueur");
			UUID id = p.getUniqueId();
			
			//Mise a jour des donnee sur le serveur
			Joueur.grade.remove(id);
			Joueur.grade.put(id, g);
			
			//Mise a jour de la base de donee
			String[] list1 = {g.getName(), id.toString()};
			main.Api.BdDsendRequetteNoReturn("UPDATE `listJoueur` SET `grade` = ? WHERE `UUID` = ?", list1);
			
			String[] list2 = {id.toString()};
			main.Api.BdDsendRequetteNoReturn("DELETE FROM `Vip` WHERE `uuid` = ?", list2);
			p.sendMessage("§2Ton abonnement §6" + l.get(0).get(2) + "§2 vient de se terminer");
			p.sendMessage("§2Tu peux en acheter un dans la boutique");
			p.sendMessage("§2Ou sur notre site : §6nitro-games.fr");
			
		}
	}
	
	static void prepareJoueurToLobby(Player p){	//Inventaire que le joueur a sur le lobby
		//Condition initiale avant de check le grade
		inventory.Lobby.getInventory(p);
		p.setGameMode(GameMode.ADVENTURE);
		p.setAllowFlight(false);
		p.setFlying(false);
		p.setExp(0);
		if(Joueur.doubleJump.contains(p.getUniqueId())){
			Joueur.doubleJump.remove(p.getUniqueId());
		}
		
		UUID id = p.getUniqueId();
		if(staffGrade.get(id).getPower() < 15){ //Le joueur est un membre du staff
			Grade g = staffGrade.get(id);
			String dispName = g.getPrefixe() +" "+ p.getName() +"§r";
			p.setDisplayName(dispName);
			p.setCustomName(dispName);
			p.setCustomNameVisible(true);
			p.setPlayerListName(dispName);
		}else{ //C'est un joueur normal
			Grade g = grade.get(id);
			String dispName = g.getPrefixe() +" "+ p.getName() +"§r";
			p.setDisplayName(dispName);
			p.setCustomName(dispName);
			p.setCustomNameVisible(true);
			p.setPlayerListName(dispName);
		}

		//Double jump si VIP ou Fly si HighStaff ou Modo
		if(grade.get(id).getPower() <=1 || staffGrade.get(id).getPower() <=3){
			p.setAllowFlight(true);
		}else if(grade.get(id).getPower() <= 8 && grade.get(id).getPower() >4){
			Joueur.doubleJump.add(id);
		}
	}
	
}

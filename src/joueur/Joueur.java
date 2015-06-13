package joueur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import main.Grade;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Joueur {
	
	public static HashMap<UUID, Integer> money;
	public static HashMap<UUID, Grade> grade;
	public static HashMap<UUID, String> server;
	public static ArrayList<UUID> doubleJump;
	
	
	//Lance au demarage serveur pour initialiser les HAshMap
	public static void onEnable(){
		money = new HashMap<>();
		grade = new HashMap<>();
		server = new HashMap<>();
		doubleJump = new ArrayList<>();
	}
	
	public static boolean getJoueurData(Player p){
		UUID id = p.getUniqueId();
		ArrayList<ArrayList<String>> list = main.Api.BdDsendRequette("SELECT * FROM `listJoueur`");
		for(ArrayList<String> l : list){
			if(l.get(1).equalsIgnoreCase(id.toString()) && l.get(0).equalsIgnoreCase(p.getName())){
				Joueur.grade.put(id, main.Grade.getGrade(l.get(2)));
				Joueur.money.put(id, Integer.parseInt(l.get(3)));
				Joueur.server.put(id, Bukkit.getServerName());
				return true;
			}
		}
		return false;
	}
	
}

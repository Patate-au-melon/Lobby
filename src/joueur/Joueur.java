package joueur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import main.Grade;

public class Joueur {
	
	public static HashMap<UUID, Integer> moneyMiniGames;
	public static HashMap<UUID, Integer> money;
	public static HashMap<UUID, Grade> grade;
	public static HashMap<UUID, String> server;
	
	
	//Lance au demarage serveur pour initialiser les HAshMap
	public static void onEnable(){
		moneyMiniGames = new HashMap<>();
		money = new HashMap<>();
		grade = new HashMap<>();
		server = new HashMap<>();
	}
	
	public static boolean getJoueurData(Player p){
		UUID id = p.getUniqueId();
		ArrayList<ArrayList<String>> list = main.Api.BdDsendRequette("SELECT * FROM `listJoueur`");
		for(ArrayList<String> l : list){
			if(l.get(1).equalsIgnoreCase(id.toString()) && l.get(0).equalsIgnoreCase(p.getName())){
				Joueur.grade.put(id, main.Grade.getGrade(l.get(2)));
				Joueur.money.put(id, Integer.parseInt(l.get(3)));
				Joueur.server.put(id, "Lobby");
				return true;
			}
		}
		return false;
	}
	
}

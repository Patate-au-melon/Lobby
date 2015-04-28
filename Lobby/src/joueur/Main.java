package joueur;

import java.util.HashMap;
import java.util.UUID;

import object.Grade;


public class Main {
	
	public static HashMap<UUID, Integer> moneyMiniGames;
	public static HashMap<UUID, Integer> moneyVIP;
	public static HashMap<UUID, Grade> grade;
	public static HashMap<UUID, Integer> multiplicateur;
	public static HashMap<UUID, String> server;
	
	public static void onEnable(){
		moneyMiniGames = new HashMap<>();
		moneyVIP = new HashMap<>();
		grade = new HashMap<>();
		multiplicateur = new HashMap<>();
		server = new HashMap<>();
	}

}

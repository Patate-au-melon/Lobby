package joueur;

import java.util.HashMap;
import java.util.UUID;

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
	
}

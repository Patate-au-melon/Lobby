package object;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

public class Joueur {
	
	private String name;
	private UUID uuid;
	private Grade grade;
	private int moneyMiniGames;
	private int moneyVIP;
	private int multiplcateur;
	
	public static ArrayList<Joueur> joueurList;
	
	public Joueur(Player player){
		this.name = player.getName();
		this.uuid = player.getUniqueId();
	}
	
	public Joueur getJoueur(String name){
		for(Joueur j: joueurList){
			if(j.name.equalsIgnoreCase(name))
				return j;
		}
		return null;
	}
	
	public Joueur getJoueur(UUID uuid){
		for(Joueur j : joueurList){
			if(j.uuid.equals(uuid))
				return j;
		}
		return null;
	}
	
	public String getName(){
		return name;
	}
	
	public UUID getUUID(){
		return uuid;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getMoneyMiniGames() {
		return moneyMiniGames;
	}

	public void setMoneyMiniGames(int moneyMiniGames) {
		this.moneyMiniGames = moneyMiniGames;
	}

	public int getMoneyVIP() {
		return moneyVIP;
	}

	public void setMoneyVIP(int moneyVIP) {
		this.moneyVIP = moneyVIP;
	}

	public int getMultiplcateur() {
		return multiplcateur;
	}

	public void setMultiplcateur(int multiplcateur) {
		this.multiplcateur = multiplcateur;
	}
	
	

}

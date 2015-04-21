package object;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

public class Joueur {
	
	/*
	 * 
	 * A lancer au onEnable()
	 * 		Creation de la liste joueurList
	 * 
	 */
	
	private String name;
	private UUID uuid;
	private Grade grade;
	private String server;
	private int moneyMiniGames;
	private int moneyVIP;
	private int multiplcateur;
	
	public static ArrayList<Joueur> joueurList;
	
	public Joueur(Player player){
		this.name = player.getName();
		this.uuid = player.getUniqueId();
		
	}
	
	public static Joueur getJoueur(String name){
		for(Joueur j: joueurList){
			if(j.name.equalsIgnoreCase(name))
				return j;
		}
		return null;
	}
	
	public static Joueur getJoueur(UUID uuid){
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

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (moneyMiniGames != other.moneyMiniGames)
			return false;
		if (moneyVIP != other.moneyVIP)
			return false;
		if (multiplcateur != other.multiplcateur)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	
	

}

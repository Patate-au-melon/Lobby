package main;

import java.util.ArrayList;

import org.bukkit.Bukkit;

public class Grade {
	
	private static ArrayList<Grade> listGrade;
	
	private String name;
	private int power;
	private String server;
	private String prefixe;
	
	public Grade(String name, int power, String server, String prefixe){
		this.name = name;
		this.power = power;
		this.server = server;
		this.prefixe = prefixe;
		
		listGrade.add(this);
	}
	
	//Recuperation du nom du grade
	public String getName(){
		return this.name;
	}
	
	//Recuperation du power du grade
	public int getPower(){
		return this.power;
	}

	//Recuperation du serveur ou le grade est actif
	public String getsever(){
		return this.server;
	}
	
	//Recuperation du prefixe du grade
	public String getPrefixe(){
		return this.prefixe;
	}
	
	
	//Recuperation d'un grade depuis son nom
	public static Grade getGrade(String gradeName){
		for(Grade g : listGrade){
			if(g.getName().equalsIgnoreCase(gradeName)){
				return g;
			}
		}
		return null;
	}
	
	
	//Recuperation de la liste des grades depuis la base de donnees
	static void createGrade(){
		listGrade = new ArrayList<>();
		ArrayList<ArrayList<String>> list = Api.BdDsendRequette("SELECT * FROM `listGrade`"); //Demande de la liste des grades a la base de donnees
		for(ArrayList<String> l : list){
			String name = l.get(0);
			int power = Integer.parseInt(l.get(1));
			String server = l.get(5);
			String prefixe = l.get(2);
			new Grade(name, power, server, prefixe); //Creation de tous les objets Grade
		}
		Bukkit.getLogger().info("Recuperation des grades");
	}

}

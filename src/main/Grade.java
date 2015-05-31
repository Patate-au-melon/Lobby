package main;

import java.util.ArrayList;

import org.bukkit.Bukkit;

public class Grade {
	
	private static ArrayList<Grade> listGrade;
	
	private String name;
	private int power;
	private String prefixe;
	
	public Grade(String name, int power, String prefixe){
		this.name = name;
		this.power = power;
		this.prefixe = prefixe;
		listGrade.add(this);
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPower(){
		return this.power;
	}
	
	public String getPrefixe(){
		return this.prefixe;
	}
	
	public static Grade getGrade(String name){
		for(Grade g : listGrade){
			if(g.getName().equalsIgnoreCase(name)){
				return g;
			}
		}
		return null;
	}
	
	static void createGrade(){
		ArrayList<ArrayList<String>> list = Api.BdDsendRequette("SELECT * FROM `listGrade`");
		for(ArrayList<String> l : list){
			String name = l.get(0);
			int power = Integer.parseInt(l.get(1));
			String prefixe = l.get(2);
			new Grade(name, power, prefixe);
		}
		Bukkit.getLogger().info("Recuperation des grades");
	}

}

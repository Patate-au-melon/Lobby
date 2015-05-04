package main;

import java.util.ArrayList;
import java.util.HashMap;

import object.Grade;
import object.Panneau;

import org.bukkit.Bukkit;

public class OnEnable {
	
	public OnEnable(){
		String url = "jdbc:mysql://publicsql-1.pulseheberg.net/service_35502";
		String user = "service_35502";
		String password = "V7f9ebUn31";
		object.Panneau.listSign = new ArrayList<Panneau>();
		object.Grade.gradeList = new ArrayList<Grade>();
		joueur.Inv.nbPlayer = new HashMap<>();
		object.Panneau.listLoc = new HashMap<>();
		joueur.Main.onEnable();
		Api.BdDconnect(url, user, password);
		new signControl.Startup();
		Config.createConfig();
		object.Grade.recupGrade();
		Bukkit.getMessenger().registerOutgoingPluginChannel(main.Main.getPlugin(), "BungeeCord");
		Bukkit.getPluginManager().registerEvents(new Event(), main.Main.getPlugin());
		new server.ServerMain().runTaskAsynchronously(Main.getPlugin());
		Bukkit.getLogger().info("Plugin actif");
	}
	
}

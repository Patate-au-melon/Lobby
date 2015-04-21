package main;

import java.util.ArrayList;

import object.Grade;
import object.Panneau;

import org.bukkit.Bukkit;

public class OnEnable {
	
	private static String url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_plugin";
	private static String user = "hbct_plugin";
	private static String password = "jeje";
	
	public OnEnable(){
		object.Panneau.listSign = new ArrayList<Panneau>();
		object.Grade.gradeList = new ArrayList<Grade>();
		Api.BdDconnect(url, user, password);
		new signControl.Startup();
		Config.createConfig();
		object.Grade.recupGrade();
		Bukkit.getMessenger().registerOutgoingPluginChannel(main.Main.getPlugin(), "BungeeCord");
		registerEvents();
		new server.ServerMain().runTaskAsynchronously(Main.getPlugin());
		Bukkit.getLogger().info("Plugin actif");
	}
	
	private void registerEvents(){
		//Bukkit.getPluginManager().registerEvents(new joueur.JoueurEvent(), Main.getPlugin());
	}
	
}

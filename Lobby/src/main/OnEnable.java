package main;

import java.util.ArrayList;
import java.util.HashMap;

import object.Grade;
import object.Panneau;

import org.bukkit.Bukkit;

public class OnEnable {
	
	private static String url = Config.getPassConfig().getString("url");
	private static String user = Config.getPassConfig().getString("user");
	private static String password = Config.getPassConfig().getString("password");
	
	public OnEnable(){
		url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_plugin";
		user = "hbct_plugin";
		password = "jeje";
		object.Panneau.listSign = new ArrayList<Panneau>();
		object.Grade.gradeList = new ArrayList<Grade>();
		object.Panneau.listLoc = new HashMap<>();
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
		Bukkit.getPluginManager().registerEvents(new joueur.JoueurEvent(), Main.getPlugin());
		Bukkit.getPluginManager().registerEvents(new signControl.Event(), main.Main.getPlugin());
	}
	
}

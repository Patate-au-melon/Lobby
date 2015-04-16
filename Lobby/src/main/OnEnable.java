package main;

import java.util.ArrayList;

import object.Panneau;

import org.bukkit.Bukkit;

public class OnEnable {
	
	public OnEnable(){
		object.Panneau.listSign = new ArrayList<Panneau>();
		ApiBaseDeDonnee.connect();
		new signControl.Startup();
		Config.createConfig();
		new server.ServerMain().runTaskAsynchronously(Main.getPlugin());
		Bukkit.getLogger().info("Plugin actif");
	}

}

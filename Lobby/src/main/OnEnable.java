package main;

import org.bukkit.Bukkit;

public class OnEnable {
	
	public OnEnable(){
		new signControl.Startup();
		ApiBaseDeDonnee.connect();
		Config.createConfig();
		new server.ServerMain().runTaskAsynchronously(Main.getPlugin());
		Bukkit.getLogger().info("Plugin actif");
	}

}

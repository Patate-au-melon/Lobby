package main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class OnEnable {
	
	public OnEnable(){
		//je suis fort
		signControl.Receive.listSign = new HashMap<Location, String[]>();
		ApiBaseDeDonnee.connect();
		Config.createConfig();
		new server.ServerMain().runTaskAsynchronously(Main.getPlugin());
		new signControl.DemarageSetup();
		Bukkit.getLogger().info("Plugin actif");
	}

}

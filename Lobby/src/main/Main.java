package main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		signControl.Receive.listSign = new HashMap<Location, String[]>();
		ApiBaseDeDonnee.connect();
		Config.createConfig();
		new server.ServerMain().runTaskAsynchronously(getPlugin());
		new signControl.DemarageSetup();
		Bukkit.getLogger().info("Plugin actif");
	}
	
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		return false;
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("LobbyNitroGames");
	}

}

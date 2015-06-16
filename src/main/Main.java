package main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		StartAndStop.onEnable();
	}
	
	public void onDisable(){
		StartAndStop.onDisble();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		joueur.Cmd_setGrade.setGrade(sender, cmd, label, args);
		joueur.Cmd_addVip.addVip(sender, cmd, label, args);
		return false;
	}
	
	
	//Recuperation de l'objet Plugin
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("LobbyNitroGames");
	}

}

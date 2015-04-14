package main;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private static String serverInfoPath = "plugins/NitroGames/serverInfo.yml"; 
	private static String listServerNamePath = "plugins/NitroGames/listServerName.yml";
	private static String signControlPath = "plugins/NitroGames/signControl.yml";
	
	public static FileConfiguration getListServerNameConfig(){
		File f = new File(listServerNamePath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void saveListServerNameConfig(FileConfiguration config){
		File f = new File(listServerNamePath);
		try {
			config.save(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FileConfiguration getServerInfo(){
		File f = new File(serverInfoPath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void setServerInfo(FileConfiguration config){
		try {
			config.save(new File(serverInfoPath));
		} catch (Exception e) {
			Bukkit.getLogger().warning("Erreur lie a la sauvegarde de la config serverInfo");
			e.printStackTrace();
		}
	}
	
	public static FileConfiguration getSignControl(){
		File f = new File(signControlPath);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void setSignControl(FileConfiguration config){
		try {
			config.save(new File(signControlPath));
		} catch (Exception e) {
			Bukkit.getLogger().warning("Erreur lie a la sauvegarde de la config serverInfo");
			e.printStackTrace();
		}
	}
	
	public static void createConfig(){
		recupListServerName();
		createServerInfo();
		createSignControl();
	}
	
	private static void recupListServerName(){
		FileConfiguration config = main.Config.getListServerNameConfig();
		ArrayList<ArrayList<String>> list = ApiBaseDeDonnee.sendRequette("SELECT * FROM `listServer`");
		for(int i = 0; i <list.size();i++){
			ArrayList<String> l = list.get(i);
			config.set(l.get(0), l.get(1));
		}
		main.Config.saveListServerNameConfig(config);
		Bukkit.getLogger().info("Mise a jour de la config ListServerName termine");
	}
	
	private static void createServerInfo(){
		FileConfiguration config = main.Config.getServerInfo();
		if(config.getString("name") == null || config.getString("name") == ""){
			config.set("name", "");
			config.set("port", "");
			main.Config.setServerInfo(config);
			Bukkit.getLogger().info("Creation de la config serverInfo");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}
	
	private static void createSignControl(){
		FileConfiguration config = main.Config.getSignControl();
		if(config.getString("line1") == null || config.getString("line1") == ""){
			config.set("line1", "");
			config.set("line2", "");
			config.set("line3", "");
			config.set("line4", "");
			main.Config.setSignControl(config);
			Bukkit.getLogger().info("Creation de la config serverInfo");
			Bukkit.getLogger().warning("Merci de la remplir avant de relancer le serveur");
			Bukkit.getServer().shutdown();
		}
	}
}

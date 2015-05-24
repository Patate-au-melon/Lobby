package main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private static String pathPass = "plugins/NitroGames/pass.yml";
	
	public static FileConfiguration getPassConfig(){
		File f = new File(pathPass);
		return YamlConfiguration.loadConfiguration(f);
	}
	
	public static void setPassConfg(FileConfiguration config){
		File f = new File(pathPass);
		try {
			config.save(f);
		} catch (Exception e) {
			e.printStackTrace();
			Bukkit.getLogger().warning("Erreur dans la sauvegarde de la config pass.yml");
		}
	}
	
	public static void passCreate(){
		FileConfiguration config = getPassConfig();
		if(config.getString("BaseDeDonnee.user") == null || config.getString("BaseDeDonnee.user") == ""){
			config.set("BaseDeDonnee.dev", "");
			config.set("BaseDeDonnee.user", "");
			config.set("BaseDeDonnee.password", "");
			setPassConfg(config);
			Bukkit.getLogger().warning("Merci de remplir la config pass.yml avant de relancer le serveur");
			Bukkit.shutdown();
		}
	}

}

package main;

import gadjetArmor.RainbowArmor;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import signControl.Panneau;

public class StartAndStop {
	
	//Procedur au lancement du serveur
	static void onEnable(){
		
		Panneau.listPanneau = new HashMap<>();
		joueur.Joueur.onEnable();
		main.Config.passCreate(); //Creation de la config pass.yml si elle n'existe pas
		
		Bukkit.getPluginManager().registerEvents(new Event(), Main.getPlugin()); //Gestion des events dans la classe Event
		Bukkit.getPluginManager().registerEvents(new gadjetArmor.EventListener(), Main.getPlugin());
		Bukkit.getPluginManager().registerEvents(new RainbowArmor(), Main.getPlugin());
		Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getPlugin(), "BungeeCord"); //On initialise l'API Bungeecord
		
		String dev = main.Config.getPassConfig().getString("BaseDeDonnee.dev");  //Recuperation du user depuis le fichier pass.yml
		String user = main.Config.getPassConfig().getString("BaseDeDonnee.user");  //Recuperation du mot de passe depuis le fichier pass.yml
		String password = main.Config.getPassConfig().getString("BaseDeDonnee.password"); //Recuperation des informations de connexion à la base de donnee
		String url;
		if(dev.equalsIgnoreCase("true")){
			url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_plugin";  //Base de donnee de developpement
			Bukkit.getLogger().info("Connexion avec la base de donnee de developpement");
		}else{
			url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_nitro";  //Base de donnee du serveur
			Bukkit.getLogger().info("Connexion avec la base de donnee du serveur");
		}
		main.Api.BdDconnect(url, user, password); //Connexion avec la base de donnee
		
		
		ArrayList<ArrayList<String>> listb = Api.BdDsendRequette("SELECT * FROM `signList`");  //On recupere la liste de tous les panneaux
		for(ArrayList<String> l : listb){
			World world = Bukkit.getWorld(l.get(1));
			int x = Integer.parseInt(l.get(2));
			int y = Integer.parseInt(l.get(3));
			int z = Integer.parseInt(l.get(4));
			new Panneau(l.get(0), new Location(world, x, y, z));  //Mise en place des panneaux avec le texte de serveur off
		}
		
		Grade.createGrade(); //Recuperation des grades
		
		gadjetArmor.Main.onEnable();//Preparation armor
		
		
		String[] listTest = {Bukkit.getServerName()};
		ArrayList<ArrayList<String>> list = Api.BdDsendRequette("SELECT * FROM `listServer` WHERE `ServerName` = ?;", listTest);
		int lobbyPort = Integer.parseInt(list.get(0).get(1)); //Recuperation du port de communication du serveurs
		new commServer.StartServer(Bukkit.getServerName(), lobbyPort); //Lancement du serveur de communication
		
		
		Bukkit.getLogger().info("Plugin completement demarrer");
	}
	
	
	//Procédure à l'arret du serveur
	static void onDisble(){
		commServer.StartServer.onDisable();
		gadjetArmor.Main.onDisable();
	}

}

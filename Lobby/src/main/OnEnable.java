package main;

import java.util.ArrayList;
import java.util.HashMap;

import object.Grade;
import object.Panneau;

import org.bukkit.Bukkit;

public class OnEnable {
	
	public OnEnable(){
		String url = "jdbc:mysql://publicsql-1.pulseheberg.net/service_35502";
		String user = Config.getPassConfig().getString("user");
		String password = Config.getPassConfig().getString("password");
		object.Panneau.listSign = new ArrayList<Panneau>();
		object.Grade.gradeList = new ArrayList<Grade>();
		joueur.Inv.nbPlayer = new HashMap<>();
		object.Panneau.listLoc = new HashMap<>();
		joueur.Main.onEnable();
		Api.BdDconnect(url, user, password);
		recuplocalPort();
		new signControl.Startup();
		Config.createConfig();
		object.Grade.recupGrade();
		Bukkit.getMessenger().registerOutgoingPluginChannel(main.Main.getPlugin(), "BungeeCord");
		Bukkit.getPluginManager().registerEvents(new Event(), main.Main.getPlugin());
		new server.ServerMain().runTaskAsynchronously(Main.getPlugin());
		Bukkit.getLogger().info("Plugin actif");
	}
	
	private static void recuplocalPort(){
		String[] a = {Bukkit.getServerName()};
		ArrayList<ArrayList<String>> list = Api.BdDsendRequette("SELECT * FROM `listServer` WHERE `ServerName` = ?;", a);
		for(ArrayList<String> l : list){
			if(l.get(0).equalsIgnoreCase(Bukkit.getServerName())){
				Main.localPort = Integer.parseInt(l.get(1));
				System.out.println(Main.localPort);
			}
		}
	}
	
}

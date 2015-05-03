package server;

import org.bukkit.Bukkit;

public class Transmit {
	
	public Transmit(String server, String label, String message){
		traitement(server, label, message);
		new signControl.Receive(server, label, message);
		signControl.Event.receiveMessage(server, label, message);
		joueur.ReceiveMessage.receive(server, label, message);
	}
	
	private static void traitement(String server, String label, String message){
		if(label.equalsIgnoreCase("down")){
			Bukkit.getServer().shutdown();
		}
		if(label.equalsIgnoreCase("disconect")){
			ServerMain.listServer.remove(server);
		}
	}

}

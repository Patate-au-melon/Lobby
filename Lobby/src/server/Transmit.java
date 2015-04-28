package server;

import org.bukkit.Bukkit;

public class Transmit {
	
	public Transmit(String server, String label, String message){
		if(label.equalsIgnoreCase("down")){
			Bukkit.getServer().shutdown();
		}
		new signControl.Receive(server, label, message);
		signControl.Event.receiveMessage(server, label, message);
	}

}

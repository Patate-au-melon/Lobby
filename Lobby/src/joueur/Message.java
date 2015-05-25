package joueur;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Message {
	
	//Pour envoyer un joueur a une serveur lors de la reception du message
	public static void transfertJoueur(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("transfertJoueur")){
			String name = message.get(1);
			UUID uuid = UUID.fromString(message.get(2));
			String serv = message.get(3);
			Player p = Bukkit.getPlayer(uuid);
			if(server.equalsIgnoreCase(serv) && p.getName().equalsIgnoreCase(name)){
				main.Api.transfertPlayerTo(main.Main.getPlugin(), p, serv);
			}
		}
	}
	
	public static void sendMessageJoueur(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("sendMessageJoueur")){
			String name = message.get(1);
			UUID uuid = UUID.fromString(message.get(2));
			Player p = Bukkit.getPlayer(uuid);
			String msg = message.get(3);
			if(p.getName().equalsIgnoreCase(name)){
				p.sendMessage(msg);
			}
		}
	}

}

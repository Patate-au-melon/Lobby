package joueur;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Message {
	
	//Pour envoyer un joueur a une serveur lors de la reception du message
	public static void transfertJoueur(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("transfertJoueur")){  //Verification que l'on a le bon message
			String name = message.get(1);
			UUID uuid = UUID.fromString(message.get(2));
			Player p = Bukkit.getPlayer(uuid);
			if(p.getName().equalsIgnoreCase(name)){ //Verification que l'on a le bon joueur
				main.Api.transfertPlayerTo(main.Main.getPlugin(), p, server);  //On transfert le joueur sur le serveur
			}
		}
	}
	
	public static void sendMessageJoueur(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("sendMessageJoueur")){  //Verification du message
			String name = message.get(1);
			UUID uuid = UUID.fromString(message.get(2));
			Player p = Bukkit.getPlayer(uuid);
			String msg = message.get(3);
			if(p.getName().equalsIgnoreCase(name)){  //Verification du bon joueur
				p.sendMessage(msg); //On envoi le message
			}
		}
	}

}

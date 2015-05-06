package joueur;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {
	
	public static void receive(String server, String label, String message){
		if(label.equalsIgnoreCase("nbPlayer")){
			if(Inv.nbPlayer.containsKey(server)){ //Le serveur est deja dans le hashMap
				Inv.nbPlayer.replace(server, Integer.parseInt(message));
			}else{ //Le serveur n'est pas dans le hashMap
				Inv.nbPlayer.put(server, Integer.parseInt(message));
			}
		}else if(label.equalsIgnoreCase("returnLobby")){
			Main.server.replace(UUID.fromString(message), "Lobby");
		}else if(label.equalsIgnoreCase("playerQuit")){
			UUID uuid = UUID.fromString(message);
			Main.grade.remove(uuid);
			Main.moneyMiniGames.remove(uuid);
			Main.moneyVIP.remove(uuid);
			Main.multiplicateur.remove(uuid);
			Main.server.remove(uuid);
		}
	}
	
	public static void receiveCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("update") && sender instanceof Player){
			Player p = (Player) sender;
			UUID uuid = p.getUniqueId();
			String requette ="SELECT * FROM `listJoueur` WHERE `uuid`=?;";
			String[] m = {uuid.toString()};
			
			ArrayList<ArrayList<String>> list = main.Api.BdDsendRequette(requette, m);
			for(ArrayList<String> l : list){
				if(l.get(0).equalsIgnoreCase(p.getName()) && l.get(1).equalsIgnoreCase(p.getUniqueId().toString())){
					Main.grade.replace(uuid, object.Grade.getGrade(l.get(2)));
					Main.moneyMiniGames.replace(uuid, Integer.parseInt(l.get(3)));
					Main.moneyVIP.replace(uuid, Integer.parseInt(l.get(4)));
					Main.multiplicateur.replace(uuid, Integer.parseInt(l.get(5)));
				}
			}
		}
	}

}

package signControl;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Event {
	
	
	//Evenement pour savoir quand un joueur click sur un panneau pour etre tp sur un autre serveur
	public static void playerClickOnSign(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_AIR)){
			
		}else if(b.getType().equals(Material.WALL_SIGN) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){ //On verifie que l'on click sur un panneau avec un click droit
			Panneau pan = Panneau.getPanneau(b.getLocation()); //Recuperation de l'objet Panneau
			if(pan != null){
				/*
				 * Cas ou la Panneau est lie au serveur
				 */
				if(pan.getServerState()){ //On verifie que le serveur est connecte au panneau
					ArrayList<String> msg = new ArrayList<>();  //Preparation pour envoyer un message a un autre serveur
					msg.add("sendJoueur");
					msg.add(p.getName());
					msg.add(p.getUniqueId().toString());
					msg.add(pan.getServer());
					commServer.SendMessage.send(pan.getServer(), msg); //On envoi une demande au serveur qui doit recevoir le joueur
				}else{
					/*
					 * Cas ou le Panneau n'est pas encore lie a un serveur
					 */
					p.sendMessage("§4Le serveur est déconnecté, merci de réessayer plus tard");
				}
			}
		}
	}

}

package signControl;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Event {
	
	
	//Evenement pour savoir quand un joueur click sur un panneau pour etre tp sur un autre serveur
	public static void playerClickOnSign(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		if(b.getType().equals(Material.WALL_SIGN)){
			Panneau pan = Panneau.getPanneau(b.getLocation());
			if(pan != null){
				ArrayList<String> msg = new ArrayList<>();
				msg.add("sendJoueur");
				msg.add(p.getName());
				msg.add(p.getUniqueId().toString());
				msg.add(pan.getServer());
				server.SendMessage.send(pan.getServer(), msg);
			}
		}
	}

}

package signControl;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Event implements Listener{
	
	@EventHandler
	public void clickSign(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getClickedBlock().getType() == Material.WALL_SIGN){
			String server = object.Panneau.listLoc.get(e.getClickedBlock().getLocation());
			new server.SendMessage(server, "sendJoueur", p.getUniqueId().toString());
		}
	}
	
	public static void receiveMessage(String server, String label, String message){
		if(label.equalsIgnoreCase("sendJoueur")){
			UUID id = UUID.fromString(message);
			Player p = Bukkit.getPlayer(id);
			main.Api.transfertPlayerTo(main.Main.getPlugin(), p, server);
		}
	}

}

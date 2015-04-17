package joueur;

import object.Joueur;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoueurEvent implements Listener{
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(object.Joueur.joueurList.contains(p.getName())){
			Joueur j = object.Joueur.getJoueur(p.getName());
			Joueur jo = object.Joueur.getJoueur(p.getUniqueId());
			if(j.equals(jo)){
				if(j.getServer().equalsIgnoreCase("Lobby")){
					p.sendMessage("Rebonjour "+p.getName());
				}else{
					
				}
			}
		}
	}

}

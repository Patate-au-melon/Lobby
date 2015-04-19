package joueur;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoueurEvent implements Listener{
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){

	}
	
	@EventHandler
	public void playerJoin(EntityDamageEvent e){
		if(e.getEntityType() == EntityType.PLAYER){
			e.setCancelled(true);
		}
	}

}

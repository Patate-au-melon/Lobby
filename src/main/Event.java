package main;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

@SuppressWarnings("deprecation")
public class Event implements Listener { //Cette classe contien tout les events et les rediriges
	
	
	//Event lorsque qu'un player click 
	@EventHandler
	public void playerInteract(PlayerInteractEvent e){
		joueur.Event.playerClick(e);
		signControl.Event.playerClickOnSign(e);  //Click sur un panneau pour se tp sur un autre serveur
	}
	
	//Event lorsque qu'un player se connecte sur le serveur
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		joueur.Event.playerJoin(e);
	}
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e){
		joueur.Event.playerQuit(e);
	}
	
	@EventHandler
	public void CkickIntoInventory(InventoryClickEvent e){
		inventory.Compass.clickInventory(e);
	}
	/*
	@EventHandler
	public void placeBlock(BlockPlaceEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void recupBlock(BlockBreakEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void dropItem(PlayerDropItemEvent e){
		e.setCancelled(true);
	}*/
	
	@EventHandler
	public void stopDamage(EntityDamageEvent e){
		if(e.getEntityType().equals(EntityType.PLAYER)){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void foodChange(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void toggleFlight(PlayerToggleFlightEvent e){
		joueur.Event.toggleFlight(e);
	}
	
	@EventHandler
	public void playerMove(PlayerMoveEvent e){
		joueur.Event.PlayerMove(e);
	}
	
	@EventHandler
	public void ChatEvent(PlayerChatEvent e){
		joueur.Event.SendMessage(e);
	}
	
	/*
	private static boolean isStaffMember(Player p){
		UUID id = p.getUniqueId();
		if(joueur.Joueur.grade.get(id).getPower() > 10){
			return true;
		}else{
			return false;
		}
	}
	*/
	
}

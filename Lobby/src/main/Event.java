package main;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Event implements Listener{
	
	@EventHandler
	public void noDamage(EntityDamageEvent e){
		if(e.getEntityType() == EntityType.PLAYER){
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void noDropItem(PlayerDropItemEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void noPlaceBlock(BlockPlaceEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void breakBlock(BlockBreakEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void clickSign(PlayerInteractEvent e){
		joueur.JoueurEvent.clickInventoryGodlIngot(e);
		signControl.Event.clickSign(e);
	}
	
	@EventHandler
	public void clickIntoInventory(InventoryClickEvent e){
		//joueur.JoueurEvent.clickIntoInventory(e);
	}
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e){
		joueur.JoueurEvent.playerQuit(e);
	}
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		joueur.JoueurEvent.playerJoin(e);
	}
	
 	
}

package main;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
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
		e.setCancelled(testStaff(e.getPlayer()));
	}
	
	@EventHandler
	public void noPlaceBlock(BlockPlaceEvent e){
		e.setCancelled(testStaff(e.getPlayer()));
	}
	
	@EventHandler
	public void breakBlock(BlockBreakEvent e){
		e.setCancelled(testStaff(e.getPlayer()));
	}
	
	@EventHandler
	public void clickSign(PlayerInteractEvent e){
		joueur.Event.interactEvent(e);
		signControl.Event.clickSign(e);
	}
	
	@EventHandler
	public void clickIntoInventory(InventoryClickEvent e){
		joueur.Event.clickIntoInventoryBoutiqueVIP(e);
		joueur.Event.clickIntoInventoryListeServeur(e);
		e.setCancelled(testStaff((Player)e.getWhoClicked())); //A gerer en car pb item
	}
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e){
		joueur.Event.playerQuit(e);
	}
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		joueur.Event.playerJoin(e);
	}
	
	@EventHandler
	public void playerRecupItem(PlayerPickupItemEvent e){
		e.setCancelled(testStaff(e.getPlayer()));
	}
	
	private static boolean testStaff(Player p){
		int checkStaff  = 4;
		int playerPower = joueur.Main.grade.get(p.getUniqueId()).getPower();
		if(playerPower > checkStaff){
			return true;
		}else{
			return false;
		}
	}
	
 	
}

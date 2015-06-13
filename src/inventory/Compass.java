package inventory;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Compass {
	
	public static Inventory getInventory(Player p){
		Inventory inv = Bukkit.createInventory(p, 9, "Liste des Serveurs");
		inv.setItem(0, Faction());
		inv.setItem(1, PvPBox());
		inv.setItem(2, RolePlay());
		inv.setItem(6, Rush());
		inv.setItem(7, Tower());
		inv.setItem(8, SexontheBeach());
		return inv;
	}
	
	private static ItemStack Faction(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Click pour se téléporter sur");
		lore.add("le PvP Faction");
		
		ItemStack item = new ItemStack(Material.OBSIDIAN);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("PvP Faction");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack PvPBox(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Click pour se téléporter dans");
		lore.add("la Pvp-Box");
		
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("PvP-Box");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack Rush(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Click pour se téléporter sur");
		lore.add("un serveur de Rush");
		
		ItemStack item = new ItemStack(Material.BED);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Rush");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack Tower(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Click pour se téléporter sur");
		lore.add("un serveur de Tower");
		
		ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Tower");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack SexontheBeach(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Click pour se téléporter sur");
		lore.add("un serveur de Sex on Beach");
		
		ItemStack item = new ItemStack(Material.WATER_BUCKET);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Sex on the Beach");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	private static ItemStack RolePlay(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Click pour se téléporter sur");
		lore.add("le serveur RolePlay");
		
		ItemStack item = new ItemStack(Material.WATCH);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("RolePlay");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	
	
	public static void clickInventory(InventoryClickEvent e){
		if(e.getWhoClicked() instanceof Player){
			Player p = (Player) e.getWhoClicked();
			if(e.getInventory().getName().equalsIgnoreCase(getInventory(p).getName())){
				if(e.getCurrentItem() !=null){
					ItemStack item = e.getCurrentItem();
					if(item.equals(Faction())){
						clickItem(p, "faction");
					}else if(item.equals(PvPBox())){
						clickItem(p, "pvpbox");
					}else if(item.equals(RolePlay())){
						clickItem(p, "rp");
					}
				}
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}
	
	private static void clickItem(Player p, String function){
		if(commServer.StartServer.function.containsKey(function)){
			String server = commServer.StartServer.function.get(function);
			ArrayList<String> msg = new ArrayList<>();  //Preparation pour envoyer un message a un autre serveur
			msg.add("sendJoueur");
			msg.add(p.getName());
			msg.add(p.getUniqueId().toString());
			msg.add(server);
			commServer.SendMessage.send(server, msg); //On envoi une demande au serveur qui doit recevoir le joueur
		}else{
			p.sendMessage("§4Le serveur est déconnecté, merci de réessayer plus tard");
		}
	}

}

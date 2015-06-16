package inventory;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Lobby {
	
	public static void getInventory(Player p){
		Inventory inv = p.getInventory();
		inv.clear();
		inv.setItem(0, getCompas());
		inv.setItem(7, getHead(p));
		inv.setItem(8, getEmeraude());
		inv.setItem(2, gadjetArmor.ArmorStand.getArmorStand());
	}
	
	public static ItemStack getCompas(){
		ItemStack item = new ItemStack(Material.COMPASS);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6§lTéléportation §r§7Click Droit");
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack getHead(Player p){
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setDisplayName("§6§l"+ p.getName() +" §r§7Click Droit");
		meta.setOwner(p.getName());
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack getEmeraude(){
		ItemStack item = new ItemStack(Material.EMERALD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6§lBoutique §r§7Click Droit");
		item.setItemMeta(meta);
		return item;
	}
	
}

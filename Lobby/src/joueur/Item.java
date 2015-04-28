package joueur;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
	
	public static ItemStack goldIngotMoney(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Pour acceder au");
		lore.add("menu des achats");
		ItemStack item = new ItemStack(Material.GOLD_INGOT);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Money");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack pumpkinVIP(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Pour acheter le VIP");
		lore.add("pour un mois");
		lore.add("");
		lore.add("Acheter le VIP pour");
		lore.add("plus longtemps sur notre site");
		lore.add("§1www.nitrogames.fr");
		ItemStack item = new ItemStack(Material.PUMPKIN);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Achat VIP");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack JackOLanternVIP(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("§4Impossible d'acheter le VIP");
		lore.add("");
		lore.add("Tu as déjà un VIP d'activer");
		ItemStack item = new ItemStack(Material.JACK_O_LANTERN);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Achat VIP");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
}

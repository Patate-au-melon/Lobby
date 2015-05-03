package joueur;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
	
	public static ItemStack accesBoutiqueVIP(){
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
	
	public static ItemStack joueurIsNotVIP(){
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
	
	public static ItemStack joueurIsVIP(){
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
	
	public static ItemStack accesAdminListServer(){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Acces à la liste des serveurs");
		lore.add("");
		lore.add("Réservé au staff");
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Acces Admin");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack serverIsOn(String serverName, String nbPlayer, String serverPort){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Il y a actuellement " + nbPlayer + " joueurs sur ce serveur");
		lore.add("Le serveur est connecté sur le port "+ serverPort);
		ItemStack item = new ItemStack(Material.WOOL);
		item.setDurability((short) 13);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§2§l"+serverName);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack serverIsOff(String serverName, String serverPort){
		ArrayList<String> lore = new ArrayList<>();
		lore.add("Le serveur est connecté sur le port "+ serverPort);
		ItemStack item = new ItemStack(Material.WOOL);
		item.setDurability((short) 14);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§4§l"+serverName);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

}

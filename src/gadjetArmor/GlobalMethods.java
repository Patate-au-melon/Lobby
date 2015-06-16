package gadjetArmor;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GlobalMethods {
	// Variables
	public static String ng = ChatColor.BLACK + "[" + ChatColor.RED + "N"
			+ ChatColor.BLACK + "-" + ChatColor.DARK_GRAY + "G"
			+ ChatColor.BLACK + "] " + ChatColor.YELLOW;
	protected static Inventory inv;
	static ItemStack errorItem = transItem(new ItemStack(Material.BARRIER),
			ChatColor.RED + "Indisponible", ChatColor.RED
					+ "Vous n'avez pas cet item");
	protected static ItemStack item = null;

	// Méthodes qu'on trouve partout
	public static String returnErrorPerm(String perms) {
		String perm = ng + ChatColor.RED + "Il vous faut la permission "
				+ perms;
		return perm;

	}

	private static ItemStack transItem(ItemStack item, String nom, String desc) {
		ItemMeta ItemMeta = item.getItemMeta();
		ItemMeta.setDisplayName(nom);
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(desc);
		ItemMeta.setLore(desclist);
		item.setItemMeta(ItemMeta);
		return item;
	}

	public static String returnErrorCMD(String cmd) {
		String com = ng + ChatColor.RED + "La commande est : " + cmd;
		return com;

	}

	public static void equipColoredArmor(Material mat, Player p, ItemStack item2) {
		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item2.getItemMeta();
		meta.setLore(new ArrayList<String>());
		item2.setItemMeta(meta);
		item.setItemMeta(item2.getItemMeta());
		if (mat == Material.LEATHER_HELMET) {
			p.getInventory().setHelmet(item);
		} else if (mat == Material.LEATHER_CHESTPLATE) {
			p.getInventory().setChestplate(item);
		} else if (mat == Material.LEATHER_BOOTS) {
			p.getInventory().setBoots(item);
		} else if (mat == Material.LEATHER_LEGGINGS) {
			p.getInventory().setLeggings(item);
		}
	}

	public static void equipArmor(Material mat, Player p) {
		ItemStack item = new ItemStack(mat);
		if ((mat == Material.CHAINMAIL_BOOTS)
				|| (mat == Material.DIAMOND_BOOTS)
				|| (mat == Material.IRON_BOOTS) || (mat == Material.GOLD_BOOTS)) {
			p.getInventory().setBoots(item);
		} else if ((mat == Material.CHAINMAIL_CHESTPLATE)
				|| (mat == Material.DIAMOND_CHESTPLATE)
				|| (mat == Material.IRON_CHESTPLATE)
				|| (mat == Material.GOLD_CHESTPLATE)) {
			p.getInventory().setChestplate(item);
		} else if ((mat == Material.CHAINMAIL_LEGGINGS)
				|| (mat == Material.DIAMOND_LEGGINGS)
				|| (mat == Material.IRON_LEGGINGS)
				|| (mat == Material.GOLD_LEGGINGS)) {
			p.getInventory().setLeggings(item);
		} else if ((mat == Material.CHAINMAIL_HELMET)
				|| (mat == Material.DIAMOND_HELMET)
				|| (mat == Material.IRON_HELMET)
				|| (mat == Material.GOLD_HELMET)) {
			p.getInventory().setHelmet(item);
		}
	}
}

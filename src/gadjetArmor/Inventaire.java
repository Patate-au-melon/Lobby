package gadjetArmor;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public abstract class Inventaire {
	protected Inventory inv;
	protected ItemStack item;
	protected static ItemStack errorItem = transItem(new ItemStack(
			Material.BARRIER), ChatColor.RED + "Indisponible", ChatColor.RED
			+ "Vous n'avez pas cet item", null);

	static ItemStack transItem(ItemStack item, String nom, String desc, Player p) {
		ItemMeta ItemMeta = item.getItemMeta();
		ItemMeta.setDisplayName(nom);
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(desc);
		ItemMeta.setLore(desclist);
		item.setItemMeta(ItemMeta);
		return item;
	}

	ItemStack transItem(ItemStack item, String nom, String desc, Player p,
			Color c) {
		ItemMeta ItemMeta = item.getItemMeta();
		ItemMeta.setDisplayName(nom);
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(desc);
		ItemMeta.setLore(desclist);
		item.setItemMeta(ItemMeta);
		LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
		armorMeta.setColor(c);
		item.setItemMeta(armorMeta);
		return item;
	}

	public abstract void openInv(Player p);
}

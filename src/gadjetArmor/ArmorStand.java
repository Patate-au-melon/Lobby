package gadjetArmor;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArmorStand {
	
	public static ItemStack getArmorStand(){
		ItemStack armorstand = new ItemStack(Material.ARMOR_STAND);
		ItemMeta ItemMeta = armorstand.getItemMeta();
		ItemMeta.setDisplayName(ChatColor.RED + "Garde" + ChatColor.WHITE + "-"
				+ ChatColor.DARK_GRAY + "Robe");
		ArrayList<String> desclist = new ArrayList<String>();
		desclist.add(ChatColor.YELLOW
				+ "Cliquez ici pour ouvrir la garde-robe !");
		ItemMeta.setLore(desclist);
		armorstand.setItemMeta(ItemMeta);
		return armorstand;
	}

}

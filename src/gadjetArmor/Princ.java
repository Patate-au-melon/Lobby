package gadjetArmor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class Princ extends Inventaire {

	@Override
	public void openInv(Player p) {
		inv = Bukkit.createInventory(null, InventoryType.HOPPER, ChatColor.RED
				+ "Garde" + ChatColor.WHITE + "-" + ChatColor.DARK_GRAY
				+ "Robe");
		ItemStack armMét = transItem(new ItemStack(Material.IRON_CHESTPLATE),
				ChatColor.RED + "Autres" + ChatColor.DARK_GRAY + " armures",
				ChatColor.BOLD + "" + ChatColor.DARK_GRAY
						+ "Menu des autres armures", p);
		ItemStack armCuir = transItem(
				new ItemStack(Material.LEATHER_CHESTPLATE), ChatColor.RED
						+ "Armures" + ChatColor.DARK_GRAY + " en cuir",
				ChatColor.BOLD + "" + ChatColor.DARK_GRAY
						+ "Menu des armures en cuir", p);
		inv.setItem(3, armMét);
		inv.setItem(1, armCuir);
		p.openInventory(inv);
	}

}

package gadjetArmor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Autres extends Inventaire {

	@Override
	public void openInv(Player p) {
		inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Autres"
				+ ChatColor.DARK_GRAY + " armures");
		ItemStack chesFer;
		if (p.hasPermission("ng.armor.chesFer")) {
			chesFer = transItem(new ItemStack(Material.IRON_CHESTPLATE),
					ChatColor.GRAY + "Plastron en fer", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron en fer !", p);
		} else {
			chesFer = errorItem;
		}
		inv.setItem(19, chesFer);
		ItemStack casFer = null;
		if (p.hasPermission("ng.armor.casFer")) {
			casFer = transItem(new ItemStack(Material.IRON_HELMET),
					ChatColor.GRAY + "Casque en fer", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque en fer !", p);
		} else {
			casFer = errorItem;
		}
		inv.setItem(10, casFer);
		if (p.hasPermission("ng.armor.pantFer")) {
			item = transItem(new ItemStack(Material.IRON_LEGGINGS),
					ChatColor.GRAY + "Pantalon en fer", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon en fer !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(28, item);
		ItemStack bootFer = null;
		if (p.hasPermission("ng.armor.bootFer")) {
			bootFer = transItem(new ItemStack(Material.IRON_BOOTS),
					ChatColor.GRAY + "Bottes en fer", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes en fer !", p);
		} else {
			bootFer = errorItem;
		}
		inv.setItem(37, bootFer);
		// diams
		ItemStack chesDiams;
		if (p.hasPermission("ng.armor.chesDiams")) {
			chesDiams = transItem(new ItemStack(Material.DIAMOND_CHESTPLATE),
					ChatColor.GRAY + "Plastron en diamant", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron en diamant !", p);
		} else {
			chesDiams = errorItem;
		}
		inv.setItem(23, chesDiams);
		ItemStack casDiams = null;
		if (p.hasPermission("ng.armor.casDiams")) {
			casDiams = transItem(new ItemStack(Material.DIAMOND_HELMET),
					ChatColor.GRAY + "Casque en diamant", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque en diamant !", p);
		} else {
			casDiams = errorItem;
		}
		inv.setItem(14, casDiams);
		if (p.hasPermission("ng.armor.pantDiams")) {
			item = transItem(new ItemStack(Material.DIAMOND_LEGGINGS),
					ChatColor.GRAY + "Pantalon en diamant", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon en diamant !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(32, item);
		ItemStack bootDiams = null;
		if (p.hasPermission("ng.armor.bootDiams")) {
			bootDiams = transItem(new ItemStack(Material.DIAMOND_BOOTS),
					ChatColor.GRAY + "Bottes en diamant", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes en diamant !", p);
		} else {
			bootDiams = errorItem;
		}
		inv.setItem(41, bootDiams);
		// or
		ItemStack chesOr;
		if (p.hasPermission("ng.armor.chesOr")) {
			chesOr = transItem(new ItemStack(Material.GOLD_CHESTPLATE),
					ChatColor.GRAY + "Plastron en or", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron en or !", p);
		} else {
			chesOr = errorItem;
		}
		inv.setItem(21, chesOr);
		ItemStack casOr = null;
		if (p.hasPermission("ng.armor.casOr")) {
			casOr = transItem(new ItemStack(Material.GOLD_HELMET),
					ChatColor.GRAY + "Casque en or", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque en or !", p);
		} else {
			casOr = errorItem;
		}
		inv.setItem(12, casOr);
		if (p.hasPermission("ng.armor.pantOr")) {
			item = transItem(new ItemStack(Material.GOLD_LEGGINGS),
					ChatColor.GRAY + "Pantalon en or", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon en or !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(30, item);
		ItemStack bootOr = null;
		if (p.hasPermission("ng.armor.bootOr")) {
			bootOr = transItem(new ItemStack(Material.GOLD_BOOTS),
					ChatColor.GRAY + "Bottes en or", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes en or !", p);
		} else {
			bootOr = errorItem;
		}
		inv.setItem(39, bootOr);
		// chained
		ItemStack chesCha;
		if (p.hasPermission("ng.armor.chesCha")) {
			chesCha = transItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE),
					ChatColor.GRAY + "Cotte de mailles", ChatColor.YELLOW
							+ "Cliquez pour mettre une cotte de mailles !", p);
		} else {
			chesCha = errorItem;
		}
		inv.setItem(25, chesCha);
		ItemStack casCha = null;
		if (p.hasPermission("ng.armor.casCha")) {
			casCha = transItem(new ItemStack(Material.CHAINMAIL_HELMET),
					ChatColor.GRAY + "Casque en mailles", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque en mailles !", p);
		} else {
			casCha = errorItem;
		}
		inv.setItem(16, casCha);
		if (p.hasPermission("ng.armor.pantCha")) {
			item = transItem(new ItemStack(Material.CHAINMAIL_LEGGINGS),
					ChatColor.GRAY + "Pantalon en mailles", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon en mailles !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(34, item);
		ItemStack bootCha = null;
		if (p.hasPermission("ng.armor.bootCha")) {
			bootCha = transItem(new ItemStack(Material.CHAINMAIL_BOOTS),
					ChatColor.GRAY + "Bottes en mailles", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes en mailles !", p);
		} else {
			bootCha = errorItem;
		}
		inv.setItem(43, bootCha);
		// arrow
		ItemStack arrow;
		arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
				+ "Retour", ChatColor.YELLOW + "Cliquez pour aller en arrière",
				p);
		inv.setItem(51, arrow);
		// tnt
		ItemStack destroy;
		destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
				+ "Supprimer l'armure", ChatColor.YELLOW
				+ "Cliquez pour réinitialiser l'armure", p);
		inv.setItem(47, destroy);
		p.openInventory(inv);
	}

}

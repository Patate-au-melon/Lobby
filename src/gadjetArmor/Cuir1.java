package gadjetArmor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Cuir1 extends Inventaire {

	@Override
	public void openInv(Player p) {
		inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Armures"
				+ ChatColor.DARK_GRAY + " en cuir");
		// red
		if (p.hasPermission("ng.armor.casLeaRed")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir rouge", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque rouge !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.RED);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(17, item);
		if (p.hasPermission("ng.armor.chesLeaRed")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron rouge", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron rouge !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.RED);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(26, item);
		if (p.hasPermission("ng.armor.pantLeaRed")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon rouge", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon rouge ! !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.RED);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(35, item);
		if (p.hasPermission("ng.armor.bootLeaRed")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes rouges", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes rouges !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.RED);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(44, item);
		// yellow
		if (p.hasPermission("ng.armor.casLeaYel")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir jaune", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque jaune !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.YELLOW);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(11, item);
		if (p.hasPermission("ng.armor.chesLeaYel")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron jaune", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron jaune !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.YELLOW);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(20, item);
		if (p.hasPermission("ng.armor.pantLeaYel")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon jaune", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon jaune !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.YELLOW);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(29, item);
		if (p.hasPermission("ng.armor.bootLeaYel")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes jaunes", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes jaunes !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.YELLOW);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(38, item);
		// bleu
		if (p.hasPermission("ng.armor.casLeaBlue")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir bleu", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque bleu !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLUE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(13, item);
		if (p.hasPermission("ng.armor.chesLeaBlue")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron bleu", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron bleu !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLUE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(22, item);
		if (p.hasPermission("ng.armor.pantLeaBlue")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon bleu", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon bleu !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLUE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(31, item);
		if (p.hasPermission("ng.armor.bootLeaBlue")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes bleus", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes bleues !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLUE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(40, item);
		// green
		if (p.hasPermission("ng.armor.casLeaGre")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir vert", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque vert !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GREEN);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(15, item);
		if (p.hasPermission("ng.armor.chesLeaGre")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron vert", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron vert !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GREEN);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(24, item);
		if (p.hasPermission("ng.armor.pantLeaGre")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon vert", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon vert !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GREEN);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(33, item);
		if (p.hasPermission("ng.armor.bootLeaGre")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes vertes", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes vertes !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GREEN);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(42, item);
		// normal
		if (p.hasPermission("ng.armor.casLeaNor")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir normal", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque normal !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(9, item);
		if (p.hasPermission("ng.armor.chesLeaNor")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron normal", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron normal !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(18, item);
		if (p.hasPermission("ng.armor.pantLeaNor")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon normal", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon normal ! !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(27, item);
		if (p.hasPermission("ng.armor.bootLeaNor")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes normales", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes normales !", p);
		} else {
			item = errorItem;
		}
		inv.setItem(36, item);
		// tnt
		ItemStack destroy;
		destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
				+ "Supprimer l'armure", ChatColor.YELLOW
				+ "Cliquez pour réinitialiser l'armure", p);
		inv.setItem(49, destroy);
		// arrow 2
		ItemStack arrow;
		arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
				+ "Page 2",
				ChatColor.YELLOW + "Cliquez pour aller à la page 2", p);
		inv.setItem(51, arrow);
		// arrow
		arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
				+ "Retour", ChatColor.YELLOW + "Cliquez pour aller en arrière",
				p);
		inv.setItem(47, arrow);
		p.openInventory(inv);

	}

}

package gadjetArmor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Cuir2 extends Inventaire {

	@Override
	public void openInv(Player p) {
		inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Armures"
				+ ChatColor.DARK_GRAY + " en cuir");
		// blanc
		if (p.hasPermission("ng.armor.casLeaWhi")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir blanc", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque blanc !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.WHITE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(17, item);
		if (p.hasPermission("ng.armor.chesLeaWhi")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron blanc", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron blanc !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.WHITE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(26, item);
		if (p.hasPermission("ng.armor.pantLeaWhi")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon blanc", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon blanc ! !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.WHITE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(35, item);
		if (p.hasPermission("ng.armor.bootLeaWhi")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes blanches", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes blanches !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.WHITE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(44, item);
		// violet
		if (p.hasPermission("ng.armor.casLeaVio")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir violet", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque violet !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.PURPLE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(11, item);
		if (p.hasPermission("ng.armor.chesLeaVio")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron violet", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron violet !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.PURPLE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(20, item);
		if (p.hasPermission("ng.armor.pantLeaVio")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon violet", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon violet !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.PURPLE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(29, item);
		if (p.hasPermission("ng.armor.bootLeaVio")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes violettes", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes violettes !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.PURPLE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(38, item);
		// noir
		if (p.hasPermission("ng.armor.casLeaBla")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir noir", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque noir !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLACK);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(13, item);
		if (p.hasPermission("ng.armor.chesLeaBla")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron noir", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron noir !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLACK);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(22, item);
		if (p.hasPermission("ng.armor.pantLeaBla")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon noir", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon noir !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLACK);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(31, item);
		if (p.hasPermission("ng.armor.bootLeaBla")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes noires", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes noires !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.BLACK);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(40, item);
		// orange
		if (p.hasPermission("ng.armor.casLeaOra")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir orange", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque orange !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.ORANGE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(15, item);
		if (p.hasPermission("ng.armor.chesLeaOra")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron orange", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron orange !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.ORANGE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(24, item);
		if (p.hasPermission("ng.armor.pantLeaOra")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon orange", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon orange !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.ORANGE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(33, item);
		if (p.hasPermission("ng.armor.bootLeaOra")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes oranges", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes oranges !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.ORANGE);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(42, item);
		// rose
		if (p.hasPermission("ng.armor.casLeaRos")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir rose", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque rose !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.FUCHSIA);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(9, item);
		if (p.hasPermission("ng.armor.chesLeaRos")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron rose", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron rose !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.FUCHSIA);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(18, item);
		if (p.hasPermission("ng.armor.pantLeaRos")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon rose", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon rose ! !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.FUCHSIA);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(27, item);
		if (p.hasPermission("ng.armor.bootLeaRos")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes roses", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes roses !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.FUCHSIA);
			item.setItemMeta(armorMeta);
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
		// arrow 1
		ItemStack arrow;
		arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
				+ "Page 1",
				ChatColor.YELLOW + "Cliquez pour aller à la page 1", p);
		inv.setItem(47, arrow);
		// arrow 3
		arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
				+ "Page 3",
				ChatColor.YELLOW + "Cliquez pour aller à la page 3", p);
		inv.setItem(51, arrow);
		p.openInventory(inv);
	}

}

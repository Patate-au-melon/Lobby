package gadjetArmor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Cuir3 extends Inventaire {

	@Override
	public void openInv(Player p) {
		inv = Bukkit.createInventory(null, 54, ChatColor.RED + "Armures"
				+ ChatColor.DARK_GRAY + " en cuir");
		// marron
		if (p.hasPermission("ng.armor.casLeaMar")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir marron", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque marron !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.MAROON);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(17, item);
		if (p.hasPermission("ng.armor.chesLeaMar")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron marron", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron marron !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.MAROON);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(26, item);
		if (p.hasPermission("ng.armor.pantLeaMar")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon marron", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon marron ! !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.MAROON);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(35, item);
		if (p.hasPermission("ng.armor.bootLeaMar")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes marron", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes marron !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.MAROON);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(44, item);
		// gris
		if (p.hasPermission("ng.armor.casLeaGri")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir gris", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque gris !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GRAY);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(11, item);
		if (p.hasPermission("ng.armor.chesLeaGri")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron gris", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron gris !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GRAY);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(20, item);
		if (p.hasPermission("ng.armor.pantLeaGri")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon gris", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon gris !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GRAY);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(29, item);
		if (p.hasPermission("ng.armor.bootLeaGri")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes gris", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes gris !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.GRAY);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(38, item);
		// vert clair
		if (p.hasPermission("ng.armor.casLeaLim")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir vert clair",
					ChatColor.YELLOW
							+ "Cliquez pour mettre un casque vert clair !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.LIME);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(13, item);
		if (p.hasPermission("ng.armor.chesLeaLim")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron vert clair", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron vert clair !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.LIME);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(22, item);
		if (p.hasPermission("ng.armor.pantLeaLim")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon vert clair", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon vert clair !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.LIME);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(31, item);
		if (p.hasPermission("ng.armor.bootLeaLim")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes vert clair", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes vert clair !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.LIME);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(40, item);
		// cyan
		if (p.hasPermission("ng.armor.casLeaCya")) {
			item = transItem(new ItemStack(Material.LEATHER_HELMET),
					ChatColor.GRAY + "Casque en cuir cyan", ChatColor.YELLOW
							+ "Cliquez pour mettre un casque cyan !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.AQUA);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(15, item);
		if (p.hasPermission("ng.armor.chesLeaCya")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.GRAY + "Plastron cyan", ChatColor.YELLOW
							+ "Cliquez pour mettre un plastron cyan !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.AQUA);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(24, item);
		if (p.hasPermission("ng.armor.pantLeaCya")) {
			item = transItem(new ItemStack(Material.LEATHER_LEGGINGS),
					ChatColor.GRAY + "Pantalon cyan", ChatColor.YELLOW
							+ "Cliquez pour mettre un pantalon cyan !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.AQUA);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(33, item);
		if (p.hasPermission("ng.armor.bootLeaCya")) {
			item = transItem(new ItemStack(Material.LEATHER_BOOTS),
					ChatColor.GRAY + "Bottes cyans", ChatColor.YELLOW
							+ "Cliquez pour mettre des bottes cyan !", p);
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
			armorMeta.setColor(Color.AQUA);
			item.setItemMeta(armorMeta);
		} else {
			item = errorItem;
		}
		inv.setItem(42, item);
		// multi-color
		if (p.hasPermission("ng.armor.armTechn")) {
			item = transItem(new ItemStack(Material.LEATHER_CHESTPLATE),
					ChatColor.RED + "A" + ChatColor.BLUE + "r"
							+ ChatColor.YELLOW + "m" + ChatColor.GREEN + "u"
							+ ChatColor.GOLD + "r" + ChatColor.AQUA + "e "
							+ ChatColor.LIGHT_PURPLE + "t"
							+ ChatColor.DARK_BLUE + "e" + ChatColor.WHITE + "c"
							+ ChatColor.BLACK + "h" + ChatColor.DARK_PURPLE
							+ "n" + ChatColor.GRAY + "i" + ChatColor.GOLD + ""
							+ ChatColor.BOLD + "color", ChatColor.GOLD
							+ "Cliquez pour mettre une armure technicolor !!!",
					p);
		} else {
			item = errorItem;
		}
		inv.setItem(18, item);
		// tnt
		ItemStack destroy;
		destroy = transItem(new ItemStack(Material.TNT), ChatColor.GRAY
				+ "Supprimer l'armure", ChatColor.YELLOW
				+ "Cliquez pour réinitialiser l'armure", p);
		inv.setItem(49, destroy);
		// arrow 2
		ItemStack arrow;
		arrow = transItem(new ItemStack(Material.ARROW), ChatColor.GRAY
				+ "Page 2", ChatColor.YELLOW + ""
				+ "Cliquez pour aller à la page 2", p);
		inv.setItem(47, arrow);
		p.openInventory(inv);
	}

}

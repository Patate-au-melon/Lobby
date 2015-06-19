package gadjetArmor;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
	String ng = GlobalMethods.ng;
	ItemStack armorstand;
	Main main;
	Inventaire princ = new Princ();
	Inventaire autres = new Autres();
	Inventaire cuir1 = new Cuir1();
	Inventaire cuir2 = new Cuir2();
	Inventaire cuir3 = new Cuir3();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("ng.armor.admin.clear")){
		} else {
			ItemStack itemAir = new ItemStack(Material.AIR);
			p.getInventory().setBoots(itemAir);
			p.getInventory().setChestplate(itemAir);
			p.getInventory().setLeggings(itemAir);
			p.getInventory().setHelmet(itemAir);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Material mat = p.getItemInHand().getType();
		if (mat == Material.ARMOR_STAND) {
			princ.openInv(p);
			p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onClic(InventoryClickEvent e) {
		try {
			if (e.getInventory()
					.getName()
					.equalsIgnoreCase(
							ChatColor.RED + "Garde" + ChatColor.WHITE + "-"
									+ ChatColor.DARK_GRAY + "Robe")) {
				try {
					Material current = e.getCurrentItem().getType();
					Player p = (Player) e.getWhoClicked();
					if (current == Material.IRON_CHESTPLATE) {
						autres.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (current == Material.LEATHER_CHESTPLATE) {
						cuir1.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					}
				} catch (NullPointerException ee) {
				} finally {
					e.setCancelled(true);
				}
			} else if (e
					.getInventory()
					.getName()
					.equalsIgnoreCase(
							ChatColor.RED + "Autres" + ChatColor.DARK_GRAY
									+ " armures")) {
				try {
					Material current = e.getCurrentItem().getType();
					Player p = (Player) e.getWhoClicked();
					if (current == Material.ARROW) {
						princ.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (current == Material.TNT) {
						ItemStack itemAir = new ItemStack(Material.AIR);
						p.getInventory().setBoots(itemAir);
						p.getInventory().setChestplate(itemAir);
						p.getInventory().setLeggings(itemAir);
						p.getInventory().setHelmet(itemAir);
						p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
					} else if (current == Material.AIR) {
					} else if (current == Material.BARRIER) {
						p.playSound(p.getLocation(), Sound.FALL_BIG, 1, 1);
					} else {
						GlobalMethods.equipArmor(current, p);
						p.playSound(p.getLocation(), Sound.SPLASH, 1, 1);
					}
				} catch (NullPointerException ee) {
				} finally {
					e.setCancelled(true);
				}
			} else if (e
					.getInventory()
					.getName()
					.equalsIgnoreCase(
							ChatColor.RED + "Armures" + ChatColor.DARK_GRAY
									+ " en cuir")) {
				try {
					Material current = e.getCurrentItem().getType();
					ItemStack item = e.getCurrentItem();
					Player p = (Player) e.getWhoClicked();
					if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 1")) {
						cuir1.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 2")) {
						cuir2.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Page 3")) {
						cuir3.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.equalsIgnoreCase(ChatColor.GRAY + "Retour")) {
						princ.openInv(p);
						p.playSound(p.getLocation(), Sound.CLICK, 1, 1);
					} else if (item
							.getItemMeta()
							.getDisplayName()
							.equalsIgnoreCase(
									ChatColor.GRAY + "Supprimer l'armure")) {
						ItemStack itemAir = new ItemStack(Material.AIR);
						p.getInventory().setBoots(itemAir);
						p.getInventory().setChestplate(itemAir);
						p.getInventory().setLeggings(itemAir);
						p.getInventory().setHelmet(itemAir);
						p.playSound(p.getLocation(), Sound.EXPLODE, 1, 1);
					} else if (item.getItemMeta().getDisplayName()
							.contains("color")) {
						// à faire !!!
					} else if (current == Material.BARRIER) {
						p.playSound(p.getLocation(), Sound.SPLASH, 1, 1);
					} else {
						GlobalMethods.equipColoredArmor(current, p, item);
						p.playSound(p.getLocation(), Sound.SPLASH, 1, 1);
					}
				} catch (NullPointerException ee) {
				} finally {
					e.setCancelled(true);
				}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

}

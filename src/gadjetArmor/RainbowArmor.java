package gadjetArmor;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class RainbowArmor implements Listener {
	
	public static boolean helmetB;
	public static boolean chestplateB;
	public static boolean leggingsB;
	public static boolean bootsB;
	public static ArrayList<Player> helmetP = new ArrayList<Player>();
	public static ArrayList<Player> chestplateP = new ArrayList<Player>();
	public static ArrayList<Player> leggingsP = new ArrayList<Player>();
	public static ArrayList<Player> bootsP = new ArrayList<Player>();
	public static int helmet;
	public static int chestplate;
	public static int leggings;
	public static int boots;

	public RainbowArmor() {
	}

	static ItemStack getColorArmor(Material m, Color c) {
		ItemStack i = new ItemStack(m, 1);
		i.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setColor(c);
		i.setItemMeta(meta);
		return i;
	}

	public static void launchTask() {
		helmetB = true;
		chestplateB = true;
		leggingsB = true;
		bootsB = true;
		try {
			helmet = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(main.Main.getPlugin(), new Runnable() {
						private Random r = new Random();

						public void run() {
							if (helmetB) {
								for (Player p : helmetP) {
									Color c = Color.fromRGB(r.nextInt(255),
											r.nextInt(255), r.nextInt(255));

									if (p.getInventory().getHelmet() != null
											&& p.getInventory().getHelmet()
													.getType() == Material.LEATHER_HELMET) {
										p.getInventory()
												.setHelmet(
														RainbowArmor
																.getColorArmor(
																		Material.LEATHER_HELMET,
																		c));
									}
								}
							} else {
								Bukkit.getScheduler().cancelTask(helmet);
								helmetB = true;
							}
						}
					}, 1, 8);

			chestplate = Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(main.Main.getPlugin(), new Runnable() {
						private Random r = new Random();

						public void run() {
							if (chestplateB) {
								for (Player p : chestplateP) {
									Color c2 = Color.fromRGB(r.nextInt(255),
											r.nextInt(255), r.nextInt(255));

									if (p.getInventory().getChestplate() != null
											&& p.getInventory().getChestplate()
													.getType() == Material.LEATHER_CHESTPLATE) {
										p.getInventory()
												.setChestplate(
														RainbowArmor
																.getColorArmor(
																		Material.LEATHER_CHESTPLATE,
																		c2));
									}
								}
							} else {
								Bukkit.getScheduler().cancelTask(chestplate);
								chestplateB = true;
							}
						}
					}, 1, 8);

			leggings = Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(main.Main.getPlugin(), new Runnable() {
						private Random r = new Random();

						@Override
						public void run() {
							if (leggingsB) {
								for (Player p : leggingsP) {
									Color c3 = Color.fromRGB(r.nextInt(255),
											r.nextInt(255), r.nextInt(255));

									if (p.getInventory().getLeggings() != null
											&& p.getInventory().getLeggings()
													.getType() == Material.LEATHER_LEGGINGS) {
										p.getInventory()
												.setLeggings(
														RainbowArmor
																.getColorArmor(
																		Material.LEATHER_LEGGINGS,
																		c3));
									}
								}
							} else {
								Bukkit.getScheduler().cancelTask(leggings);
								leggingsB = true;
							}
						}
					}, 1, 8);

			boots = Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(main.Main.getPlugin(), new Runnable() {
						private Random r = new Random();

						@Override
						public void run() {
							if (bootsB) {
								for (Player p : bootsP) {
									Color c4 = Color.fromRGB(r.nextInt(255),
											r.nextInt(255), r.nextInt(255));

									if (p.getInventory().getBoots() != null
											&& p.getInventory().getBoots()
													.getType() == Material.LEATHER_BOOTS) {
										p.getInventory().setBoots(
												RainbowArmor.getColorArmor(
														Material.LEATHER_BOOTS,

														c4));
									}
								}
							} else {
								Bukkit.getScheduler().cancelTask(boots);
								bootsB = true;
							}
						}
					}, 1, 8);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory()
				.getName()
				.equalsIgnoreCase(
						ChatColor.RED + "Armures" + ChatColor.DARK_GRAY
								+ " en cuir")) {
			e.setCancelled(true);
			if (e.getCurrentItem() == null)
				return;

			if (e.getCurrentItem() != null
					&& e.getCurrentItem().hasItemMeta()
					&& e.getCurrentItem().getItemMeta().hasDisplayName()
					&& e.getCurrentItem()
							.getItemMeta()
							.getDisplayName()
							.contains(
									ChatColor.RED + "A" + ChatColor.BLUE + "r"
											+ ChatColor.YELLOW + "m"
											+ ChatColor.GREEN + "u"
											+ ChatColor.GOLD + "r"
											+ ChatColor.AQUA + "e "
											+ ChatColor.LIGHT_PURPLE + "t"
											+ ChatColor.DARK_BLUE + "e"
											+ ChatColor.WHITE + "c"
											+ ChatColor.BLACK + "h"
											+ ChatColor.DARK_PURPLE + "n"
											+ ChatColor.GRAY + "i"
											+ ChatColor.GOLD + ""
											+ ChatColor.BOLD + "color")) {
				p.getWorld().playSound(p.getLocation(), Sound.SPLASH, 1, 1);

				p.getInventory().setHelmet(
						new ItemStack(Material.LEATHER_HELMET));
				if (!helmetP.contains(p))
					helmetP.add(p);
				p.getInventory().setChestplate(
						new ItemStack(Material.LEATHER_CHESTPLATE));
				if (!chestplateP.contains(p))
					chestplateP.add(p);
				p.getInventory().setLeggings(
						new ItemStack(Material.LEATHER_LEGGINGS));
				if (!leggingsP.contains(p))
					leggingsP.add(p);
				p.getInventory()
						.setBoots(new ItemStack(Material.LEATHER_BOOTS));
				if (!bootsP.contains(p))
					bootsP.add(p);
				p.closeInventory();
			} else if (e.getCurrentItem() == null) {
			} else if (e.getCurrentItem().getType() == Material.LEATHER_HELMET) {
				if (helmetP.contains(p))
					helmetP.remove(p);
			} else if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE) {
				if (chestplateP.contains(p))
					chestplateP.remove(p);
			} else if (e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS) {
				if (leggingsP.contains(p))
					leggingsP.remove(p);
			} else if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
				if (bootsP.contains(p))
					bootsP.remove(p);
			} else if (e.getCurrentItem().getType() == Material.TNT) {
				if (bootsP.contains(p))
					bootsP.remove(p);
				if (leggingsP.contains(p))
					leggingsP.remove(p);
				if (chestplateP.contains(p))
					chestplateP.remove(p);
				if (helmetP.contains(p))
					helmetP.remove(p);
			}
		}
	}

}

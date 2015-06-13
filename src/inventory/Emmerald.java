package inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Emmerald {
	
	public static Inventory getInventory(Player p){
		Inventory inv = Bukkit.createInventory(p, 54, "Boutique");
		
		return inv;
	}

}

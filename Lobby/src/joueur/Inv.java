package joueur;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class Inv {
	
	public static Inventory MoneyVIP(Player p){
		UUID uuid = p.getUniqueId();
		Inventory inv = Bukkit.createInventory(p, InventoryType.HOPPER, "Tu as §6§l" + Main.moneyVIP.get(uuid) + "§r NitroCoins");
		if(Main.grade.get(uuid).getPower() <= 5){ // C'est un VIP
			inv.setItem(2, Item.JackOLanternVIP());
		}else{ //Ce n'est pas un VIP
			inv.setItem(2, Item.pumpkinVIP());
		}
		return inv;
	}

}

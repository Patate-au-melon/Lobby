package joueur;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class JoueurEvent{
	
	public static void playerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		UUID uuid= p.getUniqueId();
		if(Main.grade.containsKey(uuid)){ //Le joueur c'est deja connecte sur le serveur
			if(Main.server.get(uuid).equalsIgnoreCase("lobby")){ //Le joueur etait sur le lobby
				prepareJoueurToLobby(p);
			}else{ //Le joueur n'etait pas sur le lobby
				String server = Main.server.get(uuid);
				new server.SendMessage(server, "sendJoueur", uuid.toString());
			}
		}else{ //Le joueur n'etait pas sur le serveur
			ArrayList<ArrayList<String>> list = main.Api.BdDsendRequette("SELECT * FROM `listJoueur`");
			boolean test = false;
			for(ArrayList<String> l : list){
				if(l.get(1).equalsIgnoreCase(uuid.toString()) && l.get(0).equalsIgnoreCase(p.getName())){
					Main.grade.put(uuid, object.Grade.getGrade(l.get(2)));
					Main.moneyMiniGames.put(uuid, Integer.parseInt(l.get(3)));
					Main.moneyVIP.put(uuid, Integer.parseInt(l.get(4)));
					Main.multiplicateur.put(uuid, Integer.parseInt(l.get(5)));
					test = true;
					break;
				}
			}
			if(test == false){
				Main.grade.put(uuid, object.Grade.getGrade("Joueur"));
				Main.moneyMiniGames.put(uuid, 0);
				Main.moneyVIP.put(uuid, 0);
				Main.multiplicateur.put(uuid, 0);
				String requette = "insert into `listJoueur` (`name`, `UUID`, `grade`, `moneyMiniGames`, `moneyVIP`, `multiplicateur`)" + "values (?,?,?,?,?,?)";
				try {
					PreparedStatement prepa = main.Api.cn.prepareStatement(requette);
					prepa.setString(1, p.getName());
					prepa.setString(2, uuid.toString());
					prepa.setString(3, "Joueur");
					prepa.setString(4, "0");
					prepa.setString(5, "0");
					prepa.setString(6, "0");
					prepa.execute();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			prepareJoueurToLobby(p);
		}
	}
	
	public static void playerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		joueur.Main.grade.remove(p.getUniqueId());
		joueur.Main.moneyMiniGames.remove(p.getUniqueId());
		joueur.Main.moneyVIP.remove(p.getUniqueId());
		joueur.Main.multiplicateur.remove(p.getUniqueId());
	}
	
	private static void prepareJoueurToLobby(Player p){	
		Inventory inv = p.getInventory();
		ItemStack item = Item.goldIngotMoney();
		inv.setItem(8, item);
		p.updateInventory();
	}
	
	public static void clickInventoryGodlIngot(PlayerInteractEvent e){
		Player p = e.getPlayer();
		ItemStack item = p.getItemInHand();
		if(item.getType() == Item.goldIngotMoney().getType() && item.getItemMeta().getDisplayName().equalsIgnoreCase(Item.goldIngotMoney().getItemMeta().getDisplayName())){
			p.openInventory(Inv.MoneyVIP(p));
		}
	}
	
	public static void clickIntoInventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem().getType() == Material.JACK_O_LANTERN){
			p.closeInventory();
			p.sendMessage("§4Tu es déjà VIP, tu ne peux pas cummuler deux VIP en même temps");
		}else if(e.getCurrentItem().getType() == Material.PUMPKIN){
			int m = joueur.Main.moneyVIP.get(p.getUniqueId()) - 1500;
			if(m >= 0){
				String requette = "UPDATE `listJoueur` SET `grade`=?,`moneyVIP`=? WHERE `UUID` = ?";
				try {
					PreparedStatement prepa = main.Api.cn.prepareStatement(requette);
					prepa.setString(1, "VIP");
					prepa.setString(2, m+"");
					prepa.setString(3, p.getUniqueId().toString());
					prepa.execute();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				p.sendMessage("§6Tu viens de passer VIP pour un mois, il te reste " + m );
				joueur.Main.grade.replace(p.getUniqueId(), object.Grade.getGrade("VIP"));
				joueur.Main.moneyVIP.replace(p.getUniqueId(), m);
			}else{
				p.sendMessage("§4Tu n'as pas assez d'argent, tu peux en acheter sur §r§1nitrogames.fr");
			}
		}
	}

}

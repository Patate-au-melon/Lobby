package joueur;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.Map.Entry;

import main.Api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import server.SendMessage;

public class Inv {
	
	public static HashMap<String, Integer> nbPlayer;
	
	//Inventaire de la boutique VIP
	public static Inventory moneyVIP(Player p){
		UUID uuid = p.getUniqueId();
		Inventory inv = Bukkit.createInventory(p, InventoryType.HOPPER, "Tu as §6§l" + Main.moneyVIP.get(uuid) + "§r NitroCoins");
		if(Main.grade.get(uuid).getPower() < 7){ // C'est un VIP
			inv.setItem(2, Item.joueurIsVIP());
		}else{ //Ce n'est pas un VIP
			inv.setItem(2, Item.joueurIsNotVIP());
		}
		return inv;
	}
	
	//Inventaire de la liste des serveurs
	public static Inventory listeServer(Player p){
		for(Entry<String, Socket> entry : server.ServerMain.listServer.entrySet()){
			String server = entry.getKey();
			new SendMessage(server, "countPlayer", "a");
		}
		Inventory inv = Bukkit.createInventory(p, 54, "Liste des serveurs");
		ArrayList<ArrayList<String>> list = Api.BdDsendRequette("SELECT * FROM `listServer`");
		for(int i = 0 ; i<list.size(); i++){
			ArrayList<String> l = list.get(i);
			String serverName = l.get(0);
			String serverPort = l.get(1);
			if(server.ServerMain.listServer.containsKey(serverName)){ //Le serveur est connecte
				inv.setItem(i, Item.serverIsOn(serverName, nbPlayer.get(serverName) +"", serverPort));
			}else{ //Le serveur est deconnecte
				inv.setItem(i, Item.serverIsOff(serverName, serverPort));
			}
			
			if(serverName.equalsIgnoreCase(main.Config.getServerInfo().getString("name")) && serverPort.equalsIgnoreCase(main.Config.getServerInfo().getString("port"))){
				inv.setItem(i, Item.serverIsOn(serverName, Bukkit.getOnlinePlayers().size() +"", serverPort));
			}
		}
		return inv;
	}
	
	//Inventaire pour start un serveur eteint
	public static Inventory demarageServeur(Player p, String server){
		Inventory inv = Bukkit.createInventory(p, InventoryType.HOPPER, "Serveur " + server);
		
		return inv;
	}

}

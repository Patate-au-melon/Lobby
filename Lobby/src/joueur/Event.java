package joueur;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import main.Api;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Event{
	
	public static int prixVIP = 1500;
	public static int prixVIPPlus = 5000;
	
	public static void playerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		UUID uuid= p.getUniqueId();
		if(Main.server.containsKey(uuid)){ //Le joueur c'est deja connecte sur le serveur
			if(Main.server.get(uuid).equalsIgnoreCase("lobby")){ //Le joueur etait sur le lobby, ne doit pas être possible
				prepareJoueurToLobby(p);
				System.out.println("Merci de prevenir jeje2208 si vous voyez ce message dans la console."); //Ligne de prevention en cas d'arriver de cette situation pour voir si il y a une erreur
				p.sendMessage("Bonjour, tu as déclanché une erreur merci de bien vouloir prendre contact avec le staff, et plus particulièrement jeje2208");
				p.sendMessage("Merci d'aider le serveur dans son développement");
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
					Main.server.put(uuid, "Lobby");
					test = true;
					break;
				}
			}
			if(test == false){
				Main.grade.put(uuid, object.Grade.getGrade("Joueur"));
				Main.moneyMiniGames.put(uuid, 0);
				Main.moneyVIP.put(uuid, 0);
				Main.multiplicateur.put(uuid, 0);
				Main.server.put(uuid, "Lobby");
				String requette = "insert into `listJoueur` (`name`, `UUID`, `grade`, `moneyMiniGames`, `moneyVIP`, `multiplicateur`)" + "values (?,?,?,?,?,?)";
				String[] l = {p.getName(), p.getUniqueId().toString(), "Joueur", "0", "0", "0"};
				main.Api.BdDsendRequetteNoReturn(requette, l);
				}
			Api.sendTitle(p, "NitroGames", "", 60);
			prepareJoueurToLobby(p);
		}
	}
	
	public static void playerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(Main.server.get(p.getUniqueId()).equalsIgnoreCase("Lobby")){ //Le joueur se deco du serveur
			joueur.Main.grade.remove(p.getUniqueId());
			joueur.Main.moneyMiniGames.remove(p.getUniqueId());
			joueur.Main.moneyVIP.remove(p.getUniqueId());
			joueur.Main.multiplicateur.remove(p.getUniqueId());
			joueur.Main.server.remove(p.getUniqueId());
		}else{ //Le joueur va sur un de nos serveurs
			
		}
	}
	
	private static void prepareJoueurToLobby(Player p){	//Inventaire que le joueur a sur le lobby
		Inventory inv = p.getInventory();
		//Pour ajouter l'item de la boutique VIP
		ItemStack item = Item.accesBoutiqueVIP();
		inv.setItem(8, item);
		if(Main.grade.get(p.getUniqueId()).getPower() < 2){ // c'est un membre du staff
			inv.setItem(0, Item.accesAdminListServer());
		}
		p.updateInventory();
	}
	
	public static void interactEvent(PlayerInteractEvent e){
		Player p = e.getPlayer();
		ItemStack item = p.getItemInHand();
		if(item.equals(Item.accesBoutiqueVIP()) && item != null){ //Ouverture de la boutique VIP
			p.openInventory(Inv.moneyVIP(p));
		}else if(item.equals(Item.accesAdminListServer()) && item != null){ //Ouverture de la liste des serveurs
			p.openInventory(Inv.listeServer(p));
		}
	}
	
	public static void clickIntoInventoryBoutiqueVIP(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		UUID uuid = p.getUniqueId();
		if(e.getInventory().getName().equalsIgnoreCase(Inv.moneyVIP(p).getName())){//Inventaire boutique VIP
			ItemStack item = e.getCurrentItem();
			if(item != null){ //Verification que l'on click sur un item
				if(item.equals(Item.joueurIsVIP()) || item.equals(Item.joueurIsVIPPlus())){ //Le joueur a deja un grade, pas besoin qu'il en est un autre
					p.closeInventory();
					p.sendMessage("§4Tu es déjà "+ Main.grade.get(uuid).getName());
				}else if(item.equals(Item.joueurIsNotVIPFor1Month())){ //Le joueur n'est pas VIP
					int money = Main.moneyVIP.get(uuid) - prixVIP;
					if(money >= 0){ //Le joueur peut se payer le VIP
						updateGrade("VIP", 1, p, money);
						p.closeInventory();
						p.sendMessage("§6Tu viens de passer VIP pour un mois, il te reste §l" + money  + "§r§6 NitroCoins");
					}else{ //Le joueur ne peut pas se payer le VIP
						p.closeInventory();
						p.sendMessage("§4Tu n'as pas assez d'argent, tu peux en acheter sur §r§1nitrogames.fr");
					}
				}else if(item.equals(Item.joueurIsNotVIPFor3Months())){
					int money = Main.moneyVIP.get(uuid) - prixVIP * 3;
					if(money >= 0){ //Le joueur peut se payer le VIP
						updateGrade("VIP", 3, p, money);
						p.closeInventory();
						p.sendMessage("§6Tu viens de passer VIP pour trois mois, il te reste §l" + money  + "§r§6 NitroCoins");
					}else{ //Le joueur ne peut pas se payer le VIP
						p.closeInventory();
						p.sendMessage("§4Tu n'as pas assez d'argent, tu peux en acheter sur §r§1nitrogames.fr");
					}
				}else if(item.equals(Item.joueurIsNotVIPPlusFor1Months())){
					int money = Main.moneyVIP.get(uuid) - prixVIPPlus;
					if(money >= 0){ //Le joueur peut se payer le VIP
						updateGrade("VIP+", 1, p, money);
						p.closeInventory();
						p.sendMessage("§6Tu viens de passer VIP+ pour un mois, il te reste §l" + money  + "§r§6 NitroCoins");
					}else{ //Le joueur ne peut pas se payer le VIP
						p.closeInventory();
						p.sendMessage("§4Tu n'as pas assez d'argent, tu peux en acheter sur §r§1nitrogames.fr");
					}
				}else if(item.equals(Item.joueurIsNotVIPPlusFor3Months())){
					int money = Main.moneyVIP.get(uuid) - prixVIPPlus * 3;
					if(money >= 0){ //Le joueur peut se payer le VIP
						updateGrade("VIP+", 3, p, money);
						p.closeInventory();
						p.sendMessage("§6Tu viens de passer VIP+ pour trois mois, il te reste §l" + money  + "§r§6 NitroCoins");
					}else{ //Le joueur ne peut pas se payer le VIP
						p.closeInventory();
						p.sendMessage("§4Tu n'as pas assez d'argent, tu peux en acheter sur §r§1nitrogames.fr");
					}
				}
			}
			e.setCancelled(true);
		}
	}
	
	public static void clickIntoInventoryListeServeur(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase(Inv.listeServer(p).getName())){
			p.closeInventory();
			e.setCancelled(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	private static void updateGrade(String Grade, int MonthTime, Player p, int money){
		String requette = "UPDATE `listJoueur` SET `grade`=?,`moneyVIP`=? WHERE `UUID` =?";
		String[] l = {Grade,money +"", p.getUniqueId().toString()};
		main.Api.BdDsendRequetteNoReturn(requette, l);
		requette = "INSERT INTO `Vip` (`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?, ?, ?, NOW(), ?)";
		Date date = new Date(System.currentTimeMillis());
		date.setMonth(date.getMonth() +MonthTime);
		String[] li = {p.getName(), p.getUniqueId().toString(), Grade, date.toString()};
		main.Api.BdDsendRequetteNoReturn(requette, li);
		requette = "INSERT INTO `VipHistory` (`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?, ?, ?, NOW(), ?)";
		main.Api.BdDsendRequetteNoReturn(requette, li);
		Main.grade.replace(p.getUniqueId(), object.Grade.getGrade(Grade));
		Main.moneyVIP.replace(p.getUniqueId(), money);
	}

}

package joueur;

import java.util.ArrayList;
import java.util.UUID;

import main.Grade;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;

public class Event {
	
	
	//Event lorsqu'un joueur se connecte au serveur
	public static void playerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		UUID id = p.getUniqueId();
		if(Joueur.server.containsKey(id)){ //Le joueur est deja sur le serveur
			Joueur.getJoueurData(p);
			if(Joueur.server.get(id).equalsIgnoreCase(Bukkit.getServerName())){ //Le joueur revient d'un autre serveur
				prepareJoueurToLobby(p);
			}else{ //Le joueur n'etait pas sur le lobby
				String server = Joueur.server.get(id);
				ArrayList<String> msg = new ArrayList<>();
				msg.add("sendJoueur");
				msg.add(p.getName());
				msg.add(p.getUniqueId().toString());
				commServer.SendMessage.send(server, msg); //On essaye de renvoyer le joueur sur le serveur ou il se trouvait
			}
		}else{ //Le joueur vient de se connecter
			if(Joueur.getJoueurData(p) == false){ //Le joueur se connecte pour le premiere fois
				String requette = "INSERT INTO `listJoueur`(`name`, `UUID`, `grade`, `money`, `multiplicateur`) VALUES (?,?,?,?,?)";
				String[] list = {p.getName(), id.toString(), "Joueur", "0", "0"};
				main.Api.BdDsendRequetteNoReturn(requette, list);
				Bukkit.getLogger().info(p.getName()+" vient de se connecter pour la premiere fois sur le serveur");
			}
			Joueur.getJoueurData(p);
			prepareJoueurToLobby(p);
			main.Api.sendTitle(p, "§6§lBienvenue sur NITROGAMES", "", 20); //Affichage d'un message a l'ecran
		}
	}
	
	private static void prepareJoueurToLobby(Player p){	//Inventaire que le joueur a sur le lobby
		inventory.Lobby.getInventory(p);
		p.teleport(p.getWorld().getSpawnLocation());
		p.setGameMode(GameMode.SURVIVAL);
		Grade g = Joueur.grade.get(p.getUniqueId());
		if(g.getPower() <= 15 && g.getPower() >10){ //Joueur VIP double jump
			Joueur.doubleJump.add(p.getUniqueId());
		}else if(g.getPower() <= 10){ //Staff Fly
			p.setAllowFlight(true);
		}
		p.setFlying(false);
		p.setExp(0);
	}
	
	public static void playerClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getItem() != null){
				ItemStack item = e.getItem();
				if(item.equals(inventory.Lobby.getCompas())){
					p.openInventory(inventory.Compass.getInventory(p));
				}else if(item.getType().equals(Material.SKULL_ITEM)){
					p.openInventory(inventory.Head.getInventory(p));
				}else if(item.equals(inventory.Lobby.getEmeraude())){
					p.openInventory(inventory.Emmerald.getInventory(p));
				}
			}
		}
	}
	
	public static void playerQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		UUID id = p.getUniqueId();
		if(Joueur.server.get(id).equalsIgnoreCase(Bukkit.getServerName())){
			Joueur.grade.remove(id);
			Joueur.money.remove(id);
			Joueur.server.remove(id);
			Joueur.doubleJump.remove(id);
		}
	}
	
	public static void toggleFlight(PlayerToggleFlightEvent e){
		Player p = e.getPlayer();
		if(Joueur.doubleJump.contains(p.getUniqueId())){
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
		}
	}
	
	public static void PlayerMove(PlayerMoveEvent e){
		Player p =e.getPlayer();
		if(Joueur.doubleJump.contains(p.getUniqueId())){
			if(p.getLocation().subtract(0,1,0).getBlock().getType() != Material.AIR && p.isFlying() == false ){
				p.setAllowFlight(true);
			}
		}
	}
	
}

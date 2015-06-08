package joueur;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event {
	
	
	//Event lorsqu'un joueur se connecte au serveur
	public static void playerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		UUID id = p.getUniqueId();
		if(Joueur.server.containsKey(id)){ //Le joueur est deja sur le serveur
			Joueur.getJoueurData(p);
			if(Joueur.server.get(id).equalsIgnoreCase("lobby")){ //Le joueur revient d'un autre serveur
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
			main.Api.sendTitle(p, "Bienvenue sur NITROGAMES", "Serveur multi-pole", 20); //Affichage d'un message a l'ecran
		}
	}
	
	private static void prepareJoueurToLobby(Player p){	//Inventaire que le joueur a sur le lobby
	/*	Inventory inv = p.getInventory();
		//Pour ajouter l'item de la boutique VIP
		ItemStack item = Item.accesBoutiqueVIP();
		inv.setItem(8, item);
		if(Joueur.grade.get(p.getUniqueId()).getPower() < 2){ // c'est un membre du staff
			inv.setItem(0, Item.accesAdminListServer());
		}
		p.updateInventory();
		*/
		p.sendMessage("preparation pour le lobby");
	}
	
}

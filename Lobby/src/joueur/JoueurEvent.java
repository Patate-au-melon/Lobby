package joueur;

import java.util.Iterator;

import main.Main;
import object.Joueur;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoueurEvent implements Listener{
	
	public JoueurEvent(Main main) {
	}

	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Joueur j = null;
		e.setJoinMessage("");
		if(object.Joueur.joueurList.contains(object.Joueur.getJoueur(p.getName()))){
			j = object.Joueur.getJoueur(p.getName());
			if(j.getGrade().getName().equalsIgnoreCase("Admin")){
				Iterator<? extends Player> it = Bukkit.getOnlinePlayers().iterator();
				while(it.hasNext()){
					Player pl = it.next();
					pl.sendMessage("§4" + p.getName() + " §7vient de se connecter sur le lobby");
				}
			}
		}else{
			j = new object.Joueur(p);
		}
		setName(p, j); 
	}
	
	private void setName(Player p, Joueur j){
		switch(j.getGrade().getName()){
		case "Admin":
			p.setCustomName("§4[Admin]"+p.getName());
			break;
		case "Dev":
			p.setCustomName("§2[Dev]"+p.getName());
			break;
		case "Joueur":
			
			break;
		}
		
	}
	
	@EventHandler
	public void playerJoin(EntityDamageEvent e){
		if(e.getEntityType() == EntityType.PLAYER){
			e.setCancelled(true);
		}
	}

}

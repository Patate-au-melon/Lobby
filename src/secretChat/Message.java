package secretChat;

import joueur.Joueur;
import main.Grade;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Message {
	
	public static void sendMessage(int power, String msg){
		for(Player p : Bukkit.getOnlinePlayers()){
			Grade g = Joueur.staffGrade.get(p.getUniqueId());
			if(g.getPower()== power){ //Personne du meme grade
				p.sendMessage(msg);
			}else if(g.getPower() <=2){ //Admin / Dev
				p.sendMessage(msg);
			}
		}
	}

}

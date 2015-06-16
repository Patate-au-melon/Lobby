package joueur;

import java.util.UUID;

import main.Grade;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Cmd_setGrade {
	
	
	public static void setGrade(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("setgrade") && sender instanceof Player){
			Player p = (Player) sender;
			UUID id = p.getUniqueId();
			Grade g = Joueur.staffGrade.get(id);
			if(g.getPower() <=2){ //Check que le power est ok
				if(args.length == 2){ //On verifie que l'on a le bon nombre d'argument
					Grade gl = main.Grade.getGrade(args[0]);
					if(gl != null){ //On verifie que le grade existe
						if(gl.getPower() >= g.getPower()){ //On vérifie que le nouveau grade n'est pas plus fort que le grade actuel
							Player pl = Bukkit.getPlayer(args[1]);
							if(pl != null){ //On verifie si le joueur est co 
								UUID ii = pl.getUniqueId();
								if(g.getPower() < Joueur.staffGrade.get(ii).getPower()){ //On verifie que l'on ne touche pas au grade d'une personne plus haute 
									Joueur.staffGrade.remove(ii);
									Joueur.staffGrade.put(ii, gl);
									String[] l = {gl.getName(), ii.toString()};
									main.Api.BdDsendRequetteNoReturn("UPDATE `listJoueur` SET `staffGrade` = ? WHERE `UUID` = ?", l);
									pl.sendMessage("§2Ton grade vient d'être modifié");
									pl.sendMessage("§2Tu es maintenant §6"+gl.getName());
									
									p.sendMessage("§2Tu viens de passer §6" + pl.getName() + " " + gl.getName());
									
									Joueur.prepareJoueurToLobby(pl);
								}else{
									p.sendMessage("§4Vous ne pouvez pas déstituer ce joueur");
								}
							}else{
								String[] li = {gl.getName(), args[1]};
								main.Api.BdDsendRequetteNoReturn("UPDATE `listJoueur` SET `staffGrade` = ? WHERE `name` = ?", li);
								p.sendMessage("§2Tu viens de passer §6" + args[1] + " " + gl.getName());
							}
						}else{
							p.sendMessage("§4Vous ne pouvez promouvoir cette personne au grade " + gl.getName());
						}
					}else{
						p.sendMessage("§4Le grade choisi n'est pas correcte");
					}
				}else{
					p.sendMessage("Nombre d'arguments incorrect");
					p.sendMessage("§4Utilisation : /setGrade [NewGarde] [PlayerName]");
				}
			}else{
				p.sendMessage("§4Vous n'avez pas la permission d'utiliser cette commande");
			}
		}else if(label.equalsIgnoreCase("setgrade")){ //Execution depuis la console
			if(args.length == 2){
				Grade gl = main.Grade.getGrade(args[0]);
				if(gl != null){ //on verifie que le grade existe
					Player pl = Bukkit.getPlayer(args[1]);
					if(pl != null){ //on verifie si le joueur est co
						UUID ii = pl.getUniqueId();
						Joueur.staffGrade.remove(ii);
						Joueur.staffGrade.put(ii, gl);
						String[] l = {gl.getName(), ii.toString()};
						main.Api.BdDsendRequetteNoReturn("UPDATE `listJoueur` SET `staffGrade` = ? WHERE `UUID` = ?", l);
						pl.sendMessage("§2Ton grade vient d'être modifié");
						pl.sendMessage("§2Tu es maintenant §6"+gl.getName());
						
						sender.sendMessage("§2Tu viens de passer §6" + pl.getName() + " " + gl.getName());
						
						Joueur.prepareJoueurToLobby(pl);
					}else{
						String[] li = {gl.getName(), args[1]};
						main.Api.BdDsendRequetteNoReturn("UPDATE `listJoueur` SET `staffGrade` = ? WHERE `name` = ?", li);
						sender.sendMessage("§2Tu viens de passer §6" + args[1] + " " + gl.getName());
					}
				}else{
					sender.sendMessage("§4Le grade choisi n'est pas correcte");
				}
			}else{
				sender.sendMessage("Nombre d'arguments incorrect");
				sender.sendMessage("§4Utilisation : /setGrade [NewGarde] [PlayerName]");
			}
		}
	}
	
	
	
}

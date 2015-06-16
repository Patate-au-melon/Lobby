package joueur;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import main.Grade;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd_addVip {
	
	//addVip grade playerName nbMois
	
	@SuppressWarnings("deprecation")
	public static void addVip(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("addVIp") && sender instanceof Player){ //Commande faite par un joueur
			Player p = (Player) sender;
			UUID id = p.getUniqueId();
			Grade g = Joueur.staffGrade.get(id);
			if(g.getPower() <=2){
				if(args.length == 3 && Integer.parseInt(args[2]) >=1){ //Check qu'il y a le bon nombre d'argument
					Grade gl = Grade.getGrade(args[0]);
					int nbMois = Integer.parseInt(args[2]);
					if(gl != null){ //check que le Grade existe
						Player pl = Bukkit.getPlayer(args[1]);
						if(pl != null){ //check si le joueur est co
							UUID il = pl.getUniqueId();
						
							//Recuperation des dates de debut et de fin
							Date d1 = new Date(System.currentTimeMillis());
							Date d2 = new Date(System.currentTimeMillis());
							int month = d2.getMonth() + nbMois;
							d2.setMonth(month);
							
							//Mise a jour de la base de donnee
							String requette = "INSERT INTO `Vip`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
							String[] list = {pl.getName(), il.toString(), gl.getName(), d1.getTime()+"", d2.getTime()+""};
							main.Api.BdDsendRequetteNoReturn(requette, list);
							
							requette = "INSERT INTO `VipHistory`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
							String[] list3 = {args[1], il.toString(), gl.getName(), d1.toString(), d2.toString()};
							main.Api.BdDsendRequetteNoReturn(requette, list3);
							
							requette = "UPDATE `listJoueur` SET `grade` =? WHERE `UUID` = ?";
							String[] list2 = {gl.getName(), il.toString()};
							main.Api.BdDsendRequetteNoReturn(requette, list2);
							
							//Mise a jour du grade sur le serveur
							Joueur.grade.remove(il);
							Joueur.grade.put(il, gl);
							Joueur.prepareJoueurToLobby(pl);
							
							//Envoie des messages au joueurs
							pl.sendMessage("§2Tu viens d'obtenir le grade §6" + gl.getName() + "§2 pour un durée de §6" + nbMois + "§2 mois");
							p.sendMessage("§2Tu viens de passer §6"+pl.getName()+" " + gl.getName() + "§2 pour un durée de §6" + nbMois + "§2 mois");
							
						}else{ //Le joueur n'est pas co
							//Recuperation des dates de debut et de fin
							Date d1 = new Date(System.currentTimeMillis());
							Date d2 = new Date(System.currentTimeMillis());
							int month = d2.getMonth() + nbMois;
							d2.setMonth(month);
							
							//Recuperation du UUID
							String requette = "SELECT `UUID` FROM `listJoueur` WHERE `name` = ?";
							String[] list = {args[1]};
							ArrayList<ArrayList<String>> l = main.Api.BdDsendRequette(requette, list);
							UUID il = UUID.fromString(l.get(0).get(0));
							
							//Mise a jour de la base de donnee
							requette = "INSERT INTO `Vip`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
							String[] list1 = {args[1], il.toString(), gl.getName(), d1.getTime()+"", d2.getTime()+""};
							main.Api.BdDsendRequetteNoReturn(requette, list1);
							
							requette = "INSERT INTO `VipHistory`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
							String[] list3 = {args[1], il.toString(), gl.getName(), d1.toString(), d2.toString()};
							main.Api.BdDsendRequetteNoReturn(requette, list3);
							
							requette = "UPDATE `listJoueur` SET `grade` =? WHERE `UUID` = ?";
							String[] list2 = {gl.getName(), il.toString()};
							main.Api.BdDsendRequetteNoReturn(requette, list2);
							
							p.sendMessage("§2Tu viens de passer §6"+args[1]+" " + gl.getName() + "§2 pour un durée de §6" + nbMois + "§2 mois");
						}
					}else{
						p.sendMessage("§4Le grade choisi n'est pas corecte");
					}
				}else{
					p.sendMessage("Erreur avec les arguments");
					p.sendMessage("§4Utilisation : /setGrade [NewGarde] [PlayerName] [NombreMois]");
				}
			}else{
				p.sendMessage("§4Vous n'avez pas la permission d'utiliser cette commande");
			}
		}else if(label.equalsIgnoreCase("addVIP")){ //Commande faite par la console
			if(args.length == 3 && Integer.parseInt(args[2]) >=1){ //Check qu'il y a le bon nombre d'argument
				Grade gl = Grade.getGrade(args[0]);
				int nbMois = Integer.parseInt(args[2]);
				if(gl != null){ //check que le Grade existe
					Player pl = Bukkit.getPlayer(args[1]);
					if(pl != null){ //check si le joueur est co
						UUID il = pl.getUniqueId();
					
						//Recuperation des dates de debut et de fin
						Date d1 = new Date(System.currentTimeMillis());
						Date d2 = new Date(System.currentTimeMillis());
						int month = d2.getMonth() + nbMois;
						d2.setMonth(month);
						
						//Mise a jour de la base de donnee
						String requette = "INSERT INTO `Vip`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
						String[] list = {pl.getName(), il.toString(), gl.getName(), d1.getTime()+"", d2.getTime()+""};
						main.Api.BdDsendRequetteNoReturn(requette, list);
						
						requette = "INSERT INTO `VipHistory`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
						String[] list3 = {args[1], il.toString(), gl.getName(), d1.toString(), d2.toString()};
						main.Api.BdDsendRequetteNoReturn(requette, list3);
						
						requette = "UPDATE `listJoueur` SET `grade` =? WHERE `UUID` = ?";
						String[] list2 = {gl.getName(), il.toString()};
						main.Api.BdDsendRequetteNoReturn(requette, list2);
						
						//Mise a jour du grade sur le serveur
						Joueur.grade.remove(il);
						Joueur.grade.put(il, gl);
						Joueur.prepareJoueurToLobby(pl);
						
						//Envoie des messages au joueurs
						pl.sendMessage("§2Tu viens d'obtenir le grade §6" + gl.getName() + "§2 pour un durée de §6" + nbMois + "§2 mois");
						sender.sendMessage("§2Tu viens de passer §6"+pl.getName()+" " + gl.getName() + "§2 pour un durée de §6" + nbMois + "§2 mois");
						
					}else{ //Le joueur n'est pas co
						//Recuperation des dates de debut et de fin
						Date d1 = new Date(System.currentTimeMillis());
						Date d2 = new Date(System.currentTimeMillis());
						int month = d2.getMonth() + nbMois;
						d2.setMonth(month);
						
						//Recuperation du UUID
						String requette = "SELECT `UUID` FROM `listJoueur` WHERE `name` = ?";
						String[] list = {args[1]};
						ArrayList<ArrayList<String>> l = main.Api.BdDsendRequette(requette, list);
						UUID il = UUID.fromString(l.get(0).get(0));
						
						//Mise a jour de la base de donnee
						requette = "INSERT INTO `Vip`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
						String[] list1 = {args[1], il.toString(), gl.getName(), d1.getTime()+"", d2.getTime()+""};
						main.Api.BdDsendRequetteNoReturn(requette, list1);
						
						requette = "INSERT INTO `VipHistory`(`name`, `uuid`, `grade`, `dateOfBegin`, `dateOfEnd`) VALUES (?,?,?, ?, ?)";
						String[] list3 = {args[1], il.toString(), gl.getName(), d1.toString(), d2.toString()};
						main.Api.BdDsendRequetteNoReturn(requette, list3);
						
						requette = "UPDATE `listJoueur` SET `grade` =? WHERE `UUID` = ?";
						String[] list2 = {gl.getName(), il.toString()};
						main.Api.BdDsendRequetteNoReturn(requette, list2);
						
						sender.sendMessage("§2Tu viens de passer §6"+args[1]+" " + gl.getName() + "§2 pour un durée de §6" + nbMois + "§2 mois");
					}
				}else{
					sender.sendMessage("§4Le grade choisi n'est pas corecte");
				}
			}else{
				sender.sendMessage("Erreur avec les arguments");
				sender.sendMessage("§4Utilisation : /setGrade [NewGarde] [PlayerName] [NombreMois]");
			}
		}
	}
	
}

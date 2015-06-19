package secretChat;

import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Map.Entry;

import joueur.Joueur;
import main.Grade;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd {
	
	//sc bla blas
	
	public static void ReceiveCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(label.equalsIgnoreCase("sc") && sender instanceof Player){
			Player p = (Player) sender;
			UUID id = p.getUniqueId();
			Grade g = Joueur.staffGrade.get(id);
			if(g.getPower() < 20){ //Check si c'est un membre du staff
				if(g.getPower() <=2){ //Check si c'est un Dev/Admin
					if(args.length > 1 && (args[0].equalsIgnoreCase("Admin") || args[0].equalsIgnoreCase("Modo") || args[0].equalsIgnoreCase("Helper") || args[0].equalsIgnoreCase("Builder") || args[0].equalsIgnoreCase("a")|| args[0].equalsIgnoreCase("m")|| args[0].equalsIgnoreCase("b")|| args[0].equalsIgnoreCase("h"))){
						int power = 0;
						String chat="";
						if(args[0].equalsIgnoreCase("Admin") || args[0].equalsIgnoreCase("a")){ //Envoi sur le chat admin
							power = 1;
							chat = "Admin";
						}else if(args[0].equalsIgnoreCase("Modo")|| args[0].equalsIgnoreCase("m")){ //Envoi sur le chat modo
							power = 3;
							chat = "Modo";
						}else if(args[0].equalsIgnoreCase("Helper")|| args[0].equalsIgnoreCase("h")){ //Envoi sur le chat Helper
							power = 5;
							chat = "Helper";
						}else if(args[0].equalsIgnoreCase("Builder")|| args[0].equalsIgnoreCase("b")){
							power = 9;
							chat = "Builder";
						}
						
						String msg = g.getPrefixe()+"SecretChat "+ p.getName() +" "+chat+"§r :";
						for(String m : args){
							if((args[0].endsWith(m)) == false){
							msg = msg + " " + m;
							}
						}
						
						
						//envoi du message sur les autres serveurs
						for(Entry<String, Socket> entry : commServer.StartServer.listServer.entrySet()){
							String server = entry.getKey();
							ArrayList<String> message = new ArrayList<>();
							message.add("secretChat");
							message.add(power+"");
							message.add(msg);
							commServer.SendMessage.send(server, message);
						}
						
						//On envoi sur le serveur
						Message.sendMessage(power, msg);
						
					}else{
						p.sendMessage("Utilisation : /sc [Admin/Modo/Helper/Builder] Ton Message");
					}
					
				}else{
					if(args.length > 0){
						//Recuperation du messaege
						String msg = g.getPrefixe()+"SecretChat " + p.getName() +"§r :";
						for(String m : args){
							msg = msg + " " + m;
						}
						
						//envoi du message sur les autres serveurs
						for(Entry<String, Socket> entry : commServer.StartServer.listServer.entrySet()){
							String server = entry.getKey();
							ArrayList<String> message = new ArrayList<>();
							message.add("secretChat");
							message.add(g.getPower()+"");
							message.add(msg);
							commServer.SendMessage.send(server, message);
						}
						
						//On envoi sur le serveur
						Message.sendMessage(g.getPower(), msg);
					}else{
						p.sendMessage("§4Tu dois mettre un message");
					}
				}
			}else{
				p.sendMessage("§4tu n'as pas la permission d'utiliser cette commande");
			}
		}
	}

}

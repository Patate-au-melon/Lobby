package commServer;

import java.util.ArrayList;

import signControl.Panneau;

public class Transmition {
	
	//Recupération de tous les messages
	static void transmit(String server, ArrayList<String> message){
		function(server, message);
		signControl.Message.receive(server, message); //Vers la gestion des panneaux
		joueur.Message.transfertJoueur(server, message);
		joueur.Message.sendMessageJoueur(server, message);
		secretChat.ReceiveSever.receive(server, message);
	}
	
	private static void function(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("sendFunction")){
			if(StartServer.function.containsValue(server)){
				StartServer.function.remove(message.get(1));
				StartServer.function.put(message.get(1), server);
			}else{
				StartServer.function.put(message.get(1), server);
			}
		}else if(message.get(0).equalsIgnoreCase("removeFunction")){
			if(StartServer.function.containsValue(server)){
				StartServer.function.remove(message.get(1));
				String[] line = {"", "§4Serveur", "§4Déconnecté", ""};
				Panneau pan = signControl.Panneau.getPanneau(server);
				pan.setLine(line);
			}
		}
	}

}

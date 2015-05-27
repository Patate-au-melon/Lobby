package signControl;

import java.util.ArrayList;

public class Message {
	
	
	//Reception de message depuis le serveur de communication intra-serveurs
	public static void receive(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("signControl Update")){  //Verification que l'on a le bon message
			Panneau pan = Panneau.getPanneau(server);  //On recupere le panneau
			pan.setServerState(true);
			pan.setLine(message.get(1), message.get(2), message.get(3), message.get(4)); //On modifie le texte sur le panneau en fonction du message
		}
	}
	
}

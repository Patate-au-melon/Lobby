package joueur;

import java.util.UUID;

public class ReceiveMessage {
	
	public static void receive(String server, String label, String message){
		if(label.equalsIgnoreCase("nbPlayer")){
			if(Inv.nbPlayer.containsKey(server)){ //Le serveur est deja dans le hashMap
				Inv.nbPlayer.replace(server, Integer.parseInt(message));
			}else{ //Le serveur n'est pas dans le hashMap
				Inv.nbPlayer.put(server, Integer.parseInt(message));
			}
		}else if(label.equalsIgnoreCase("returnLobby")){
			Main.server.replace(UUID.fromString(message), "Lobby");
		}
	}

}

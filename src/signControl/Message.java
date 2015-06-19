package signControl;

import java.util.ArrayList;

public class Message {
	
	
	//Reception de message depuis le serveur de communication intra-serveurs
	public static void receive(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("signControl Update")){  //Verification que l'on a le bon message
			Panneau pan = Panneau.getPanneau(server);  //On recupere le panneau
			pan.setServerState(true);
			//On recup le message depuis la base de donnee
			String requette = "SELECT * FROM `signText` WHERE `server` = ? && `system` = ? ORDER BY `signLine` ASC";
			String[] list = {server, message.get(1)};
			ArrayList<ArrayList<String>> li = main.Api.BdDsendRequette(requette, list);
			String[] line = {"", "", "", ""};
			int msg = 2;
			for(int i =0; i<4; i++){
				
				String m = li.get(i).get(3);
				String[] mi = m.split("&");
				m = mi[0];
				
				for(String ml : mi){
					if(m != ml){
						m = m + message.get(msg) + ml;
						msg= msg+1;
					}
				}
				
				line[i] = m;
			}
			pan.setLine(line); //On modifie le texte sur le panneau en fonction du message
		}
	}
	
}

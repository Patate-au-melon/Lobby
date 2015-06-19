package secretChat;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Map.Entry;

public class ReceiveSever {
	
	public static void receive(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("secretChat")){
			
			//On redirige vers les autres serveurs
			for(Entry<String, Socket> entry : commServer.StartServer.listServer.entrySet()){
				String s = entry.getKey();
				if(server.equalsIgnoreCase(s) == false){
					commServer.SendMessage.send(s, message);
				}
			}
			
			
			//On envoie sur le serveur
			int power = Integer.parseInt(message.get(1));
			String msg = message.get(2);
			Message.sendMessage(power, msg);
			
		}
	}

}

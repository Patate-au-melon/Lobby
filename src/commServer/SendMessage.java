package commServer;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SendMessage {
	
	static boolean sendInProgress;
	static ArrayList<String> listServer; 
	static ArrayList<ArrayList<String>> listMessage; 
	
	//Envoyer un message à un autre serveur
	public static void send(String server, ArrayList<String> message){
		if(!sendInProgress){
			Socket s = StartServer.listServer.get(server);
			try {
				sendInProgress = true;
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				pw.println("start");
				pw.flush();
				for(String m : message){
					pw.println(m);
					pw.flush();
				}
				pw.println("stop");
				pw.flush();
				sendInProgress = false;
				sendListMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			listServer.add(server);
			listMessage.add(message);
		}
	}
	
	public static void send(String server, String message){
		if(!sendInProgress){
			Socket s = StartServer.listServer.get(server);
			String[] msg = message.split(" ");
			try {
				sendInProgress = true;
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				pw.println("start");
				pw.flush();
				for(String m : msg){
					pw.println(m);
					pw.flush();
				}
				pw.println("stop");
				pw.flush();
				sendInProgress = false;
				sendListMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			ArrayList<String> m = new ArrayList<>();
			String[] msg = message.split(" ");
			for(String mm : msg){
				m.add(mm);
			}
			listServer.add(server);
			listMessage.add(m);
		}
	}
	
	
	private static boolean sendListMessage(){
		if(!sendInProgress || listMessage.isEmpty() == false){
			for(ArrayList<String> msg : listMessage){
				int l = listMessage.indexOf(msg);
				send(listServer.get(l), listMessage.get(l));
				return true;
			}
		}
		return false;
	}
}
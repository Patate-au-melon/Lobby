package server;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendMessage {
	
	private String server;
	private String label;
	private String msg;
	
	public SendMessage(String server, String label, String message){
		this.server = server;
		this.label = label;
		this.msg= message;
		send();
	}
	
	private void send(){
		if(ServerMain.listServer.containsKey(this.server)){
			try {
				Socket s = ServerMain.listServer.get(this.server);
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				String serverName = main.Config.getServerInfo().getString("name");
				pw.println(serverName + " " + this.label +" "+ this.msg+"\n");
				pw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

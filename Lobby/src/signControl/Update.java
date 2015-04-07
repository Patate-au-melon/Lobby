package signControl;

import java.net.Socket;
import java.util.Map.Entry;

import org.bukkit.Bukkit;

import server.ServerMain;


public class Update {
	
	public Update(){
		for(Entry<String, Socket> entry : ServerMain.listServer.entrySet()) {
			String server = entry.getKey();
			new server.SendMessage(server, "sign", "update");
		}
		
	}
	
	public Update(String server){
		if(ServerMain.listServer.containsKey(server)){
			new server.SendMessage(server, "sign", "update");
		}
	}
	
	public static void boucle(){
		Bukkit.getScheduler().scheduleSyncDelayedTask(main.Main.getPlugin(), new Runnable(){

			@Override
			public void run() {
				new Update();
			}
			
		}, 6000);
	}

}

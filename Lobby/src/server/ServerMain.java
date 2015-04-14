package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ServerMain extends BukkitRunnable{
	
	public static ServerSocket ss;
	public static HashMap<String, Socket> listServer;
	
	public ServerMain() {
		listServer = new HashMap<String, Socket>();
	}
	
	@Override
	public void run() {
		try {
			ss = new ServerSocket(25600);
			Bukkit.getLogger().info("Serveur de communication entre serveur actif");
			while(true){
				Socket s = ss.accept();
				String serverName = main.Config.getListServerNameConfig().getString(""+s.getPort());
				listServer.put(serverName, s);
				Bukkit.getLogger().info(serverName+" vient de se connecter au lobby avec le port  "+s.getPort());
				new ReceiveMessage(s).runTaskAsynchronously(main.Main.getPlugin());
				new signControl.Update(serverName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnect(){
		for(Entry<String, Socket> entry : listServer.entrySet()){
			String server = entry.getKey();
			new SendMessage(server, "stop", "");
		}
	}
	
	

}

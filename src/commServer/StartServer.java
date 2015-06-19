package commServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartServer extends BukkitRunnable{
	
	public static HashMap<String, Socket> listServer;
	public static HashMap<String, String> function;
	
	protected String lobbyName;
	protected int lobbyPort;
	private static ServerSocket ss;

	
	//constructeur principale
	public StartServer(String lobbyName, int lobbyPort) {
		this.lobbyName = lobbyName;
		this.lobbyPort = lobbyPort;
		StartServer.listServer = new HashMap<>();
		function = new HashMap<>();
		SendMessage.listMessage = new ArrayList<>();
		SendMessage.listServer = new ArrayList<>();
		this.runTaskAsynchronously(main.Main.getPlugin());
	}
	
	@Override
	public void run() {
		try {
			ss = new ServerSocket(this.lobbyPort);
			Bukkit.getLogger().info("Le serveur de communication est actif");
			while(true){
				Socket s = ss.accept();
				new ReceptionMessage(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void onDisable(){
		for(Entry<String, Socket> entry : listServer.entrySet()){
			String server = entry.getKey();
			Socket s = entry.getValue();
			try {
				s.close();
				Bukkit.getLogger().info(server+" vient d'etre deconnecte");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			ss.close();
		} catch (IOException e) {
			Bukkit.getLogger().info("Deconnexion du serveur");
		}
	}

}

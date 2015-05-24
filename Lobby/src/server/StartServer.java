package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartServer extends BukkitRunnable{
	
	public static HashMap<String, Socket> listServer;
	
	protected String lobbyName;
	protected int lobbyPort;
	private ServerSocket ss;

	
	//constructeur principale
	public StartServer(String lobbyName, int lobbyPort) {
		this.lobbyName = lobbyName;
		this.lobbyPort = lobbyPort;
		StartServer.listServer = new HashMap<>();
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

}

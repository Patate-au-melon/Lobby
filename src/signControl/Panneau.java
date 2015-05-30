package signControl;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;


public class Panneau {
	
	public static HashMap<String, Panneau> listPanneau;
	
	private String server;
	private boolean serverState;
	
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	
	private Location loc;
	
	//Constructeur 
	public Panneau(String server, Location signLocation){
		this.server = server;
		serverState = false;
		Block block = signLocation.getBlock();
		if(block.getType().equals(Material.WALL_SIGN)){
			this.loc = signLocation;
		}
		this.line1 = "";
		this.line2 = "§4Serveur";
		this.line3 = "§4Déconnecté";
		this.line4 = "";
		this.updateSign();
		listPanneau.put(this.server, this);
	}
	
	
	//Mettre a jour un panneau
	public void updateSign(){
		try{
			Sign s = (Sign) this.loc.getBlock().getState();
			s.setLine(0, this.line1);
			s.setLine(1, this.line2);
			s.setLine(2, this.line3);
			s.setLine(3, this.line4);
			s.update();
		}catch(Exception e){
			Bukkit.getLogger().info("Impossible de modifier le panneau lie au serveur "+ this.server);
			Bukkit.getScheduler().scheduleSyncDelayedTask(main.Main.getPlugin(), new Runnable(){

				@Override
				public void run() {
					updateSign();
				}
				
			}, 40);
		}
	}
	
	//Modifier le texte d'un panneau 1ere methode
	public void setLine(String[] line){
		this.line1 = line[0];
		this.line2 = line[1];
		this.line3 = line[2];
		this.line4 = line[3];
		this.updateSign();
	}
	
	
	//Modifier le texte d'un panneau 2eme methode
	public void setLine(String line1, String line2, String line3, String line4){
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.line4 = line4;
		this.updateSign();
	}
	
	
	//Recuperation du serveur lie a ce panneau
	public String getServer(){
		return this.server;
	}
	
	
	//Recuperation d'un panneau avec le nom du serveur
	public static Panneau getPanneau(String server){
		if(listPanneau.containsKey(server)){
			return listPanneau.get(server);
		}
		return null;
	}
	
	
	//Recuperation d'un panneau avec sa Location
	public static Panneau getPanneau(Location panneauLocation){
		for(HashMap.Entry<String, Panneau> entry : listPanneau.entrySet()){
			Panneau pan = entry.getValue();
			if(pan.loc.equals(panneauLocation)){
				return pan;
			}
		}
		return null;
	}
	
	//Recuperer si le serveur est connecte sur ce panneau
	public boolean getServerState(){
		return this.serverState;
	}
	
	public void setServerState(boolean serverState){
		this.serverState = serverState;
	}

}

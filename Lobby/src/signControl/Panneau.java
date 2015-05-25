package signControl;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;


public class Panneau {
	
	public static HashMap<String, Panneau> listPanneau;
	
	private String server;
	
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	
	private Sign sign;
	
	//Constructeur 
	public Panneau(String server, Location signLocation){
		this.server = server;
		Block block = signLocation.getBlock();
		if(block.getType().equals(Material.WALL_SIGN)){
			this.sign = (Sign) block.getState();
		}
		this.line1 = "";
		this.line2 = "§4Serveur";
		this.line3 = "§4Déconnecté";
		this.line4 = "";
		this.updateSign();
		listPanneau.put(this.server, this);
	}
	
	
	//Mettre a jour un panneau
	private void updateSign(){
		this.sign.setLine(0, this.line1);
		this.sign.setLine(1, this.line2);
		this.sign.setLine(2, this.line3);
		this.sign.setLine(3, this.line4);
		this.sign.update();
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
	
	public String getServer(){
		return this.server;
	}
	
	public static Panneau getPanneau(String server){
		if(listPanneau.containsKey(server)){
			return listPanneau.get(server);
		}
		return null;
	}
	
	public static Panneau getPanneau(Location panneauLocation){
		for(HashMap.Entry<String, Panneau> entry : listPanneau.entrySet()){
			Panneau pan = entry.getValue();
			if(pan.sign.getLocation().equals(panneauLocation)){
				return pan;
			}
		}
		return null;
	}

}

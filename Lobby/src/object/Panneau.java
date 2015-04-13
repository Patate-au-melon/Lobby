package object;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class Panneau {
	
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	private Location loc;
	private String server;
	
	public static ArrayList<Panneau> listSign;
	
	public Panneau(String server, Location location){
		this.server = server;
		this.loc = location;
		Block bl = this.loc.getBlock();
		if(bl.getType() == Material.WALL_SIGN || bl.getType() == Material.SIGN_POST){
			listSign.add(this);
		}
	}
	
	public void setSign(String line1, String line2, String line3, String line4){
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.line4 = line4;
		update();
	}
	
	public static Panneau getPanneau(String serveur){
		for(int i = 0;i<listSign.size();i++){
			Panneau p = listSign.get(i);
			if(p.server.equalsIgnoreCase(serveur))
				return p;
		}
		return null;
	}
	
	private void update(){
		try{
			Sign s = (Sign) this.loc.getBlock().getState();
			s.setLine(0, this.line1);
			s.setLine(1, this.line2);
			s.setLine(2, this.line3);
			s.setLine(3, this.line4);
			s.update();
		}catch(Exception e){
			System.out.println("mise a jour du panneau impossible");
			waitTime();
		}
	}
	
	private void waitTime(){
		//a faire avec un scheduler
		//et une simple fonction qui va relancer l'update tant qu'il n'arrive pas a update
	}
	

}

package object;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;

public class Panneau {
	
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	private Location loc;
	private String server;
	
	public static ArrayList<Panneau> listSign;
	public static HashMap<Location, String> listLoc;
	
	public Panneau(String server, Location location){
		this.server = server;
		this.loc = location;
		listLoc.put(loc, server);
		listSign.add(this);
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
	
	public static Panneau getPanneau(Location loc){
		for(Panneau pn : listSign){
			if(pn.loc == loc){
				return pn;
			}
		}
		return null;
	}
	
	public String getServer(){
		return this.server; 
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
			waitTime(this);
		}
	}
	
	private void waitTime(final Panneau p){
		Bukkit.getScheduler().scheduleSyncDelayedTask(main.Main.getPlugin(), new Runnable(){

			@Override
			public void run() {
				p.update();
			}
			
		}, 120);
	}
	

}

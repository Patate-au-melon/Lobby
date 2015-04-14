package signControl;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class DemarageSetup {
	
	public DemarageSetup(){
		ArrayList<ArrayList<String>> list = main.ApiBaseDeDonnee.sendRequette("SELECT * FROM `signList`");
		for(int i = 0; i <list.size();i++){
			ArrayList<String> l = list.get(i);
			Location loc = new Location(Bukkit.getWorld(l.get(0)), Integer.parseInt(l.get(1)), Integer.parseInt(l.get(2)), Integer.parseInt(l.get(3)));
			String[] line= null;
			String m = "0 1 2 3 "+ main.Config.getSignControl().getString("line1")+" "+main.Config.getSignControl().getString("line2")+" "+main.Config.getSignControl().getString("line3")+" "+main.Config.getSignControl().getString("line4");
			line = m.split(" ");
			try{
				Bukkit.getLogger().info("Mise a jour du panneau");
				Receive.updateSign(loc, line);
			}catch(Exception e){
				Receive.listSign.put(loc, line);
				Receive.boucle();
			}
		}
	}

}

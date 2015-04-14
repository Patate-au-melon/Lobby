package newSignControl;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Startup {
	
	public Startup(){
		ArrayList<ArrayList<String>> list = main.ApiBaseDeDonnee.sendRequette("SELECT * FROM `signList`");
		for(int i = 0; i <list.size();i++){
			ArrayList<String> l = list.get(i);
			String server = l.get(0);
			Location loc = new Location(Bukkit.getWorld(l.get(1)), Integer.parseInt(l.get(2)), Integer.parseInt(l.get(3)), Integer.parseInt(l.get(4)));
			String line1 = main.Config.getSignControl().getString("line1");
			String line2 = main.Config.getSignControl().getString("line2");
			String line3 = main.Config.getSignControl().getString("line3");
			String line4 = main.Config.getSignControl().getString("line4");
			new object.Panneau(server, loc).setSign(line1, line2, line3, line4);
		}
		Bukkit.getLogger().info("Mise a jour des panneaux");
	}

}

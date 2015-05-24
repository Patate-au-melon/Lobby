package signControl;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Message {
	
	
	//Reception de message depuis le serveur de communication intra-serveurs
	public static void receive(String server, ArrayList<String> message){
		if(message.get(0).equalsIgnoreCase("signControl Update")){
			Panneau pan = Panneau.getPanneau(server);
			pan.setLine(message.get(1), message.get(2), message.get(3), message.get(4));
		}else if(message.get(0).equalsIgnoreCase("signControl Create")){
			String[] l = message.get(1).split(" ");
			World world = Bukkit.getWorld(l[0]);
			int x = Integer.parseInt(l[1]);
			int y = Integer.parseInt(l[2]);
			int z = Integer.parseInt(l[3]);
			Location loc = new Location(world, x, y, z);
			Panneau pan = new Panneau(server, loc);
			pan.setLine(message.get(2), message.get(3), message.get(4), message.get(5));
		}
	}
	
}

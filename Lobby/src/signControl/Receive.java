package signControl;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class Receive {

	private Location loc;
	public static HashMap<Location, String[]> listSign;
	
	public Receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			String[] msg = message.split(" ");
			if(msg.length == 8){
				World w = Bukkit.getWorld(msg[0]);
				int x = Integer.parseInt(msg[1]);
				int y = Integer.parseInt(msg[2]);
				int z = Integer.parseInt(msg[3]);
				this.loc = new Location(w, x, y, z);
				try{
					updateSign(loc, msg);
				}catch(Exception e){
					if(listSign.containsKey(loc)){
						listSign.replace(loc, msg);
					}else{
						listSign.put(loc, msg);
					}
					boucle();
				}
			}
		}
	}
	
	public static void updateSign(Location loc, String[] line){
		Block b = loc.getBlock();
		if(b.getType() == Material.WALL_SIGN){
			Sign sign = (Sign) b.getState();
			for(int i =0;i<4;i++){
				String[] li = line[i+4].split(":");
				String lin = li[0];
				for(int n=1;n<li.length;n++){
					lin = lin + " " + li[n];
				}
				sign.setLine(i, lin);
			}
			sign.update();
			listSign.remove(loc);
		}
	}
	
	public static void boucle(){
		Bukkit.getScheduler().scheduleSyncDelayedTask(main.Main.getPlugin(), new Runnable(){

			@Override
			public void run() {
				for(Entry<Location, String[]> entry : listSign.entrySet()) {
				    Location loc = entry.getKey();
				    String[] line = entry.getValue();
				    try{
						updateSign(loc, line);
					}catch(Exception e){
					}
				}
				if(listSign.isEmpty() == false){
					boucle();
				}
			}
			
		}, 80);
	}

}

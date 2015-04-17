package main;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class ApiTransfertPlayer {
	
	public static void transfertPlayerTo(Player player, String server){
		String name = player.getName();
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("ConnectOther");
		out.writeUTF(name);
		out.writeUTF(server);
		player.sendPluginMessage(main.Main.getPlugin(), "BungeeCord", out.toByteArray());
	}

}

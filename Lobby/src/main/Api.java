package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Api {
	
	/*
	 * 
	 * A lancer au onEnable()
	 * 		BdDconnect(String url, String user, String password)
	 * 
	 */
	
	public static Connection cn;
	private static boolean co = false;
	
	public static void BdDconnect(String url, String user, String password){
		if(!co){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn =  DriverManager.getConnection(url, user, password);
				co = true;
				System.out.println("Connexion a la base de donne effectue");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Connexion a la base de donnnee deja effectue");
		}
	}
	
	public static ArrayList<ArrayList<String>> BdDsendRequette(String requette){
		ArrayList<ArrayList<String>> listFinal = new ArrayList<ArrayList<String>>();
		if(!co){
			System.out.println("Pas de connexion a la base de donnee");
			return null;
		}
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = cn.createStatement();
			rs = st.executeQuery(requette);
			ResultSetMetaData meta = rs.getMetaData();
			while(rs.next()){
				ArrayList<String> list = new ArrayList<String>();
				for(int i = 1;i<=meta.getColumnCount();i++)
					list.add(rs.getString(i));
				listFinal.add(list);
			}
			return listFinal;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
			
		return null;
	}
	
	public static void transfertPlayerTo(Plugin plugin,Player player, String server){
		String name = player.getName();
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("ConnectOther");
		out.writeUTF(name);
		out.writeUTF(server);
		player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
	}
	
    public static void sendTitle(Player player, String msgTitle, String msgSubTitle, int ticks){
        IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + msgTitle + "\"}");
        IChatBaseComponent chatSubTitle = ChatSerializer.a("{\"text\": \"" + msgSubTitle + "\"}");
        PacketPlayOutTitle p = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle p2 = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, chatSubTitle);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p2);
        sendTime(player, ticks);
	}
	
	private static void sendTime(Player player, int ticks){
	        PacketPlayOutTitle p = new PacketPlayOutTitle(EnumTitleAction.TIMES, null, 20, ticks, 20);
	        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);
	}
	
	public static void sendActionBar(Player player, String message){
	        IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
	        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
	        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(ppoc);
	}

}

package main;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		new OnEnable();
	}
	
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("test")){
			Player p = (Player) sender;
			p.sendMessage(joueur.Main.moneyMiniGames.get(p.getUniqueId()) + " voici ton argent");
			p.sendMessage("Voici ton grade "+joueur.Main.grade.get(p.getUniqueId()).getName() +", tu as un power de "+ joueur.Main.grade.get(p.getUniqueId()).getPower());
		}
		return false;
	}
	
	public static Plugin getPlugin(){
		return Bukkit.getPluginManager().getPlugin("LobbyNitroGames");
	}
}

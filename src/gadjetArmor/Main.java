package gadjetArmor;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Main{
	File conf = new File("plugins/LobbyArmor/Lobby.yml");
	FileConfiguration configlobby = YamlConfiguration.loadConfiguration(conf);
	public static int slot;

	public static void onEnable() {
		slot = 1;
		RainbowArmor.launchTask();
	}

	public static void onDisable() {
	}

	public static int getSlot() {
		return slot;
	}

	public static void setSlot(int nbr) {
		slot = nbr;
	}
}

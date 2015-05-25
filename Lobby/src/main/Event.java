package main;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Event implements Listener { //Cette classe contien tout les events et les rediriges
	
	public void playerInteract(PlayerInteractEvent e){
		signControl.Event.playerClickOnSign(e);
	}

}

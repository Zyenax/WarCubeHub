package net.warcube.hub.handlers;

import net.warcube.hub.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropHandler implements Listener {
	@SuppressWarnings("unused")
	private static Main plugin;

	public DropHandler(Main hub) {
		DropHandler.plugin = hub;
	}

	@EventHandler
	public void onDropItemEvent(final PlayerDropItemEvent e) {
			e.setCancelled(true);
	}

}

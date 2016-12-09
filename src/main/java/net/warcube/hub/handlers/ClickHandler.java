package net.warcube.hub.handlers;

import net.warcube.hub.Main;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ClickHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public ClickHandler(Main hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void onClickEvent(InventoryClickEvent e) {
		if (e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
			if(e.getWhoClicked().getInventory().equals(InventoryType.CREATIVE)){
				e.setCancelled(false);
			}
		} else
			e.setCancelled(true);
	}
}

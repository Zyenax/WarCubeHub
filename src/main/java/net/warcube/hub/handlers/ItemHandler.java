package net.warcube.hub.handlers;

import net.warcube.hub.Main;
import net.warcube.hub.menus.RealmMenu;
import net.warcube.hub.utils.Utils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public ItemHandler(Main hub) {
		this.plugin = hub;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void gamemenu(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Utils.color("&eRealm Selector &7- &bRight Click"))){
							RealmMenu.Menu(e.getPlayer());
						}
					}
				}
			}
		}
	}
}
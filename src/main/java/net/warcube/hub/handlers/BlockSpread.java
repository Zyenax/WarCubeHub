package net.warcube.hub.handlers;

import net.warcube.hub.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class BlockSpread implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	public BlockSpread(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onBlockSpread(BlockSpreadEvent event) {
	event.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockChangeEvent(EntityDeathEvent event){
		
	}
	
}

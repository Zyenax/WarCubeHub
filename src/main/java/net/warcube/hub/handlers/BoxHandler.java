package net.warcube.hub.handlers;

import net.warcube.hub.Main;
import net.warcube.hub.utils.HoloGrams;
import net.warcube.hub.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BoxHandler implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public BoxHandler(Main listener) {
		this.plugin = listener;		
	}
	
	static Location holoLoc1 = new Location(Bukkit.getWorld("world"), -994.5, 46.0, 2273.5);
	static Location holoLoc2 = new Location(Bukkit.getWorld("world"), -994.5, 46.0, 2311.5);
	public static void makeBoxHolograms(){
		HoloGrams.createHoloGram(holoLoc1.add(0, 0.3, 0), Utils.color("&6Prize Box"), 9, false, false, null, null, null);
		HoloGrams.createHoloGram(holoLoc1.add(0, -0.3, 0), Utils.color("&eComing Soon"), 10, false, false, null, null, null);
		HoloGrams.createHoloGram(holoLoc2.add(0, 0.3, 0), Utils.color("&6Prize Box"), 11, false, false, null, null, null);
		HoloGrams.createHoloGram(holoLoc2.add(0, -0.3, 0), Utils.color("&eComing Soon"), 12, false, false, null, null, null);
	}
	
	
	static Location boxLoc1 = new Location(Bukkit.getWorld("world"), -994.5, 46.0, 2273.5);
	static Location boxLoc2 = new Location(Bukkit.getWorld("world"), -994.5, 46.0, 2311.5);
	@EventHandler
	public void boxInteract(PlayerInteractEvent event){
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getClickedBlock() != null) {
				if (event.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE){
					if(event.getClickedBlock().getX() == boxLoc1.getBlockX() && event.getClickedBlock().getY() == boxLoc1.getBlockY() && event.getClickedBlock().getZ() == boxLoc1.getBlockZ()){
						event.getPlayer().sendMessage(Utils.color("&cPrize Boxes are coming soon."));
						//INITIATE REWARD SYSTEM
						event.setCancelled(true);
					}else if(event.getClickedBlock().getX() == boxLoc2.getBlockX() && event.getClickedBlock().getY() == boxLoc2.getBlockY() && event.getClickedBlock().getZ() == boxLoc2.getBlockZ()){
						event.getPlayer().sendMessage(Utils.color("&cPrize Boxes are coming soon."));
						//INITIATE REWARD SYSTEM
						event.setCancelled(true);
					}
				}
			}
		}
	}

}

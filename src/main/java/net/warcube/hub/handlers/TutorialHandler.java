package net.warcube.hub.handlers;

import java.util.HashMap;

import net.warcube.hub.Main;
import net.warcube.hub.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TutorialHandler implements Listener{
	
	private static Main plugin;
	public TutorialHandler(Main listener) {
		TutorialHandler.plugin = listener;		
	}
	
	static Location tutLoc1 = new Location(Bukkit.getWorld("world"), -1012.5, 56.0, 2292.5, -90, 30);
	static Location tutLoc2 = new Location(Bukkit.getWorld("world"), -988.5, 46.0, 2292.5, -90, 0);
	static Location tutLoc3 = new Location(Bukkit.getWorld("world"), -994.5, 46.0, 2301.5, 0, 0);
	static Location tutLoc4 = new Location(Bukkit.getWorld("world"), -1014.5, 46, 2292.5, -90, 0);
	
	public static HashMap<Player, Player> Tutorial = new HashMap<Player, Player>();
	public static void initiateTutorial(final Player player){
		if(!Tutorial.containsKey(player)){
			Tutorial.put(player, player);
			PotionEffect potion = new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 99999);
			player.addPotionEffect(potion, true);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	    		public void run() {
	    			player.setAllowFlight(true);
	    			player.setFlying(true);
	    			player.setFlySpeed(0f);
	    			player.teleport(tutLoc1);
	    			player.setFlying(true);
	    			//MESSAGE ABOUT LOBBY
	    			player.sendMessage(Utils.color("  "));
	    			player.sendMessage(Utils.color("&6&lMAIN LOBBY!"));
	    			player.sendMessage(Utils.color("&eThis is the main lobby where you can hang out and join games!"));
	    			player.sendMessage(Utils.color("  "));
	    		}
	    	}, 3);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	    		public void run() {
	    			player.setFlying(true);
	    			player.teleport(tutLoc2);
	    			player.setFlying(true);
	    			//MESSAGE ABOUT REALMS
	    			player.sendMessage(Utils.color("  "));
	    			player.sendMessage(Utils.color("&6&lREALMS!"));
	    			player.sendMessage(Utils.color("&eThese are realms(servers) on the network that you can join by right clicking them!"));
	    			player.sendMessage(Utils.color("  "));
	    		}
	    	}, 4 * 20);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	    		public void run() {
	    			//MESSAGE 2 ABOUT REALMS BY COMPASS
	    			player.sendMessage(Utils.color("  "));
	    			player.sendMessage(Utils.color("&6&lREALMS BY COMPASS!"));
	    			player.sendMessage(Utils.color("&eYou can also right click your compass to select a game aswell!"));
	    			player.sendMessage(Utils.color("  "));
	    		}
	    	}, 8 * 20);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	    		public void run() {
	    			player.setFlying(true);
	    			player.teleport(tutLoc3);
	    			player.setFlying(true);
	    			//MESSAGE ABOUT BOXES
	    			player.sendMessage(Utils.color("  "));
	    			player.sendMessage(Utils.color("&6&lBOXES!"));
	    			player.sendMessage(Utils.color("&eThese are boxes where you can earn rewards for playing games!"));
	    			player.sendMessage(Utils.color("  "));
	    		}
	    	}, 12 * 20);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
	    		public void run() {
	    			player.setFlying(true);
	    			player.teleport(tutLoc4);
	    			player.setFlying(true);
	    			Tutorial.remove(player);
	    			player.removePotionEffect(PotionEffectType.INVISIBILITY);
	    			//MESSAGE ABOUT THATS IT
	    			player.sendMessage(Utils.color("  "));
	    			player.sendMessage(Utils.color("&6&lTHATS IT!"));
	    			player.sendMessage(Utils.color("&eThats all for the tutorial now go play your heart out or interact with people!"));
	    			player.sendMessage(Utils.color("  "));
	    			player.setFlySpeed(0.1f);
	    			player.setAllowFlight(false);
	    			player.setFlying(false);
	    		}
	    	}, 16 * 20);
		}
	}

}

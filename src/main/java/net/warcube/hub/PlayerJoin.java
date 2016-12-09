package net.warcube.hub;

import java.util.Arrays;

import net.warcube.hub.handlers.ScoreBoardHandler;
import net.warcube.hub.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public PlayerJoin(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		event.setJoinMessage(null);
		player.getInventory().clear();
		event.getPlayer().setFoodLevel(20);
		giveItems(player);
		player.setGameMode(GameMode.ADVENTURE);
		Location loc = new Location(Bukkit.getWorld("world"), -1014.5, 46, 2292.5, -90, 0);
		player.teleport(loc);
		player.setScoreboard(ScoreBoardHandler.board);
	}
	
	public static void giveItems(Player p){
		ItemStack selector = Utils.createItem(Material.COMPASS,1,0,Utils.color("&eRealm Selector &7- &bRight Click"), Arrays.asList(Utils.color("&aRight click to open the Realms Menu!")));
		p.getInventory().setItem(0, selector);
	}

}

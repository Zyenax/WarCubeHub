package net.warcube.hub;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;

import net.warcube.hub.handlers.BlockSpread;
import net.warcube.hub.handlers.BoxHandler;
import net.warcube.hub.handlers.BuildHandler;
import net.warcube.hub.handlers.ClickHandler;
import net.warcube.hub.handlers.CommandHandler;
import net.warcube.hub.handlers.DamageHandler;
import net.warcube.hub.handlers.DropHandler;
import net.warcube.hub.handlers.HungerHandler;
import net.warcube.hub.handlers.ItemHandler;
import net.warcube.hub.handlers.NPCHandler;
import net.warcube.hub.handlers.PickupHandler;
import net.warcube.hub.handlers.ScoreBoardHandler;
import net.warcube.hub.handlers.TutorialHandler;
import net.warcube.hub.handlers.WeatherHandler;
import net.warcube.hub.menus.RealmMenu;
import net.warcube.hub.utils.BungeeUtil;
import net.warcube.hub.utils.HashMapStorage;
import net.warcube.hub.utils.HoloGrams;
import net.warcube.hub.utils.NPCUtil;
import net.warcube.hub.utils.Packets;
import net.warcube.hub.utils.Utils;
import net.warcube.hub.utils.WorldManager;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin implements Listener, PluginMessageListener{
	
	public static String GetServer;
	public static String[] serverList;
	
	public void onEnable(){
		registerListeners();
		registerCommands();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&c&lWARCUBE: &aThe hub plugin has been enabled!"));
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
	    List<Entity> entities = Bukkit.getWorld("world").getEntities();
		for ( Entity entity : entities){
			if(!entity.getType().equals(EntityType.PLAYER)){
				entity.remove();
			}
		}
		NPCHandler.loadNpcs();
		NPCHandler.NPCNameUpdater();
		BoxHandler.makeBoxHolograms();
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&c&lWARCUBE: &aThe hub plugin has been disabled!"));
		List<Entity> entities = Bukkit.getWorld("world").getEntities();
		for ( Entity entity : entities){
			if(!entity.getType().equals(EntityType.PLAYER)){
				entity.remove();
			}
		}
	}
	
	public void registerListeners(){
		PluginManager manager = Bukkit.getServer().getPluginManager();
		manager.registerEvents(new Utils(this), this);
		manager.registerEvents(new Packets(this), this);
		manager.registerEvents(new NPCUtil(this), this);
		manager.registerEvents(new HoloGrams(this), this);
		manager.registerEvents(new HashMapStorage(this), this);
		manager.registerEvents(new BungeeUtil(this), this);
		manager.registerEvents(new PlayerJoin(this), this);
		manager.registerEvents(new PlayerQuit(this), this);
		manager.registerEvents(new BlockSpread(this), this);
		manager.registerEvents(new BuildHandler(this), this);
		manager.registerEvents(new DamageHandler(this), this);
		manager.registerEvents(new DropHandler(this), this);
		manager.registerEvents(new HungerHandler(this), this);
		manager.registerEvents(new ItemHandler(this), this);
		manager.registerEvents(new PickupHandler(this), this);
		manager.registerEvents(new ScoreBoardHandler(this), this);
		manager.registerEvents(new WeatherHandler(this), this);
		manager.registerEvents(new RealmMenu(this), this);
		manager.registerEvents(new ClickHandler(this), this);
		manager.registerEvents(new WorldManager(this), this);
		manager.registerEvents(new NPCHandler(this), this);
		manager.registerEvents(new CommandHandler(this), this);
		manager.registerEvents(new TutorialHandler(this), this);
		manager.registerEvents(new BoxHandler(this), this);
		
	}
	
	public void registerCommands(){
		
	}
	
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    try{
	    	DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		    String subchannel = in.readUTF();
	    if (subchannel.equals("PlayerCount")) {
	    	String PlayerCountServer = in.readUTF();
	    	Integer playercount = in.readInt();
	    	HashMapStorage.PlayerCount.remove(PlayerCountServer);
	    	HashMapStorage.PlayerCount.put(PlayerCountServer, playercount);
        } else if (subchannel.equals("GetServers")) {
        	serverList = in.readUTF().split("\n");
        } else if (subchannel.equals("GetServer")) {
            // Example: GetServer subchannel
        	GetServer = in.readUTF();
        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	  }

}

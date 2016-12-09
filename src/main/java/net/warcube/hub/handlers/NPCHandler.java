package net.warcube.hub.handlers;

import net.warcube.hub.Main;
import net.warcube.hub.utils.BungeeUtil;
import net.warcube.hub.utils.HoloGrams;
import net.warcube.hub.utils.NPCUtil;
import net.warcube.hub.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class NPCHandler implements Listener{
	
	private static Main plugin;
	public NPCHandler(Main listener) {
		NPCHandler.plugin = listener;	
	}
	
	public static Player player;
	public static Location loc1 = new Location(Bukkit.getWorld("world"), -978.5, 46.0, 2288.5, 90, 0);
	public static Location loc2 = new Location(Bukkit.getWorld("world"), -977.5, 46.0, 2292.5, 90, 0);
	public static Location loc3 = new Location(Bukkit.getWorld("world"), -978.5, 46.0, 2296.5, 90, 0);
	public static Location loc4 = new Location(Bukkit.getWorld("world"), -998.5, 43.0, 2292.5, 90, 0);
	@SuppressWarnings("deprecation")
	public static void loadNpcs(){
		Witch npc1 = (Witch) loc1.getWorld().spawn(loc1, Witch.class);
		NPCUtil.createStandingNPC(npc1, false);
		npc1.setCustomNameVisible(false);
		HoloGrams.createHoloGram(loc1.add(0, 0.3, 0), Utils.color("&6Mage Realm"), 1, false, false, null, null, null);
		HoloGrams.createHoloGram(loc1.add(0, -0.3, 0), Utils.color("&eNULL Playing"), 2, false, false, null, null, null);
		
		Zombie npc2 = (Zombie) loc2.getWorld().spawn(loc2, Zombie.class);
		NPCUtil.createStandingNPC(npc2, false);
		npc2.setCustomNameVisible(false);
		npc2.setBaby(false);
		npc2.getEquipment().setItemInHand(Utils.createItem(Material.STONE_AXE, 1, 0, null, null));
		npc2.getEquipment().setHelmet(Utils.createSkull("Teaz", null, null));
		npc2.getEquipment().setChestplate(Utils.createLeatherItem(Material.LEATHER_CHESTPLATE, null, Color.GREEN));
		npc2.getEquipment().setLeggings(Utils.createLeatherItem(Material.LEATHER_LEGGINGS, null, Color.GREEN));
		npc2.getEquipment().setBoots(Utils.createLeatherItem(Material.LEATHER_BOOTS, null, Color.GREEN));
		HoloGrams.createHoloGram(loc2.add(0, 0.3, 0), Utils.color("&6Orc Realm"), 3, false, false, null, null, null);
		HoloGrams.createHoloGram(loc2.add(0, -0.3, 0), Utils.color("&eNULL Playing"), 4, false, false, null, null, null);
		
		Zombie npc3 = (Zombie) loc3.getWorld().spawn(loc3, Zombie.class);
		NPCUtil.createStandingNPC(npc3, false);
		npc3.setCustomNameVisible(false);
		npc3.setBaby(false);
		npc3.getEquipment().setHelmet(Utils.createSkull("Jarofdirt", null, null));
		npc3.getEquipment().setChestplate(Utils.createItem(Material.IRON_CHESTPLATE, 1, 0, null, null));
		npc3.getEquipment().setLeggings(Utils.createItem(Material.IRON_LEGGINGS, 1, 0, null, null));
		npc3.getEquipment().setBoots(Utils.createItem(Material.IRON_BOOTS, 1, 0, null, null));
		npc3.getEquipment().setItemInHand(Utils.createItem(Material.IRON_SWORD, 1, 0, null, null));
		HoloGrams.createHoloGram(loc3.add(0, 0.3, 0), Utils.color("&6Knight Realm"), 5, false, false, null, null, null);
		HoloGrams.createHoloGram(loc3.add(0, -0.3, 0), Utils.color("&eNULL Playing"), 6, false, false, null, null, null);
		
		Villager npc4 = (Villager) loc4.getWorld().spawn(loc4, Villager.class);
		NPCUtil.createStandingNPC(npc4, false);
		npc4.setCustomNameVisible(false);
		npc4.setAdult();
		npc4.setProfession(Profession.BLACKSMITH);
		HoloGrams.createHoloGram(loc4.add(0, 0.3, 0), Utils.color("&6Tutorial"), 7, false, false, null, null, null);
		HoloGrams.createHoloGram(loc4.add(0, -0.3, 0), Utils.color("&eRight Click"), 8, false, false, null, null, null);
	}
	
	public static void NPCNameUpdater(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				HoloGrams.renameHoloGram("&e" + BungeeUtil.playerCountOfServer(player, "Mage") + " Playing", 2);
    				HoloGrams.renameHoloGram("&e" + BungeeUtil.playerCountOfServer(player, "Orc") + " Playing", 4);
    				HoloGrams.renameHoloGram("&e" + BungeeUtil.playerCountOfServer(player, "Knight") + " Playing", 6);
    			}
    		}
    	}, 0, 5);
	}
	
	@EventHandler
	public void npcInteract(PlayerInteractEntityEvent event){
		if (event.getRightClicked().getType() == EntityType.WITCH && event.getRightClicked().getLocation().equals(loc1)) {
			event.setCancelled(true);
			BungeeUtil.sendToServer(event.getPlayer(), "Mage");
		}else if (event.getRightClicked().getType() == EntityType.ZOMBIE && event.getRightClicked().getLocation().equals(loc2)) {
			event.setCancelled(true);
			BungeeUtil.sendToServer(event.getPlayer(), "Orc");
		}else if (event.getRightClicked().getType() == EntityType.ZOMBIE && event.getRightClicked().getLocation().equals(loc3)) {
			event.setCancelled(true);
			BungeeUtil.sendToServer(event.getPlayer(), "Knight");
		}else if (event.getRightClicked().getType() == EntityType.VILLAGER && event.getRightClicked().getLocation().equals(loc4)) {
			event.setCancelled(true);
			//INITIATE TUTORIAL
			TutorialHandler.initiateTutorial(event.getPlayer());
		}
	}
	
	@EventHandler
	public void npcCombust(EntityCombustEvent event){
		if(event.getEntityType() != EntityType.PLAYER){
			event.setCancelled(true);
		}
	}

}

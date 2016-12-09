package net.warcube.hub.menus;

import java.util.Arrays;
import java.util.HashMap;

import net.warcube.hub.Main;
import net.warcube.hub.utils.BungeeUtil;
import net.warcube.hub.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class RealmMenu implements Listener{
	
	public static Inventory inv;
	
	//ITEMS
	//MAGE
	static String itemname1 = "&6Mage Realm";
	static Integer slotnumber1 = 19;
	static Material material1 = Material.NETHER_STAR;
	static String servername1 = "Mage";
	static String gametype1 = "&8Survival";
	
	//ORC
	static String itemname2 = "&6Orc Realm";
	static Integer slotnumber2 = 22;
	static Material material2 = Material.STONE_AXE;
	static String servername2 = "Orc";
	static String gametype2 = "&8Survival";
	
	//VIKING
	static String itemname3 = "&6Knight Realm";
	static Integer slotnumber3 = 25;
	static Material material3 = Material.IRON_SWORD;
	static String servername3 = "Knight";
	static String gametype3 = "&8Survival";
	
	//CLASS REGISTRAR
	private static Main plugin;
	public RealmMenu(Main listener) {
		RealmMenu.plugin = listener;	
		Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8Realms"));
		inv = inventory;
		Border();
		putItems();
	}
	
	static HashMap<Player, BukkitTask> MenuMap = new HashMap<Player, BukkitTask>();
	public static void Menu(final Player p){
		p.openInventory(inv);
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		if(!(MenuMap.containsKey(p))){
			MenuMap.put(p, scheduler.runTaskTimer(plugin, new Runnable() {
				public void run() {
					Border();
					p.updateInventory();
				}	
			}, 0, 10L));
		}else{
			MenuMap.get(p).cancel();
			MenuMap.remove(p);
			return;
		}
	}
	
	@EventHandler
	public void onInvClose(InventoryCloseEvent event){
		if(MenuMap.containsKey(event.getPlayer())){
			MenuMap.get(event.getPlayer()).cancel();
			MenuMap.remove(event.getPlayer());
		}
	}
	
	public static void Border(){
		ItemStack border = Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, Utils.color(" "), null);
		inv.setItem(0, border);
		inv.setItem(1, border);
		inv.setItem(2, border);
		inv.setItem(3, border);
		inv.setItem(4, border);
		inv.setItem(5, border);
		inv.setItem(6, border);
		inv.setItem(7, border);
		inv.setItem(8, border);
		inv.setItem(9, border);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
	}
	
	public static void putItems(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    		public void run() {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				if(player != null){
    					ItemStack item1 = Utils.createItem(material1, 1, 0, Utils.color(itemname1), Arrays.asList(Utils.color(gametype1), Utils.color(" "), Utils.color("&7Roam the lands of our fully custom"), Utils.color("&cKitPVP &7server in hope to level"), Utils.color("&7up and fight some awesome foes"), Utils.color("&7for a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername1) + " &8others"), Utils.color("&0&l▶ &bClick to join this realm")));
    					ItemMeta meta1 = item1.getItemMeta();
            			meta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            			item1.setItemMeta(meta1);
    					inv.setItem(slotnumber1, item1);
            			
            			ItemStack item2 = Utils.createItem(material2, 1, 0, Utils.color(itemname2), Arrays.asList(Utils.color(gametype2), Utils.color(" "), Utils.color("&7Roam the lands of our fully custom"), Utils.color("&cKitPVP &7server in hope to level"), Utils.color("&7up and fight some awesome foes"), Utils.color("&7for a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername2) + " &8others"), Utils.color("&0&l▶ &bClick to join this realm")));
            			ItemMeta meta2 = item2.getItemMeta();
            			meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            			item2.setItemMeta(meta2);
            			inv.setItem(slotnumber2, item2);
            			
            			ItemStack item3 = Utils.createItem(material3, 1, 0, Utils.color(itemname3), Arrays.asList(Utils.color(gametype3), Utils.color(" "), Utils.color("&7Roam the lands of our fully custom"), Utils.color("&cKitPVP &7server in hope to level"), Utils.color("&7up and fight some awesome foes"), Utils.color("&7for a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername3) + " &8others"), Utils.color("&0&l▶ &bClick to join this realm")));
            			ItemMeta meta3 = item3.getItemMeta();
            			meta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            			item3.setItemMeta(meta3);
            			inv.setItem(slotnumber3, item3);
    				}
    			}
    		}
		}, 10);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				if(player != null){
    					ItemStack item1 = Utils.createItem(material1, 1, 0, Utils.color(itemname1), Arrays.asList(Utils.color(gametype1), Utils.color(" "), Utils.color("&7Roam the lands of our fully custom"), Utils.color("&cKitPVP &7server in hope to level"), Utils.color("&7up and fight some awesome foes"), Utils.color("&7for a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername1) + " &8others"), Utils.color("&b&l▶ &bClick to join this realm")));
    					ItemMeta meta1 = item1.getItemMeta();
            			meta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            			item1.setItemMeta(meta1);
    					inv.setItem(slotnumber1, item1);
            			
            			ItemStack item2 = Utils.createItem(material2, 1, 0, Utils.color(itemname2), Arrays.asList(Utils.color(gametype2), Utils.color(" "), Utils.color("&7Roam the lands of our fully custom"), Utils.color("&cKitPVP &7server in hope to level"), Utils.color("&7up and fight some awesome foes"), Utils.color("&7for a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername2) + " &8others"), Utils.color("&b&l▶ &bClick to join this realm")));
            			ItemMeta meta2 = item2.getItemMeta();
            			meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            			item2.setItemMeta(meta2);
            			inv.setItem(slotnumber2, item2);
            			
            			ItemStack item3 = Utils.createItem(material3, 1, 0, Utils.color(itemname3), Arrays.asList(Utils.color(gametype3), Utils.color(" "), Utils.color("&7Roam the lands of our fully custom"), Utils.color("&cKitPVP &7server in hope to level"), Utils.color("&7up and fight some awesome foes"), Utils.color("&7for a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername3) + " &8others"), Utils.color("&b&l▶ &bClick to join this realm")));
            			ItemMeta meta3 = item3.getItemMeta();
            			meta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            			item3.setItemMeta(meta3);
            			inv.setItem(slotnumber3, item3);
    				}
    			}
    		}
		}, 20);
    		}
		}, 0, 20);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(Utils.color("&8Realms"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(e.getInventory() != null){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							//MAGE
							if(e.getCurrentItem().getType().equals(Material.NETHER_STAR)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color(itemname1))){
									BungeeUtil.sendToServer(p, servername1);
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_STRONG, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							//ORC
							if(e.getCurrentItem().getType().equals(Material.STONE_AXE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color(itemname2))){
									BungeeUtil.sendToServer(p, servername2);
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_STRONG, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							//VIKING
							if(e.getCurrentItem().getType().equals(Material.IRON_SWORD)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color(itemname3))){
									BungeeUtil.sendToServer(p, servername3);
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_STRONG, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							//BORDER
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color(" "))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							
							
						}
					}
				}
			}
		}
	}

}

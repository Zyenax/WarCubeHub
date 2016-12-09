package net.warcube.hub.utils;

import java.util.HashMap;
import java.util.UUID;

import net.minecraft.server.v1_10_R1.EntityPlayer;
import net.minecraft.server.v1_10_R1.MinecraftServer;
import net.minecraft.server.v1_10_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_10_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_10_R1.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_10_R1.PlayerConnection;
import net.minecraft.server.v1_10_R1.PlayerInteractManager;
import net.minecraft.server.v1_10_R1.WorldServer;
import net.warcube.hub.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_10_R1.CraftServer;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.mojang.authlib.GameProfile;

public class NPCUtil implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public NPCUtil(Main listener) {
		NPCUtil.plugin = listener;		
	}
	
	static String a = "&c&lERROR: &eEntityNPC is already made!";
	public static HashMap<Integer, Entity> EntityNPCStorage = new HashMap<Integer, Entity>();
	public static void createEntityNPC(String name1, String name2, Location loc, EntityType npctype, Integer NPCID, Integer HoloGramID1, Integer HoloGramID2){
		if(!EntityNPCStorage.containsKey(NPCID)){
			Entity npc = (Entity) loc.getWorld().spawnEntity(loc, npctype);
			NPCUtil.createStandingNPC(npc, false);
			npc.setCustomNameVisible(false);
			HoloGrams.createHoloGram(loc.add(0, 0.3, 0), Utils.color(name1), HoloGramID1, false, false, null, null, null);
			HoloGrams.createHoloGram(loc.add(0, -0.3, 0), Utils.color(name2), HoloGramID2, false, false, null, null, null);
		}else{
			ConsoleCommandSender v = Bukkit.getConsoleSender();
			v.sendMessage(Utils.color(a));
		}
	}
	
	public static EntityPlayer npc1;
	static String b = "&c&lERROR: &eNPC is already made!";
	public static HashMap<Integer, EntityPlayer> g = new HashMap<Integer, EntityPlayer>();
	public static void createPlayerNPC(Integer NPCID, String UserID, String name, String worldname, Double X, Double Y, Double Z, Integer Pitch, Integer Yaw){
		if(!g.containsKey(NPCID)){
		MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
		WorldServer world = ((CraftWorld) Bukkit.getServer().getWorld(worldname)).getHandle();
		GameProfile profile = new GameProfile(UUID.fromString(UserID), name);
		npc1 = new EntityPlayer(server, world, profile, new PlayerInteractManager(world));
		Location loc = new Location(Bukkit.getWorld(worldname), X, Y, Z, Pitch, Yaw);
		npc1.teleportTo(loc, false);
		g.put(NPCID, npc1);
		}else{
			ConsoleCommandSender v = Bukkit.getConsoleSender();
			v.sendMessage(Utils.color(b));
		}
	}
	
	public static void showPlayerNPC(Player player, EntityPlayer NPC){
		PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
		connection.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, NPC));
		connection.sendPacket(new PacketPlayOutNamedEntitySpawn(NPC));
	}

}

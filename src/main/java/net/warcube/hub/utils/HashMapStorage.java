package net.warcube.hub.utils;

import java.util.HashMap;

import net.warcube.hub.Main;

import org.bukkit.event.Listener;

public class HashMapStorage implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public HashMapStorage(Main listener) {
		this.plugin = listener;		
	}
	
	public static HashMap<String, Integer> PlayerCount = new HashMap<String, Integer>();
}

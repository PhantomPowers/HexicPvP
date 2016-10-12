package me.phantom.LevelingSystem;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import me.phantom.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class levelResetStorage implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(getPlayerLevelResets(p) == "nLevelResets") {
			 storePlayerLevelResets(p, "0");
			 return;
		}
	}
	
	Properties props = new Properties();

	  private Main plugin;

	  public levelResetStorage(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	  public static String getPlayerLevelResets(Player p) {
		  String s = loadPlayerLevelResets(p);
		if(s == null) {
			return "nLevelResets";
		}
		return s;
		}
	  public static void storePlayerLevelResets(Player p, String s) {
		  File file = new File("plugins/HexicPvP/pLevelResets/" + p.getUniqueId().toString() + ".properties");
		  try {
		   
		  if (!file.exists()) {
		  file.createNewFile();
		  }
		   
		  Properties props = new Properties();
		  FileInputStream fis = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(file);
		  props.load(fis);
		  props.setProperty(p.getUniqueId().toString(), s);
		  props.store(out, "Player Level-Reset Storage");
		  out.close();
		  fis.close();
		   
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  }
	  public static String loadPlayerLevelResets(Player p) {
		  File file = new File("plugins/HexicPvP/pLevelResets/" + p.getUniqueId().toString() + ".properties");
		  try{
			   
			  Properties props = new Properties();
			  DataInputStream fis = new DataInputStream(new FileInputStream(file));
			  props.load(fis);
			  props.getProperty(p.getUniqueId().toString());
			   fis.close();
			   return props.getProperty(p.getUniqueId().toString());
			  } catch (IOException e) {
			  e.printStackTrace();
			  return null;
			  }

			  
	  }



}

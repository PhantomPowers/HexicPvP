package me.phantom.Util;

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

public class debugStorage implements Listener {
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(getPlayerDebug(p) == "nDebug") {
			 storePlayerDebug(p, "false");
			 return;
		}
	}
	
	Properties props = new Properties();

	  private Main plugin;

	  public debugStorage(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	  public String getPlayerDebug(Player p) {
		  String s = loadPlayerDebug(p);
		if(s == null) {
			return "nDebug";
		}
		return s;
		}
	
	  public static void storePlayerDebug(Player p, String i) {
		  File file = new File("plugins/HexicPvP/pDebug/" + p.getUniqueId().toString() +".properties");
		  try {
		   
		  if (!file.exists()) {
		  file.createNewFile();
		  }
		   
		  Properties props = new Properties();
		  FileInputStream fis = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(file);
		  props.load(fis);
		  props.setProperty(p.getUniqueId().toString(), i);
		  props.store(out, "Player Debug Storage");
		  out.close();
		  fis.close();
		   
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  }
	  public static String loadPlayerDebug(Player p) {
		  File file = new File("plugins/HexicPvP/pDebug/" + p.getUniqueId().toString() +".properties");
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

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

public class deathStorage implements Listener{
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(getPlayerDeaths(p) == "nDeaths") {
			 storePlayerDeaths(p, "0");
			 return;
		}
	}
	
	Properties props = new Properties();

	  private Main plugin;

	  public deathStorage(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	  public String getPlayerDeaths(Player p) {
		  String s = loadPlayerDeaths(p);
		if(s == null) {
			return "nDeaths";
		}
		return s;
		}
	
	  public static void storePlayerDeaths(Player p, String i) {
		  File file = new File("plugins/HexicPvP/pDeaths/" + p.getUniqueId().toString() +".properties");
		  try {
		   
		  if (!file.exists()) {
		  file.createNewFile();
		  }
		   
		  Properties props = new Properties();
		  FileInputStream fis = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(file);
		  props.load(fis);
		  props.setProperty(p.getUniqueId().toString(), i);
		  props.store(out, "Player Deaths Storage");
		  out.close();
		  fis.close();
		   
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  }
	  public static String loadPlayerDeaths(Player p) {
		  File file = new File("plugins/HexicPvP/pDeaths/" + p.getUniqueId().toString() +".properties");
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




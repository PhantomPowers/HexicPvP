package me.phantom.Combat;

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

public class maxHealthStorage implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(getPlayerKills(p) == "nHealth") {
			 storePlayerKills(p, "50");
			 return;
		}
	}
	
	Properties props = new Properties();

	  private Main plugin;

	  public maxHealthStorage(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	  public String getPlayerKills(Player p) {
		  String s = loadPlayerKills(p);
		if(s == null) {
			return "nHealth";
		}
		return s;
		}
	
	  public static void storePlayerKills(Player p, String i) {
		  File file = new File("plugins/HexicPvP/pHealth/MaxHealth/" + p.getUniqueId().toString() +".properties");
		  try {
		   
		  if (!file.exists()) {
		  file.createNewFile();
		  }
		   
		  Properties props = new Properties();
		  FileInputStream fis = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(file);
		  props.load(fis);
		  props.setProperty(p.getUniqueId().toString(), i);
		  props.store(out, "Player MaxHealth Storage");
		  out.close();
		  fis.close();
		   
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  }
	  public static String loadPlayerKills(Player p) {
		  File file = new File("plugins/HexicPvP/pHealth/MaxHealth/" + p.getUniqueId().toString() +".properties");
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
	  public static int getMaxHealthValue(Player p_name) {
		  int maxHealth = Integer.parseInt(loadPlayerKills(p_name));
			return maxHealth; // Never even setMaxHealth. Impossible?
		}

		public void setMaxHealth(Player p_name, int new_max_hp) {
			
			String maxHP = Integer.toString(new_max_hp);
			storePlayerKills(p_name, maxHP);
		}


}




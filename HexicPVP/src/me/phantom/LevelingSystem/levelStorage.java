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

public class levelStorage  implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(getPlayerLevel(p) == "nLevel") {
			 storePlayerLevel(p, "1");
			 return;
		}
	}
	
	Properties props = new Properties();

	  private Main plugin;

	  public levelStorage(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	  public static String getPlayerLevel(Player p) {
		  String s = loadPlayerLevel(p);
		if(s == null) {
			return "nLevel";
		}
		return s;
		}
	  public static void storePlayerLevel(Player p, String s) {
		  File file = new File("plugins/HexicPvP/pLevels/" + p.getUniqueId().toString() + ".properties");
		  try {
		   
		  if (!file.exists()) {
		  file.createNewFile();
		  }
		   
		  Properties props = new Properties();
		  FileInputStream fis = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(file);
		  props.load(fis);
		  props.setProperty(p.getUniqueId().toString(), s);
		  props.store(out, "Player Level Storage");
		  out.close();
		  fis.close();
		   
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  }
	  public static String loadPlayerLevel(Player p) {
		  File file = new File("plugins/HexicPvP/pLevels/" + p.getUniqueId().toString() + ".properties");
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

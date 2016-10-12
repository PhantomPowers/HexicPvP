package me.phantom.Vendor.PurchaseAmount.Legendary;

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

public class Token implements Listener{
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(getPurchaseData() == "nPurchases") {
			 storePurchaseData("0");
			 return;
		}
	}
	
	Properties props = new Properties();

	  private Main plugin;

	  public Token(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	  public String getPurchaseData() {
		  String s = loadPurchaseData();
		if(s == null) {
			return "nPurchases";
		}
		return s;
		}
	
	  public static void storePurchaseData(String i) {
		  File file = new File("plugins/Vendor/PurchaseStorage/Legendary/Token.properties");
		  try {
		   
		  if (!file.exists()) {
		  file.createNewFile();
		  }
		   
		  Properties props = new Properties();
		  FileInputStream fis = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(file);
		  props.load(fis);
		  props.setProperty("Purchases", i);
		  props.store(out, "Purchase Storage");
		  out.close();
		  fis.close();
		   
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  }
	  public static String loadPurchaseData() {
		  File file = new File("plugins/Vendor/PurchaseStorage/Legendary/Token.properties");
		  try{
			   
			  Properties props = new Properties();
			  DataInputStream fis = new DataInputStream(new FileInputStream(file));
			  props.load(fis);
			  props.getProperty("Purchases");
			   fis.close();
			   return props.getProperty("Purchases");
			  } catch (IOException e) {
			  e.printStackTrace();
			  return null;
			  }

			  
	  }


}




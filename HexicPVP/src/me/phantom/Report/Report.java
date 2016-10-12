package me.phantom.Report;

import java.util.HashMap;
import java.util.Random;

import me.phantom.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;



public class Report implements Listener {
	
	 public static HashMap<Player, String> Other = new HashMap<Player, String>();
	
	  private Main plugin;

	  public Report(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	@EventHandler
	  public void onCLickev(InventoryClickEvent e)
	  {
		
	    Player por = (Player)e.getWhoClicked();
	    if (e.getInventory().getName().contains("Report")) {
	      e.setCancelled(true);
			Random random = new Random();
		    int a = random.nextInt(10);
		    int b = random.nextInt(10);
		    int c = random.nextInt(10);
		    int d = random.nextInt(10);
		    int e1 = random.nextInt(10);
		    int f = random.nextInt(10);
		    int g = random.nextInt(10);
		    int h = random.nextInt(10);
		    int i = random.nextInt(10);
		    int j = random.nextInt(10);
		    int k = random.nextInt(10);
		    int l = random.nextInt(10);

		    String id = Integer.toString(a) +Integer.toString(b) +Integer.toString(c) +Integer.toString(d) + "-"
		    		+ Integer.toString(e1) +Integer.toString(f) +Integer.toString(g) +Integer.toString(h) + "-" + Integer.toString(i) +Integer.toString(j) +Integer.toString(k) +
		    		Integer.toString(l) + "";
		    String name =  e.getInventory().getName();

	      if (e.getSlot() == 0) {
	        Player p = (Player)e.getWhoClicked();
	        e.getInventory().getName().replace("Report: ", "");
	        p.closeInventory();
	        p.sendMessage("§7Report submitted to staff: " + id);
	        p.sendMessage("§7*Note* Spamming reports will result in a temp-ban!");
	        for (Player pl : Bukkit.getOnlinePlayers()) {
				 if(pl.hasPermission("potential.staffchat")) {
					 pl.sendMessage("§8======§c"+ por.getName() +"'s Report§8======");
					 pl.sendMessage("§7Player: §c" + ChatColor.stripColor(name.replace("Report: ", "")));
					 pl.sendMessage("§7Report Id: §c" + id);
					 pl.sendMessage("§7Reason:§c Hacking");
				 }
				 
			 }
	      }
	      if (e.getSlot() == 1) {
		        Player p = (Player)e.getWhoClicked();
		        e.getInventory().getName().replace("Report: ", "");
		        p.closeInventory();
		        p.sendMessage("§7Report submitted to staff: " + id);
		        p.sendMessage("§7*Note* Spamming reports will result in a temp-ban!");
		        for (Player pl : Bukkit.getOnlinePlayers()) {
					 if(pl.hasPermission("potential.staffchat")) {
						 pl.sendMessage("§8======§c"+ por.getName() +"'s Report§8======");
						 pl.sendMessage("§7Player: §c" + ChatColor.stripColor(name.replace("Report: ", "")));
						 pl.sendMessage("§7Report Id: §c" + id);
						 pl.sendMessage("§7Reason:§c Disrespect");
					 }
					 
				 }
		      }
	      if (e.getSlot() == 2) {
		        Player p = (Player)e.getWhoClicked();
		        e.getInventory().getName().replace("Report: ", "");
		        p.closeInventory();
		        Other.put(p, ChatColor.stripColor(name.replace("Report: ", "")));
		        p.sendMessage("§7Please type the reason you're reporting or type 'cancel'");
		      }
	    }
	  }
	
	@SuppressWarnings("deprecation")
	@EventHandler
	  public void ChatEvent(PlayerChatEvent e)
	  {
		Player p = e.getPlayer();
		
		Random random = new Random();
	    int a = random.nextInt(10);
	    int b = random.nextInt(10);
	    int c = random.nextInt(10);
	    int d = random.nextInt(10);
	    int e1 = random.nextInt(10);
	    int f = random.nextInt(10);
	    int g = random.nextInt(10);
	    int h = random.nextInt(10);
	    int i = random.nextInt(10);
	    int j = random.nextInt(10);
	    int k = random.nextInt(10);
	    int l = random.nextInt(10);
		 String id = Integer.toString(a) +Integer.toString(b) +Integer.toString(c) +Integer.toString(d) + "-"
		    		+ Integer.toString(e1) +Integer.toString(f) +Integer.toString(g) +Integer.toString(h) + "-" + Integer.toString(i) +Integer.toString(j) +Integer.toString(k) +
		    		Integer.toString(l) + "";
		    String name =  p.getInventory().getName();
		    
		    if(Other.containsKey(p)) {
		    	if(e.getMessage().contains("cancel")) { 
		    		Other.remove(p);
		    		p.sendMessage("§7Report request successfully cancelled");
		    		e.setCancelled(true);
		    		return;
		    	}
		    	e.setCancelled(true);
	  p.sendMessage("§7Report submitted to staff: " + id);
	  p.sendMessage("§7*Note* Spamming reports will result in a temp-ban!");
      for (Player pl : Bukkit.getOnlinePlayers()) {
			 if(pl.hasPermission("potential.staffchat")) {
				 pl.sendMessage("§8======§c"+ p.getName() +"'s Report§8======");
				 pl.sendMessage("§7Player: §c" + Other.get(p));
				 pl.sendMessage("§7Report Id: §c" + id);
				 pl.sendMessage("§7Reason:§c " + e.getMessage().toString());
			 }
			 }
      Other.remove(p);
      }
	return;
	  }
}



package me.phantom.Vendor.PvPTokens;

import me.phantom.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillPoints implements Listener {
	
	  private Main plugin;

	  public KillPoints(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  @EventHandler
	    public void addKillTokens(PlayerDeathEvent e) {
		  Player p = e.getEntity();
		  Player Killer = p.getKiller();
		  if(Killer instanceof Player) {
			  String s4 = PointsStorage.loadPlayerTokens(Killer);
			  int tokes = Integer.parseInt(s4) + getKillTokens();
			  String tokens = Integer.toString(tokes);
			  PointsStorage.storePlayerTokens(Killer, tokens);
			  Killer.sendMessage("§c§l         + " + getKillTokens() + "§c§lTokens");
			  return;
		  }
		  return;
	  }
	  
	  public static int getKillTokens() {
		  
		  if(Main.buff1 == true) {
			  return 2;
		  }
		  if(Main.buff2 == true) {
			  return 3;
		  }
		  
		  return 1;
		  
	  }
	


}

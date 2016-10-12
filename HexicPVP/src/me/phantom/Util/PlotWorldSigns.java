package me.phantom.Util;

import java.util.ArrayList;

import me.phantom.Main;
import me.phantom.RankingSystem.rankStorage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlotWorldSigns implements Listener {
	
	
	  private Main plugin;

	  public PlotWorldSigns(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	
	@EventHandler
    public void onPlayerInteract1(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        Block b = e.getClickedBlock();
            if(b.getType() == Material.WALL_SIGN || b.getType() == Material.SIGN_POST) {
                Sign sign = (Sign) b.getState();
                String[] lines = sign.getLines();
                if(lines[1].equalsIgnoreCase("§e§lPlotWorld")) {
                	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mvtp " + e.getPlayer().getName() + " plotworld");
                	 e.getPlayer().sendMessage(Main.getPrefix() + "§e§lTeleported to PlotWorld!");
                	 return;
                }
                }
            }
        }
	
	@EventHandler
    public void onPlayerInteract2(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        Block b = e.getClickedBlock();
            if(b.getType() == Material.WALL_SIGN || b.getType() == Material.SIGN_POST) {
                Sign sign = (Sign) b.getState();
                String[] lines = sign.getLines();
                if(lines[1].equalsIgnoreCase("§e§lSpawn")) {
                	 Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "spawn " + e.getPlayer().getName());
                	 e.getPlayer().sendMessage(Main.getPrefix() + "§e§lTeleported to Spawn!");
                	 return;
                }
                }
            }
        }
	
	
	
	 @EventHandler
	  public void flyPlots(PlayerChangedWorldEvent e) {
		 Player p = e.getPlayer();
	    if (rankStorage.loadPlayerRank(p).equalsIgnoreCase("owner") || rankStorage.loadPlayerRank(p).equalsIgnoreCase("developer") ||rankStorage.loadPlayerRank(p).equalsIgnoreCase("moderator") ||rankStorage.loadPlayerRank(p).equalsIgnoreCase("admin") ||
	    		rankStorage.loadPlayerRank(p).equalsIgnoreCase("SUB++")){
	      if (e.getPlayer().getWorld().getName().equalsIgnoreCase("plotworld"))
	      {
	        e.getPlayer().setAllowFlight(true);
	        e.getPlayer().sendMessage(Main.getPrefix() + "§aYou may now fly as you're in the plot world!");
	      }
	      else if (e.getPlayer().getAllowFlight())
	      {
	        e.getPlayer().setFlying(false);
	        e.getPlayer().setAllowFlight(false);
	        e.getPlayer().sendMessage(Main.getPrefix() + "§cYou may not longer fly as you're not in the plot world!");
	      }
	    }
	  }
	
	}
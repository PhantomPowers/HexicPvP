package me.phantom.Combat;

import java.util.List;
import java.util.Random;

import me.phantom.Main;
import me.phantom.DropSystem.Tiers.Common;
import me.phantom.DropSystem.Tiers.Legendary;
import me.phantom.DropSystem.Tiers.Rare;
import me.phantom.DropSystem.Tiers.Uncommon;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerCombatSystem implements Listener {
	
	  private Main plugin;

	  public PlayerCombatSystem(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  @EventHandler
	  public void playerHitPlayerEvent(EntityDamageByEntityEvent e) {
	  Entity damager = e.getDamager(); 
	  if (damager instanceof Player) {
	  Player p = (Player) damager;
	  e.setDamage(getDamageStat(p.getItemInHand()) + e.getDamage());
	  return;
	  }
	  return;
	  }
	  
	  
	
	
	
	 public static boolean isInt(String s) {
		    try {
		        Integer.parseInt(s);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    return true;
		}
	 

	  public static int getDamageStat(ItemStack i) {
	    if ((i != null) && (i.hasItemMeta()) && (i.getItemMeta().hasLore())) {
	      List<String> lore = i.getItemMeta().getLore();
	      for (String s : lore) {
	        s = ChatColor.stripColor(s);
	        if (s.startsWith("Damage:")) {
	          int value = Integer.parseInt(s.substring(s.indexOf(" ") + 1));
	          return value;
	        }
	      }
	    }

	    return 3;
	  }
	}

package me.phantom.Vendor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import me.phantom.Main;










import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ca.thederpygolems.armorequip.ArmorEquipEvent;

public class ItemEvents implements Listener {
	

	public static ArrayList<Player>  pvp =new ArrayList<Player>();
	
	
	  private Main plugin;

	  public ItemEvents(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  @EventHandler(priority=EventPriority.HIGH)
	  public void UseFirstBuff(PlayerInteractEvent event){
	      Player p = event.getPlayer();
	   
	      if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPvPPoints Global Boost - T1")){
	    	  if(Main.buff1 == false && Main.buff2 == false) {
	    		  Main.buff1 = true;
					 Main.buff1_timeout = System.currentTimeMillis() + (1800 * 1000);
					 Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + p.getName() + ChatColor.GOLD
	                       + " has just activated " + ChatColor.UNDERLINE + "+2x Global Kill Points Boost" + ChatColor.GOLD
	                       + " for 30 minutes");
					 if(p.getItemInHand().getAmount() == 1) {
					 p.setItemInHand(new ItemStack(Material.AIR));
					 return;
					 }
					  ItemStack SpeedB = new ItemStack(Material.NETHER_STAR, p.getItemInHand().getAmount()-1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§c§lPvPPoints Global Boost - T1");
				        meta0.setLore(Arrays.asList(new String[] { "§e2X Points for 30 Minutes", "§7Right Click to Activate"}));
				        SpeedB.setItemMeta(meta0);
					 p.setItemInHand(SpeedB);
					 return;
	    	  }
	    	  p.sendMessage("§4Global Boost currently active, wait until after to use this.");
	    	  return;
	      }
	      return;
	  }
	  
	  @EventHandler(priority=EventPriority.HIGH)
	  public void UseSecondBuff(PlayerInteractEvent event){
	      Player p = event.getPlayer();
	   
	      if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lPvPPoints Global Boost - T2")){
	    	  if(Main.buff1 == false && Main.buff2 == false) {
	    		  Main.buff2 = true;
					 Main.buff2_timeout = System.currentTimeMillis() + (1800 * 1000);
					 Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + ">> " + ChatColor.RESET + p.getName() + ChatColor.GOLD
	                       + " has just activated " + ChatColor.UNDERLINE + "+3x Global Kill Points Boost" + ChatColor.GOLD
	                       + " for 30 minutes");
					 if(p.getItemInHand().getAmount() == 1) {
					 p.setItemInHand(new ItemStack(Material.AIR));
					 return; 
					 }
					  ItemStack SpeedB = new ItemStack(Material.NETHER_STAR, p.getItemInHand().getAmount()-1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§c§lPvPPoints Global Boost - T2");
				        meta0.setLore(Arrays.asList(new String[] { "§e3X Points for 30 Minutes", "§7Right Click to Activate"}));
				        SpeedB.setItemMeta(meta0);
					 p.setItemInHand(SpeedB);
					 return;
	    	  }
	    	  p.sendMessage("§4Global Boost currently active, wait until after to use this.");
	    	  return;
	      }
	      return;
	  }
	  
	  @EventHandler
	    public void onPlayerJoin(ArmorEquipEvent e) {
		Player p = e.getPlayer();
		if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.LEATHER_BOOTS) {
			ItemStack boots = e.getNewArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKiller Boots of Shear Speed")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5 * 2000000, 1));
				return;
			}
			return;
		}
		if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.LEATHER_BOOTS) {
			ItemStack boots = e.getOldArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKiller Boots of Shear Speed")) {
				p.removePotionEffect(PotionEffectType.SPEED);
			}
			return;
		}
		return;
	  }
	  
	  @EventHandler (ignoreCancelled = true)
	    public void onArmorSlot(InventoryClickEvent e) {
			Player p = (Player)e.getWhoClicked();
	        if (e.getSlotType().equals(SlotType.ARMOR) && e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
	        	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKiller Boots of Shear Speed")) {
	        		p.removePotionEffect(PotionEffectType.SPEED);
	        		return;
	        	}
	        	return;
	        }
	        return;
	        }
	  
	  @EventHandler(ignoreCancelled = true)
	    public void onPlayerItemBreak(PlayerItemBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBrokenItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lKiller Boots of Shear Speed")) {
				p.removePotionEffect(PotionEffectType.SPEED);
				return;
			}
			return;
	  }
	  
	  @EventHandler
	    public void onPlayerJoin22(ArmorEquipEvent e) {
		Player p = e.getPlayer();
		if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.IRON_CHESTPLATE) {
			ItemStack boots = e.getNewArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§b§lFuture Thundering Saturation Plate")) {
				p.setSaturation(500);
				return;
			}
			return;
		}
		if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.IRON_CHESTPLATE) {
			ItemStack boots = e.getOldArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§b§lFuture Thundering Saturation Plate")) {
				p.setSaturation(0);
			}
			return;
		}
		return;
	  }
	  
	  @EventHandler (ignoreCancelled = true)
	    public void onArmorSlot22(InventoryClickEvent e) {
			Player p = (Player)e.getWhoClicked();
	        if (e.getSlotType().equals(SlotType.ARMOR) && e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
	        	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lFuture Thundering Saturation Plate")) {
	        		p.setSaturation(0);
	        		return;
	        	}
	        	return;
	        }
	        return;
	        }
	  
	  @EventHandler(ignoreCancelled = true)
	    public void onPlayerItemBreak22(PlayerItemBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBrokenItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lFuture Thundering Saturation Plated")) {
				p.setSaturation(0);
				return;
			}
			return;
	  }
	    
	  @EventHandler
	  public void playerHitPlayerEvent(EntityDamageByEntityEvent event) {
	  Entity damager = event.getDamager(); 
	  Entity player = event.getEntity();
	  if (damager instanceof Player && player instanceof Player) {
		  Player p = (Player) player;
		  Random random = new Random();
		    int chance = random.nextInt(100)+1;
		    if(chance <= 5 && p.getItemInHand().getItemMeta().getLore().contains("§7Wither V")) {
		    	((LivingEntity) damager).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 2, 2));
		    }
		    return;
	  }
	  return;
	  }

	  
	  @EventHandler
	    public void onPlayerJoin3(ArmorEquipEvent e) {
		Player p = e.getPlayer();
		if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.CHAINMAIL_CHESTPLATE) {
			ItemStack boots = e.getNewArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lBreast Plate of Cactus Execution")) {
				pvp.add(p);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 5F, 5F);
				return;
			}
			return;
		}
		if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.CHAINMAIL_CHESTPLATE) {
			ItemStack boots = e.getOldArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§e§lBreast Plate of Cactus Execution")) {
				pvp.remove(p);
			}
			return;
		}
		return;
	  }
	  
	  @EventHandler (ignoreCancelled = true)
	    public void onArmorSlot3(InventoryClickEvent e) {
			Player p = (Player)e.getWhoClicked();
	        if (e.getSlotType().equals(SlotType.ARMOR) && e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
	        	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lBreast Plate of Cactus Execution")) {
	        		pvp.remove(p);
	        		return;
	        	}
	        	return;
	        }
	        return;
	        }
	  
	  @EventHandler(ignoreCancelled = true)
	    public void onPlayerItemBreak3(PlayerItemBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBrokenItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lBreast Plate of Cactus Execution")) {
				pvp.remove(p);
				return;
			}
			return;
	  }
	  
	  @EventHandler
	  public void playerHitPlayerEvent3(EntityDamageByEntityEvent event) {
	  Entity damager = event.getDamager(); 
	  Entity player = event.getEntity();
	  if (damager instanceof Player && player instanceof Player) {
		  Player p = (Player) player;
		  Random random = new Random();
		    int chance = random.nextInt(100)+1;
		    double damage = ((Damageable) damager).getHealth() %5;
		    if(chance <= 5 && pvp.contains(p)) {
		    	((LivingEntity) damager).setHealth(((LivingEntity) damager).getHealth()-damage);
		    }
		    return;
	  }
	  return;
	  }

	  @EventHandler
	    public void onPlayerJoin2(ArmorEquipEvent e) {
		Player p = e.getPlayer();
		if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.DIAMOND_BOOTS) {
			ItemStack boots = e.getNewArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lFine Embossed Jordans")) {
				p.setAllowFlight(true);
				
				return;
			}
			return;
		}
		if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.DIAMOND_BOOTS) {
			ItemStack boots = e.getOldArmorPiece();
			if(boots.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lFine Embossed Jordans")) {
				p.setAllowFlight(false);
				p.setFlying(false);
			}
			return;
		}
		return;
	  }
	  
	  @EventHandler (ignoreCancelled = true)
	    public void onArmorSlot2(InventoryClickEvent e) {
			Player p = (Player)e.getWhoClicked();
	        if (e.getSlotType().equals(SlotType.ARMOR) && e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
	        	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lFine Embossed Jordans")) {
					p.setAllowFlight(false);
					p.setFlying(false);
	        		return;
	        	}
	        	return;
	        }
	        return;
	        }
	  
	  @EventHandler(ignoreCancelled = true)
	    public void onPlayerItemBreak2(PlayerItemBreakEvent e) {
			Player p = e.getPlayer();
			if(e.getBrokenItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lFine Embossed Jordans")) {
				p.setAllowFlight(false);
				p.setFlying(false);
				return;
			}
			return;
	  }
}

package me.phantom.Combat;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import me.phantom.Main;
import me.phantom.DropSystem.Tiers.Common;
import me.phantom.DropSystem.Tiers.Legendary;
import me.phantom.DropSystem.Tiers.Rare;
import me.phantom.DropSystem.Tiers.Uncommon;
import me.phantom.LevelingSystem.levelStorage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import ca.thederpygolems.armorequip.ArmorEquipEvent;

public class HealthSystem implements Listener{
	  private Main plugin;

	  public HealthSystem(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  public static ConcurrentHashMap<String, Integer> player_health = new ConcurrentHashMap<String, Integer>();
	  
		public static HashMap<String, Integer> health_data = new HashMap<String, Integer>();
		
		@EventHandler(ignoreCancelled = true)
	    public void onPlayerItemBreak(PlayerItemBreakEvent e) {
			Player p = e.getPlayer();
			if(isHelmet(e.getBrokenItem()) == true) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				int Health = 10 + getHealthStat(chestplate) + getHealthStat(leggings) + getHealthStat(boots);
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("§c§l- Helmet Broke");
			}
			if(isChestplate(e.getBrokenItem())) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				int Health = getHealthStat(helmet) + 10 + getHealthStat(leggings) + getHealthStat(boots);
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("§c§l- Chestplate Broke");
			}
			if(isLeggings(e.getBrokenItem())) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				int Health = getHealthStat(helmet) + getHealthStat(chestplate) + 10 + getHealthStat(boots);
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("§c§l- Leggings Broke");
			}
			if(isBoots(e.getBrokenItem())) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				int Health = getHealthStat(helmet) + getHealthStat(chestplate) + getHealthStat(leggings) + 10;
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("§c§l- Boots Broke");
			}
			return;
	    }
		
		@EventHandler(ignoreCancelled = true)
	    public void onPlayerJoinn(PlayerJoinEvent e) {
			Player p = e.getPlayer();
			int armor = 0;
			ItemStack helmet = p.getInventory().getHelmet();
			ItemStack chestplate = p.getInventory().getChestplate();
			ItemStack leggings = p.getInventory().getLeggings();
			ItemStack boots = p.getInventory().getBoots();
			if(p.getInventory().getHelmet() != null) {
				armor++;
			}
			if(p.getInventory().getChestplate() != null) {
				armor++;
			}
			if(p.getInventory().getLeggings() != null) {
				armor++;
			}
			if(p.getInventory().getBoots() != null) {
				armor++;
			}
			armor++;
			int Health = getHealthStat(helmet) + getHealthStat(chestplate) + getHealthStat(leggings) + getHealthStat(boots) + armor * 10;
			p.setHealthScale(20);
			p.setHealthScaled(true);
			p.setMaxHealth(Health);
			p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
			return;
		}
		
		@EventHandler
		    public void onPlayerJoin(ArmorEquipEvent e) {
			Player p = e.getPlayer();
			
			//Helmet's
			if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.LEATHER_HELMET || 
					e.getNewArmorPiece().getType() == Material.CHAINMAIL_HELMET || e.getNewArmorPiece().getType() == Material.GOLD_HELMET || 
					e.getNewArmorPiece().getType() == Material.DIAMOND_HELMET || e.getNewArmorPiece().getType() == Material.IRON_HELMET) {
				ItemStack helmet = e.getNewArmorPiece();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				int armor = 0;
				if(p.getInventory().getChestplate() != null) {
					armor++;
				}
				if(p.getInventory().getLeggings() != null) {
					armor++;
				}
				if(p.getInventory().getBoots() != null) {
					armor++;
				}
				armor++;
				int Health = getHealthStat(helmet) + getHealthStat(chestplate) + getHealthStat(leggings) + getHealthStat(boots) + armor * 10;
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §a+§a§l" + getHealthStat(helmet) + " §a§lHP");
			}
			//Chestplate's
			if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.LEATHER_CHESTPLATE || 
					e.getNewArmorPiece().getType() == Material.CHAINMAIL_CHESTPLATE || e.getNewArmorPiece().getType() == Material.GOLD_CHESTPLATE || 
					e.getNewArmorPiece().getType() == Material.DIAMOND_CHESTPLATE || e.getNewArmorPiece().getType() == Material.IRON_CHESTPLATE) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = e.getNewArmorPiece();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				int armor = 0;
				if(p.getInventory().getHelmet() != null) {
					armor++;
				}
				if(p.getInventory().getLeggings() != null) {
					armor++;
				}
				if(p.getInventory().getBoots() != null) {
					armor++;
				}
				armor++;
				int Health = getHealthStat(helmet) + getHealthStat(chestplate) + getHealthStat(leggings) + getHealthStat(boots) + armor * 10;
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §a+§a§l" + getHealthStat(chestplate) + " §a§lHP");
			}
			//Legging's
			if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.LEATHER_LEGGINGS || 
					e.getNewArmorPiece().getType() == Material.CHAINMAIL_LEGGINGS || e.getNewArmorPiece().getType() == Material.GOLD_LEGGINGS || 
					e.getNewArmorPiece().getType() == Material.DIAMOND_LEGGINGS|| e.getNewArmorPiece().getType() == Material.IRON_LEGGINGS) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = e.getNewArmorPiece();
				ItemStack boots = p.getInventory().getBoots();
				int armor = 0;
				if(p.getInventory().getChestplate() != null) {
					armor++;
				}
				if(p.getInventory().getHelmet() != null) {
					armor++;
				}
				if(p.getInventory().getBoots() != null) {
					armor++;
				}
				armor++;
				int Health = getHealthStat(helmet) + getHealthStat(chestplate) + getHealthStat(leggings) + getHealthStat(boots) + armor * 10;
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §a+§a§l" + getHealthStat(leggings) + " §a§lHP");
			}
			//Boot's
			if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR && e.getNewArmorPiece().getType() == Material.LEATHER_BOOTS || 
					e.getNewArmorPiece().getType() == Material.CHAINMAIL_BOOTS || e.getNewArmorPiece().getType() == Material.GOLD_BOOTS || 
					e.getNewArmorPiece().getType() == Material.DIAMOND_BOOTS || e.getNewArmorPiece().getType() == Material.IRON_BOOTS) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = e.getNewArmorPiece();
				int armor = 0;
				if(p.getInventory().getChestplate() != null) {
					armor++;
				}
				if(p.getInventory().getLeggings() != null) {
					armor++;
				}
				if(p.getInventory().getHelmet() != null) {
					armor++;
					
				}
				armor++;
				int Health = getHealthStat(helmet) + getHealthStat(chestplate) + getHealthStat(leggings) + getHealthStat(boots) + armor * 10;
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §a+§a§l" + getHealthStat(boots) + " §a§lHP");
			}
			
			if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.LEATHER_HELMET ||
					e.getOldArmorPiece().getType() == Material.IRON_HELMET ||
					e.getOldArmorPiece().getType() == Material.CHAINMAIL_HELMET ||
					e.getOldArmorPiece().getType() == Material.GOLD_HELMET ||
					e.getOldArmorPiece().getType() == Material.DIAMOND_HELMET) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				p.setHealthScale(20);
				p.setHealthScaled(true);
				int Health = (int) (p.getMaxHealth() - getHealthStat(helmet));
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §c-§c§l" + getHealthStat(helmet) + " §c§lHP");
				return;
			}
			if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.LEATHER_CHESTPLATE ||
					e.getOldArmorPiece().getType() == Material.IRON_CHESTPLATE ||
					e.getOldArmorPiece().getType() == Material.CHAINMAIL_CHESTPLATE ||
					e.getOldArmorPiece().getType() == Material.GOLD_CHESTPLATE ||
					e.getOldArmorPiece().getType() == Material.DIAMOND_CHESTPLATE) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				p.setHealthScale(20);
				p.setHealthScaled(true);
				int Health = (int) (p.getMaxHealth() - getHealthStat(chestplate));
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §c-§c§l" + getHealthStat(chestplate) + " §c§lHP");
				return;
				
			}
			if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.LEATHER_LEGGINGS ||
					e.getOldArmorPiece().getType() == Material.IRON_LEGGINGS ||
					e.getOldArmorPiece().getType() == Material.CHAINMAIL_LEGGINGS ||
					e.getOldArmorPiece().getType() == Material.GOLD_LEGGINGS ||
					e.getOldArmorPiece().getType() == Material.DIAMOND_LEGGINGS) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				p.setHealthScale(20);
				p.setHealthScaled(true);
				int Health = (int) (p.getMaxHealth() - getHealthStat(leggings));
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §c-§c§l" + getHealthStat(leggings) + " §c§lHP");
				return;
				
			}
			if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR && e.getOldArmorPiece().getType() == Material.LEATHER_BOOTS ||
					e.getOldArmorPiece().getType() == Material.IRON_BOOTS ||
					e.getOldArmorPiece().getType() == Material.CHAINMAIL_BOOTS ||
					e.getOldArmorPiece().getType() == Material.GOLD_BOOTS ||
					e.getOldArmorPiece().getType() == Material.DIAMOND_BOOTS) {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				p.setHealthScale(20);
				p.setHealthScaled(true);
				int Health = (int) (p.getMaxHealth() - getHealthStat(boots));
				p.setMaxHealth(Health);
				p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
				p.sendMessage("               §c-§c§l" + getHealthStat(boots) + " §c§lHP");
				return;
				
			}
			return;
		}
		
		@EventHandler (ignoreCancelled = true)
	    public void onArmorSlot(InventoryClickEvent e) {
			Player p = (Player)e.getWhoClicked();
	        if (e.getSlotType().equals(SlotType.ARMOR) && e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
	            if(isHelmet(e.getCurrentItem())) {
					ItemStack helmet = p.getInventory().getHelmet();
					ItemStack chestplate = p.getInventory().getChestplate();
					ItemStack leggings = p.getInventory().getLeggings();
					ItemStack boots = p.getInventory().getBoots();
					p.setHealthScale(20);
					p.setHealthScaled(true);
					p.setMaxHealth(p.getMaxHealth() - getHealthStat(helmet));
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
					int helm = getHealthStat(helmet);
					p.sendMessage("               §c-§c§l" + helm + " §c§lHP");
	            }
	            if(isChestplate(e.getCurrentItem())) {
					ItemStack helmet = p.getInventory().getHelmet();
					ItemStack chestplate = p.getInventory().getChestplate();
					ItemStack leggings = p.getInventory().getLeggings();
					ItemStack boots = p.getInventory().getBoots();
					p.setHealthScale(20);
					p.setHealthScaled(true);
					p.setMaxHealth(p.getMaxHealth() - getHealthStat(chestplate));
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
					int helm = getHealthStat(chestplate);
					p.sendMessage("               §c-§c§l" + helm + " §c§lHP");
	            }
	            if(isLeggings(e.getCurrentItem())) {
					ItemStack helmet = p.getInventory().getHelmet();
					ItemStack chestplate = p.getInventory().getChestplate();
					ItemStack leggings = p.getInventory().getLeggings();
					ItemStack boots = p.getInventory().getBoots();
					p.setHealthScale(20);
					p.setHealthScaled(true);
					p.setMaxHealth(p.getMaxHealth() - getHealthStat(leggings));
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
					int helm = getHealthStat(leggings);
					p.sendMessage("               §c-§c§l" + helm + " §c§lHP");
	            }
	            if(isBoots(e.getCurrentItem())) {
					ItemStack helmet = p.getInventory().getHelmet();
					ItemStack chestplate = p.getInventory().getChestplate();
					ItemStack leggings = p.getInventory().getLeggings();
					ItemStack boots = p.getInventory().getBoots();
					p.setHealthScale(20);
					p.setHealthScaled(true);
					p.setMaxHealth(p.getMaxHealth() - getHealthStat(boots));
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 3, 1);
					int helm = getHealthStat(boots);
					p.sendMessage("               §c-§c§l" + helm + " §c§lHP");
	            }
	            
	    }
	        return;
	}
		

		
		
		// Max data of a given player, used in many different plugins, CommunityMechanics, ItemMechanics
		
	
	 // @EventHandler
	//    public void onPlayerJoin(PlayerJoinEvent e) {
	//	    final Player pl = e.getPlayer();
	//	    if(pl.getName().equalsIgnoreCase("PhantomPowerdfsdf")) {
	//	    	pl.setHealthScale(20);
	//	    	pl.setHealthScaled(true);
	///	    	pl.setMaxHealth(79);
	//	    	final List<String> messages = Arrays.asList(
	//					"§e[Global Dungeon]§7 Starting in §c10",
	//					"§e[Global Dungeon]§7 Starting in §c9",
	//					"§e[Global Dungeon]§7 Starting in §c8",
	//					"§e[Global Dungeon]§7 Starting in §c7",
	//					"§e[Global Dungeon]§7 Starting in §c6",
	//					"§e[Global Dungeon]§7 Starting in §c5",
	//					"§e[Global Dungeon]§7 Starting in §c4",
	//					"§e[Global Dungeon]§7 Starting in §c3",
	//					"§e[Global Dungeon]§7 Starting in §c2",
	//					"§e[Global Dungeon]§7 Starting in §c1"	
	//				);
	//				
	//				new BukkitRunnable() {
	//					private int pos = 0;
	//					
	//					public void run() {
	//						if(messages.size() - 1 >= pos){
	//							pl.sendMessage(messages.get(pos));
	//							pos++;
	//						}else{
	///							pl.sendMessage("§e[Global Dungeon]§7 Has Begun");
	///							pl.setGameMode(GameMode.SURVIVAL);
	//							cancel();
	//						}
	//					}
	//				}.runTaskTimer(Main.plugin, 0L, 20L);
	//			
	//	    }
	//  }
	  
	//  @EventHandler(priority = EventPriority.NORMAL)
	 // public void dmg(final EntityDamageEvent event) {
	//  Entity e = event.getEntity();
	//  if(!(e instanceof Player)) { event.setCancelled(true); }
	//  Player p = (Player) event.getEntity();
	//  int dmg = (int) Math.round(event.getDamage());
//	  int h1 = (int) Math.round(p.getHealth()) - dmg;
	//  int health = getHealth(h1);
//	  p.sendMessage("      §c-" + dmg + "§c§lHP§r§c  [" + health + "/" + Math.round(p.getMaxHealth()) + "]");
	//  }
	  
	  public static int getHealth(int health){
		  if(health < 0) {
		return 0;
	  }
		  else{
			  return health;
		  }
	  }
	  
		public static void setPlayerHP(String p_name, int hp) {
			/*if(plugin.getServer().getPlayer(p_name) != null){
				Player pl = plugin.getServer().getPlayer(p_name);
				pl.setMetadata("dr_hp", new FixedMetadataValue(plugin, hp));
			}*/

			player_health.put(p_name, hp);
		}

		public static int getPlayerHP(String p_name) {
			if(player_health.containsKey(p_name)) { return player_health.get(p_name); }
			// If the data doesn't exist, return default?
			return 50;

			/*if(plugin.getServer().getPlayer(p_name) != null){
				Player pl = plugin.getServer().getPlayer(p_name);
				if(pl.hasMetadata("dr_hp")){
					return pl.getMetadata("dr_hp").get(0).asInt();
				}
			}
			return -1;*/
		}
		public static int getMaxHealthValue(String p_name) {
			if(health_data.containsKey(p_name)) { return health_data.get(p_name); }
			return 1; // Never even setMaxHealth. Impossible?
		}

		public void setLocalMaxHealth(String p_name, double new_max_hp) {
			health_data.put(p_name, (int) new_max_hp);
		}
	
		public static boolean isInt(String s) {
		    try {
		        Integer.parseInt(s);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    return true;
		}
	 

	  public static int getHealthStat(ItemStack i) {
	    if ((i != null) && (i.hasItemMeta()) && (i.getItemMeta().hasLore())) {
	      List<String> lore = i.getItemMeta().getLore();
	      for (String s : lore) {
	        s = ChatColor.stripColor(s);
	        if (s.startsWith("Health:")) {
	          int value = Integer.parseInt(s.substring(s.indexOf(" ") + 1));
	          return value;
	        }
	      }
	    }

	    return 10;
	  }
	  public static boolean isHelmet(ItemStack i) {
		  if(i.getType() == Material.LEATHER_HELMET || i.getType() == Material.CHAINMAIL_HELMET || i.getType() == Material.GOLD_HELMET
				  || i.getType() == Material.IRON_HELMET || i.getType() == Material.DIAMOND_HELMET) {
			  return true;
		  }
		  
		return false;
		  
	  }
	  public static boolean isChestplate(ItemStack i) {
		  if(i.getType() == Material.LEATHER_CHESTPLATE || i.getType() == Material.CHAINMAIL_CHESTPLATE || i.getType() == Material.GOLD_CHESTPLATE
				  || i.getType() == Material.IRON_CHESTPLATE || i.getType() == Material.DIAMOND_CHESTPLATE) {
			  return true;
		  }
		  
		return false;
		  
	  }
	  public static boolean isLeggings(ItemStack i) {
		  if(i.getType() == Material.LEATHER_LEGGINGS || i.getType() == Material.CHAINMAIL_LEGGINGS || i.getType() == Material.GOLD_LEGGINGS
				  || i.getType() == Material.IRON_LEGGINGS || i.getType() == Material.DIAMOND_LEGGINGS) {
			  return true;
		  }
		  
		return false;
		  
	  }
	  public static boolean isBoots(ItemStack i) {
		  if(i.getType() == Material.LEATHER_BOOTS || i.getType() == Material.CHAINMAIL_BOOTS || i.getType() == Material.GOLD_BOOTS
				  || i.getType() == Material.IRON_BOOTS || i.getType() == Material.DIAMOND_BOOTS) {
			  return true;
		  }
		  
		return false;
		  
	  }
}


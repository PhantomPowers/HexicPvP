package me.phantom.Tutorial;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;

import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import me.blackvein.quests.util.Lang;
import me.phantom.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class Tutorial implements Listener{
	
	 private Main plugin;

	  public Tutorial(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  
	  @EventHandler
	  public void onRegionEnter(RegionEnterEvent e)
	  {
	    Player p = e.getPlayer();
	    if(e.getRegion().getId().equalsIgnoreCase("tutorial") && showObjectives(p).equalsIgnoreCase("nQuest")) {
	    	p.sendMessage("§7You must talk to Finn before going here!");
            int x = p.getLocation().getBlockX()-3;
            int y = p.getLocation().getBlockY();
            int z = p.getLocation().getBlockZ();
            World w = Bukkit.getWorld("spawn");
            Location loc = new Location(w, x, y, z); //defines new location
	 		p.teleport(loc);
	    	e.setCancelled(true);
	    	return;
	    }
	    return;
	  }
	  @EventHandler
	  public void onRegionEnter1(RegionEnterEvent e)
	  {
	    Player p = e.getPlayer();
	    if(e.getRegion().getId().equalsIgnoreCase("boss") && !showObjectives1(p).equalsIgnoreCase("§aBoss Battle")) {
	    	p.sendMessage("§7a strange force is holding you back");
            int x = p.getLocation().getBlockX()-3;
            int y = p.getLocation().getBlockY();
            int z = p.getLocation().getBlockZ();
            World w = Bukkit.getWorld("spawn");
            Location loc = new Location(w, x, y, z); //defines new location
	 		p.teleport(loc);
	    	e.setCancelled(true);
	    	return;
	    }
	    return;
	  }
	 @EventHandler
	  public void JoinEvent(PlayerJoinEvent e) {
		 	Player p = e.getPlayer();
		 	if(getPlayerTutorial(p).equalsIgnoreCase("nTutorial") || loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) {
		 		storePlayerTutorial(p, "nTutorial");
	            int x = 136;
	            int y = 6;
	            int z = -213;
	            World w = Bukkit.getWorld("spawn");
	            Location loc = new Location(w, x, y, z); //defines new location
		 		p.teleport(loc);
			  	p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5 * 2000000, 2));
			  	p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 0.8F);
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("");
			  	p.sendMessage("                  §f§l      LegendPvP Beta 1.0.0                      ");
			  	p.sendMessage("                   §7      http://www.minerift.net                    ");
			  	p.sendMessage("");
			  	p.sendMessage("                    §e         Tutorial Island        ");
			  p.sendMessage("                                                                        ");
			  	
			  	 ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
				    ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				    ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				    ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS, 1); 
				    ItemStack Sword = new ItemStack(Material.STONE_SWORD, 1);
				    ItemStack Bow = new ItemStack(Material.BOW,1);
				    ItemStack Gapple = new ItemStack(Material.GOLDEN_APPLE, 12);
				    ItemStack Steak = new ItemStack(Material.COOKED_BEEF, 64);
				    ItemStack Arrow = new ItemStack(Material.ARROW,64);
				    
				    ItemMeta meta0 = Helmet.getItemMeta();
			        meta0.setDisplayName("§rStarter Helmet");
			        meta0.setLore(Arrays.asList(new String[] { "§7Common"}));
			        Helmet.setItemMeta(meta0);
			        
				    ItemMeta meta1 = Chestplate.getItemMeta();
			        meta1.setDisplayName("§rStarter Chestplate");
			        meta1.setLore(Arrays.asList(new String[] { "§7Common"}));
			        Chestplate.setItemMeta(meta1);
			        
				    ItemMeta meta2 = Leggings.getItemMeta();
			        meta2.setDisplayName("§rStarter Leggings");
			        meta2.setLore(Arrays.asList(new String[] { "§7Common"}));
			        Leggings.setItemMeta(meta2);
			        
				    ItemMeta meta3 = Boots.getItemMeta();
			        meta3.setDisplayName("§rStarter Boots");
			        meta3.setLore(Arrays.asList(new String[] { "§7Common"}));
			        Boots.setItemMeta(meta3);
			        
				    ItemMeta meta4 = Sword.getItemMeta();
			        meta4.setDisplayName("§rStarter Sword");
			        meta4.setLore(Arrays.asList(new String[] { "§7Common"}));
			        Sword.setItemMeta(meta4);
			        
				    ItemMeta meta5 = Bow.getItemMeta();
			        meta5.setDisplayName("§rStarter Bow");
			        meta5.setLore(Arrays.asList(new String[] { "§7Common"}));
			        Bow.setItemMeta(meta5);
			        
			        
			        p.getInventory().clear();
			        p.getInventory().setHelmet(Helmet);
			        p.getInventory().setChestplate(Chestplate);
			        p.getInventory().setLeggings(Leggings);
			        p.getInventory().setBoots(Boots);
			        p.getInventory().addItem(Sword, Bow, Gapple, Steak, Arrow);
		 		return;
		 	}
		 	return;

	 }
	 
	 @EventHandler
	  public void BlockBreak(BlockBreakEvent e) {
		 Player p = e.getPlayer();
		 if(loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) {
			 e.setCancelled(true);
			 return;
		 }
		 return;
	 }
	 
	 @EventHandler
	  public void blockPlace(BlockPlaceEvent e) {
		 Player p = e.getPlayer();
		 if(loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) {
			 e.setCancelled(true);
			 return;
		 }
		 return;
	 }
	  
	  
	    @EventHandler
	    public void PlayerCommand(PlayerCommandPreprocessEvent e) {
	        Player p = e.getPlayer();
	        if(loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) {
	        p.sendMessage(Main.getPrefix() + "§cError: You cannot run commands during the tutorial!");
	        e.setCancelled(true);
	        return;
	        }
	        return;
	    }
	    
	    @EventHandler
	    public void PlayerChat(AsyncPlayerChatEvent e) {
	        Player p = e.getPlayer();
	        if(loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")){
	        p.sendMessage("§7you talk but no one hears");
	        e.setCancelled(true);
	        return;
	        }
	        return;
	    }
	    
	    @EventHandler
	    public void PlayerDamage(EntityDamageByEntityEvent e) {
	    	Player p = (Player) e.getDamager();
	    	Player pl = (Player) e.getEntity();
	    	
	    	if(!(e.getDamager() instanceof Player)) { return; }
	    	if(!e.getDamager().getLocation().getWorld().getName().equalsIgnoreCase("Tutorial")){
	        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
	        if(loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")){
	        p.sendMessage("§cPvP Disabled in Tutorial");
	        e.setCancelled(true);
	        return;
	        }
	        if(loadPlayerTutorial(pl).equalsIgnoreCase("nTutorial")) {
		        pl.sendMessage("§cPvP Disabled in Tutorial");
		        e.setCancelled(true);
		        return;
	        }
	        return;
	        }
	        return;
	    	}
	    	return;
	    }
	    
		  @EventHandler
		    public void onPlayerDeath(PlayerDeathEvent e) {
		        Player p = ((Player) e).getPlayer();
		        if(loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) {
		        	p.getInventory().clear();
		        	e.getDrops().clear();
		        	forceDelete(e);
		        	return;
		        }
		        return;
		  }
	 Properties props = new Properties();

	
	  public static String getPlayerTutorial(Player p) {
		  String s = loadPlayerTutorial(p);
		if(s == null) {
			return "nTutorial";
		}
		return s;
		}
	
	  public static void storePlayerTutorial(Player p, String i) {
		  File file = new File("plugins/HexicPvP/pTutorial/" + p.getUniqueId().toString() +".properties");
		  try {
		   
		  if (!file.exists()) {
		  file.createNewFile();
		  }
		   
		  Properties props = new Properties();
		  FileInputStream fis = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(file);
		  props.load(fis);
		  props.setProperty(p.getUniqueId().toString(), i);
		  props.store(out, "Player Tutorial Storage");
		  out.close();
		  fis.close();
		   
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
		  }
	  public static String loadPlayerTutorial(Player p) {
		  File file = new File("plugins/HexicPvP/pTutorial/" + p.getUniqueId().toString() +".properties");
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

			
		  public String getPlayerQuest(Player p) {
			  String s = loadPlayerQuest(p);
			if(s == null) {
				return "nTutorial";
			}
			return s;
			}
		
		  public static void storePlayerQuest(Player p, String i) {
			  File file = new File("plugins/HexicPvP/pTutorial/pQuest/" + p.getUniqueId().toString() +".properties");
			  try {
			   
			  if (!file.exists()) {
			  file.createNewFile();
			  }
			   
			  Properties props = new Properties();
			  FileInputStream fis = new FileInputStream(file);
			  FileOutputStream out = new FileOutputStream(file);
			  props.load(fis);
			  props.setProperty(p.getUniqueId().toString(), i);
			  props.store(out, "Player Quest Storage");
			  out.close();
			  fis.close();
			   
			  } catch (IOException e) {
			  e.printStackTrace();
			  }
			  }
		  public static String loadPlayerQuest(Player p) {
			  File file = new File("plugins/HexicPvP/pTutorial/pQuest/" + p.getUniqueId().toString() +".properties");
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
	  public static String showObjectives(Player player) {

	        if (Quests.getInstance().getQuester(player.getUniqueId()).currentQuests.isEmpty() == false) {

	            for (Quest q : Quests.getInstance().getQuester(player.getUniqueId()).currentQuests.keySet()) {

	                if (Quests.getInstance().getQuester(player.getUniqueId()).getQuestData(q).delayStartTime == 0) {

	                    String msg = Lang.get("questObjectivesTitle");
	                    msg = msg.replaceAll("<quest>", q.name);

	                    return msg;

	                }

	            }


	        }
			return "nQuest";

	    }
	  public static String showObjectives1(Player player) {

	        if (Quests.getInstance().getQuester(player.getUniqueId()).currentQuests.isEmpty() == false) {

	            for (Quest q : Quests.getInstance().getQuester(player.getUniqueId()).currentQuests.keySet()) {

	                if (Quests.getInstance().getQuester(player.getUniqueId()).getQuestData(q).delayStartTime == 0) {

	                    String msg = Lang.get("questObjectivesTitle");
	                    msg = msg.replaceAll("<quest>", q.name);
	                    
	                   for (String s : Quests.getInstance().getQuester(player.getUniqueId()).getObjectivesReal(q)) {

	                    return s;
	                   }

	                }

	            }


	        }
			return "nObjective";

	    }
	  public void forceDelete(EntityDeathEvent event)
	  {
	    for (int i = 0; i < event.getDrops().size(); i++)
	      event.getDrops().remove(i);
	  }
	

}

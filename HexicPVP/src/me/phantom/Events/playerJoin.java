package me.phantom.Events;

import java.util.ArrayList;
import java.util.Arrays;

import me.phantom.Main;



import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Tutorial.Tutorial;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class playerJoin implements Listener {
	
	  private Main plugin;

	  public playerJoin(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  static ArrayList<String>  join = new ArrayList<String>();
	  @EventHandler
	    public void onPlayerJoin(PlayerJoinEvent e) {
		    Player p = e.getPlayer();
		    
		    if(Tutorial.getPlayerTutorial(p).equalsIgnoreCase("nTutorial") || Tutorial.loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) {
		 		Tutorial.storePlayerTutorial(p, "nTutorial");
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
		    


	 		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "spawn " + p.getName());
	 		
		    ScoreboardUpdaters.setBoard(p);
		    ItemStack Helmet = new ItemStack(Material.IRON_HELMET, 1);
		    ItemStack Chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		    ItemStack Leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		    ItemStack Boots = new ItemStack(Material.IRON_BOOTS, 1);
		    
		    ItemMeta meta0 = Helmet.getItemMeta();
	        meta0.setDisplayName("§rHexic Helmet");
	        meta0.setLore(Arrays.asList(new String[] { "§7Default Helmet"}));
	        Helmet.setItemMeta(meta0);
	        
		    ItemMeta meta1 = Chestplate.getItemMeta();
	        meta1.setDisplayName("§rHexic Chestplate");
	        meta1.setLore(Arrays.asList(new String[] { "§7Default Chestplate"}));
	        Chestplate.setItemMeta(meta1);
	        
		    ItemMeta meta2 = Leggings.getItemMeta();
	        meta2.setDisplayName("§rHexic Leggings");
	        meta2.setLore(Arrays.asList(new String[] { "§7Default Leggings"}));
	        Leggings.setItemMeta(meta2);
	        
		    ItemMeta meta3 = Boots.getItemMeta();
	        meta3.setDisplayName("§rHexic Boots");
	        meta3.setLore(Arrays.asList(new String[] { "§7Default Boots"}));
	        Boots.setItemMeta(meta3);
	        

		    ItemStack Sword = new ItemStack(Material.IRON_SWORD, 1);
		    ItemStack Bow = new ItemStack(Material.BOW,1);
		    ItemStack Gapple = new ItemStack(Material.GOLDEN_APPLE, 12);
		    ItemStack Steak = new ItemStack(Material.COOKED_BEEF, 64);
		    ItemStack Arrow = new ItemStack(Material.ARROW,64);
		    
		    ScoreboardUpdaters.setBoard(p);
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage(" ");
	    	p.sendMessage("§6§m-----------------------------------------------");
	    	p.sendMessage("          Welcome,§d§l" + p.getName() + "§r to §6§lLegend PvP");
	    	p.sendMessage("      §7Hexic Minecraft KitPvP, Dominate the Crowd!");
	    	p.sendMessage(" ");
	    	p.sendMessage("        §a§lSHOP  §rComing Soon");
	    	p.sendMessage("        §c§lFORUMS §rComing Soon");
	    	p.sendMessage(" ");
	    	p.sendMessage("§6§m------------------------------------------------");
	    	return;
	  }
	  
	  @EventHandler
	  public void j(PlayerJoinEvent e) {
	    Player p = e.getPlayer();
	    if (!e.getPlayer().hasPlayedBefore()) {
	      p.kickPlayer(Main.getPrefix() + "You have been kicked for a player data save please relog!");
	      join.add(p.getName());
	    }
	  }
	 
	  
	    
}

package me.phantom.Tokens;

import java.util.Arrays;
import java.util.Random;

import me.phantom.Main;
import me.phantom.DropSystem.legendArmor;
import me.phantom.DropSystem.legendBow;
import me.phantom.DropSystem.legendWeapon;
import me.phantom.LevelingSystem.experienceStorage;
import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Util.debugStorage;
import me.phantom.Util.pPlotMe;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;


public class tokenShop implements Listener {

	
	  private Main plugin;

	  public tokenShop(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  @EventHandler
	  public void PlayerRightClick(PlayerInteractEntityEvent event) {
	    if ((event.getRightClicked() instanceof Player)) {
	      Player target = (Player) event.getRightClicked();
	      Player p = event.getPlayer();
	      if (target.getDisplayName().equalsIgnoreCase("§e§lToken Shop")) {
	        event.setCancelled(true);
	        ItemStack slot0 = new ItemStack(Material.BOOK, 1);
	        ItemStack slot1 = new ItemStack(Material.DIAMOND_SWORD, 1);
	        ItemStack slot2= new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	        ItemStack slot3 = new ItemStack(Material.CHEST, 1);
	        ItemStack slot4 = new ItemStack(Material.CHEST, 1);
	        ItemStack slot5= new ItemStack(Material.CHEST, 1);
	        ItemStack slot6 = new ItemStack(160, 1, (short) 7);
	        ItemStack slot8= new ItemStack(Material.BOW, 1);
	        
	        ItemMeta meta0 = slot0.getItemMeta();
	        meta0.setDisplayName("§a30x30 Plot");
	        meta0.setLore(Arrays.asList(new String[] { "§7Claim a plot in Plotme world", "§7Price:§a 10 Tokens"}));
	        slot0.setItemMeta(meta0);
	        
	        ItemMeta meta1 = slot1.getItemMeta();
	        meta1.setDisplayName("§e§lRandom Legend Weapon");
	        meta1.setLore(Arrays.asList(new String[] { "§7Random rare legend weapon!", "§7Price:§a 10 Tokens"}));
	        slot1.setItemMeta(meta1);
	        
	        ItemMeta meta5 = slot2.getItemMeta();
	        meta5.setDisplayName("§e§lRandom Legend Armor Piece");
	        meta5.setLore(Arrays.asList(new String[] { "§7Random rare legend armor piece!", "§7Price:§a 5 Tokens"}));
	        slot2.setItemMeta(meta5);
	        
	        ItemMeta meta8 = slot8.getItemMeta();
	        meta8.setDisplayName("§e§lRandom Legend Bow");
	        meta8.setLore(Arrays.asList(new String[] { "§7Rare legend bow!", "§7Price:§a 10 Tokens"}));
	        slot8.setItemMeta(meta8);
	        
	        ItemMeta meta2 = slot3.getItemMeta();
	        meta2.setDisplayName("§aTier 1 : Building Package");
	        meta2.setLore(Arrays.asList(new String[] { "§7Tier 1 Chest of Building Supplys for Plot", "§7Price:§a 1 Token"}));
	        slot3.setItemMeta(meta2);
	        
	        ItemMeta meta6 = slot4.getItemMeta();
	        meta6.setDisplayName("§aTier 2 : Building Package");
	        meta6.setLore(Arrays.asList(new String[] { "§7Tier 2 Chest of Building Supplys for Plot", "§7Price:§a 3 Token"}));
	        slot4.setItemMeta(meta6);
	        
	        ItemMeta meta7 = slot5.getItemMeta();
	        meta7.setDisplayName("§aTier 3 : Building Package");
	        meta7.setLore(Arrays.asList(new String[] { "§7Tier 3 Chest of Building Supplys for Plot", "§7Price:§a 5 Token"}));
	        slot5.setItemMeta(meta7);
	        
	        ItemMeta meta3 = slot6.getItemMeta();
	        meta3.setDisplayName(" ");
	        slot6.setItemMeta(meta3);
	        
	        
	        Inventory x104 = Bukkit.createInventory(null, 27, "Token Shop");

	        x104.setItem(0, slot6);
	        x104.setItem(1, slot6);
	        x104.setItem(2, slot6);
	        x104.setItem(3, slot6);
	        x104.setItem(4, slot0); //
	        x104.setItem(5, slot6);
	        x104.setItem(6, slot6);
	        x104.setItem(7, slot6);
	        x104.setItem(8, slot6);
	        x104.setItem(9, slot6);
	        x104.setItem(10, slot6);
	        x104.setItem(11, slot6);
	        x104.setItem(12, slot3);//
	        x104.setItem(13, slot4);//
	        x104.setItem(14, slot5);
	        x104.setItem(15, slot6);
	        x104.setItem(16, slot6);
	        x104.setItem(17, slot6);
	        x104.setItem(18, slot6);
	        x104.setItem(19, slot6);
	        x104.setItem(20, slot6);
	        x104.setItem(21, slot6);//
	        x104.setItem(22, slot6);//
	        x104.setItem(23, slot6);//
	        x104.setItem(24, slot6);
	        x104.setItem(25, slot6);
	        x104.setItem(26, slot6);

	        p.openInventory(x104);
	        p.getLocation().getWorld().playSound(p.getLocation(), Sound.ORB_PICKUP, 10F, 10F);
	      }
	    }
	  }
	  @EventHandler
	  public void onCLickev(InventoryClickEvent cevent)
	  {
	    Player por = (Player)cevent.getWhoClicked();
	    if (cevent.getInventory().getName() == "Token Shop") {
	      cevent.setCancelled(true);

	      if (cevent.getSlot() == 4) {
	        Player pl = (Player)cevent.getWhoClicked();

	        String s1 = tokenStorage.loadPlayerTokens(pl);
	        int tokens = Integer.parseInt(s1);
	        int tokenz = Integer.parseInt(s1) - 10;
	        String token = Integer.toString(tokenz);

	        if (tokens >= 10) {
	        	if(pPlotMe.loadPlayerPlots(pl).equalsIgnoreCase("false")) {
	        	pl.closeInventory();
	        	pl.sendMessage(Main.getPrefix() + "You can now claim a plot!");
	        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + pl.getName() + " plotme.use.claim");
	        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + pl.getName() + " plotme.limit.1");
	        	if(debugStorage.loadPlayerDebug(pl).equalsIgnoreCase("true")) {
		        	  pl.sendMessage("§c§l      -10 Tokens");
		        	  pl.playSound(pl.getLocation(), Sound.LEVEL_UP, 1F, 1F);
		          }
	        	tokenStorage.storePlayerTokens(pl, token);
	        	pPlotMe.storePlayerPlots(pl, "true");
	        	ScoreboardUpdaters.setBoard(pl);
	        	return;
	        	}
	        	pl.closeInventory();
	        	pl.sendMessage(Main.getPrefix() + "You already own a plot!");
	        	return;
	        }
	        pl.closeInventory();
	        por.sendMessage(Main.getPrefix() +"§7You cannot afford this!");
	        return;
	      }
	    }
	  }
	  @EventHandler
	  public void onCLickev2(InventoryClickEvent cevent)
	  {
	    Player por = (Player)cevent.getWhoClicked();
	    if (cevent.getInventory().getName() == "Token Shop") {
	      cevent.setCancelled(true);

	      if (cevent.getSlot() == 12) {
	        Player pl = (Player)cevent.getWhoClicked();

	        String s1 = tokenStorage.loadPlayerTokens(pl);
	        int tokens = Integer.parseInt(s1);
	        int tokenz = Integer.parseInt(s1) - 1;
	        String token = Integer.toString(tokenz);

	        if (tokens >= 1) {
	          Inventory target = pl.getInventory();
	          ItemStack common = new ItemStack(Material.CHEST, 1);

	          ItemMeta mm = common.getItemMeta();
	          mm.setDisplayName("§aTier 1 : Building Package");
	          mm.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
	          common.setItemMeta(mm);
	          target.addItem(new ItemStack[] { common });
	          if(debugStorage.loadPlayerDebug(pl).equalsIgnoreCase("true")) {
	        	  pl.sendMessage("§c§l      -1 Token");
	        	  pl.playSound(pl.getLocation(), Sound.LEVEL_UP, 1F, 1F);
	          }
	          tokenStorage.storePlayerTokens(pl, token);
	          ScoreboardUpdaters.setBoard(pl);
	          return;
	        }
	        pl.closeInventory();
	        por.sendMessage(Main.getPrefix() +"§7You cannot afford this!");
	        return;
	      }
	    }
	  }
	  @EventHandler
	  public void onCLickev5(InventoryClickEvent cevent)
	  {
	    Player por = (Player)cevent.getWhoClicked();
	    if (cevent.getInventory().getName() == "Token Shop") {
	      cevent.setCancelled(true);

	      if (cevent.getSlot() == 13) {
	        Player pl = (Player)cevent.getWhoClicked();

	        String s1 = tokenStorage.loadPlayerTokens(pl);
	        int tokens = Integer.parseInt(s1);
	        int tokenz = Integer.parseInt(s1) - 3;
	        String token = Integer.toString(tokenz);

	        if (tokens >= 3) {
	          Inventory target = pl.getInventory();
	          ItemStack common = new ItemStack(Material.CHEST, 1);

	          ItemMeta mm = common.getItemMeta();
	          mm.setDisplayName("§aTier 2 : Building Package");
	          mm.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
	          common.setItemMeta(mm);
	          target.addItem(new ItemStack[] { common });
	          if(debugStorage.loadPlayerDebug(pl).equalsIgnoreCase("true")) {
	        	  pl.sendMessage("§c§l      -3 Tokens");
	        	  pl.playSound(pl.getLocation(), Sound.LEVEL_UP, 1F, 1F);
	          }
	          tokenStorage.storePlayerTokens(pl, token);
	          ScoreboardUpdaters.setBoard(pl);
	          return;
	        }
	        pl.closeInventory();
	        por.sendMessage(Main.getPrefix() +"§7You cannot afford this!");
	        return;
	      }
	    }
	  }
	  @EventHandler
	  public void onCLickev55(InventoryClickEvent cevent)
	  {
	    Player por = (Player)cevent.getWhoClicked();
	    if (cevent.getInventory().getName() == "Token Shop") {
	      cevent.setCancelled(true);

	      if (cevent.getSlot() == 14) {
	        Player pl = (Player)cevent.getWhoClicked();

	        String s1 = tokenStorage.loadPlayerTokens(pl);
	        int tokens = Integer.parseInt(s1);
	        int tokenz = Integer.parseInt(s1) - 5;
	        String token = Integer.toString(tokenz);

	        if (tokens >= 5) {
	          Inventory target = pl.getInventory();
	          ItemStack common = new ItemStack(Material.CHEST, 1);

	          ItemMeta mm = common.getItemMeta();
	          mm.setDisplayName("§aTier 3 : Building Package");
	          mm.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
	          common.setItemMeta(mm);
	          target.addItem(new ItemStack[] { common });
	          if(debugStorage.loadPlayerDebug(pl).equalsIgnoreCase("true")) {
	        	  pl.sendMessage("§c§l      -5 Tokens");
	        	  pl.playSound(pl.getLocation(), Sound.LEVEL_UP, 1F, 1F);
	          }
	          tokenStorage.storePlayerTokens(pl, token);
	          ScoreboardUpdaters.setBoard(pl);
	          return;
	        }
	        pl.closeInventory();
	        por.sendMessage(Main.getPrefix() +"§7You cannot afford this!");
	        return;
	      }
	    }
	  }
	  


	  @EventHandler
	  public void onCLickev4(InventoryClickEvent cevent)
	  {
	    Player por = (Player)cevent.getWhoClicked();
	    if (cevent.getInventory().getName() == "Token Shop") {
	      cevent.setCancelled(true);

	      if (cevent.getSlot() == 0 || cevent.getSlot() == 1 || cevent.getSlot() == 2 || cevent.getSlot() == 6 || cevent.getSlot() == 7 || cevent.getSlot() == 8 ) {
	    	  cevent.setCancelled(true);

	      }
	    }
	  }
	  @EventHandler
	  public void onEntityDamage(EntityDamageEvent e){
	        if(e.getEntity() instanceof Villager){
	        	if(e.getEntity().getCustomName().equalsIgnoreCase("§e§lToken Shop")) {
	        		e.setCancelled(true);
	        	}
	        	
	        }
	  }



		 
		 @EventHandler
		 public void ChestSpawn(PlayerInteractEvent e){
		     Player p = e.getPlayer();;

		     
		     if(e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aTier 1 : Building Package")) {
		    	 
			     if(Main.isPlayerLocatedInHisPlot(p, e.getClickedBlock()) != true) { 
			    	 e.setCancelled(true);
			    	 p.sendMessage(Main.getPrefix()  + "Must place inside your plot!");
			    	 p.updateInventory();
			    	 return;
			    	 }
			     

			     
			    	    
		    	 
		    	 ItemStack log1 = new ItemStack(Material.LOG, 192);
		            ItemStack log2 = new ItemStack(Material.LOG, 192, (short) 1);
		            ItemStack log3 = new ItemStack(Material.LOG, 192,(short) 3);
		            ItemStack log4 = new ItemStack(Material.LOG, 192, (short) 2);
		            ItemStack bookshelf = new ItemStack(Material.BOOKSHELF, 16);
		            ItemStack furnace = new ItemStack(Material.FURNACE, 4);
		            ItemStack wb = new ItemStack(Material.WORKBENCH, 64);

		           Location location = e.getClickedBlock().getLocation();
		           int x = location.getBlockX();
		            int y = location.getBlockY()+1;
		            int z = location.getBlockZ();
		            int z1 = location.getBlockZ()-1;
		            World w = location.getWorld();
		            Location loc = new Location(w, x, y, z); //defines new location
		            Location loc1 = new Location(w, x, y, z1); //defines new location
		     Block block1 = loc.getBlock();
		     Block block2 = loc1.getBlock();
		           
		           
		           for (BlockFace blockface : BlockFace.values()) {
		               if (block1.getRelative(blockface).getType().equals(Material.CHEST) || block2.getRelative(blockface).getType().equals(Material.CHEST)) {
		                       e.setCancelled(true);
		                       return;
		               }
		           }
		     loc.getBlock().setType(Material.CHEST);
		     block1.getRelative(BlockFace.NORTH).setType(Material.CHEST);
		     Chest chest = (Chest)block1.getState();
		     Inventory inv = chest.getInventory();
		     inv.addItem(log1, log2, log3, log4, bookshelf, furnace, wb);
		     e.setCancelled(true);
		 		            if(p.getItemInHand().getAmount() > 1) {
		 		            	int amt = p.getItemInHand().getAmount() -1;
		 			 			ItemStack common = new ItemStack(Material.CHEST, amt);
		 			 			  ItemMeta mm = common.getItemMeta();
		 				         mm.setDisplayName("§aTier 1 : Building Package");
		 				          mm.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
		 				         common.setItemMeta(mm);
		 		            	p.setItemInHand(common);
		 		            	return;
		 		            }
		 		            p.setItemInHand(new ItemStack(Material.AIR));
		 		            return;
		
			    	    }

			     
		 }
		 
		 
		 
		 @SuppressWarnings("deprecation")
		@EventHandler
		 public void ChestSpawn1(PlayerInteractEvent e){
		     Player p = e.getPlayer();
		     
		     if(e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aTier 2 : Building Package")) {
		    	 
			     if(Main.isPlayerLocatedInHisPlot(p, e.getClickedBlock()) != true) { 
			    	 e.setCancelled(true);
			    	 p.sendMessage(Main.getPrefix()  + "Must place inside your plot!");
			    	 p.updateInventory();
			    	 return;
			    	 }
		    	 
		    	 ItemStack log1 = new ItemStack(98, 768);
		            ItemStack log2 = new ItemStack(Material.SANDSTONE, 256);
		            ItemStack bookshelf = new ItemStack(Material.BOOKSHELF, 128);
		            ItemStack furnace = new ItemStack(Material.FURNACE, 64);
		            ItemStack wb = new ItemStack(Material.WORKBENCH, 64);
		            

		            
			           Location location = e.getClickedBlock().getLocation();
			           int x = location.getBlockX();
			            int y = location.getBlockY()+1;
			            int z = location.getBlockZ();
			            int z1 = location.getBlockZ()-1;
			            World w = location.getWorld();
			            Location loc = new Location(w, x, y, z); //defines new location
			            Location loc1 = new Location(w, x, y, z1); //defines new location
			     Block block = loc.getBlock();
			     Block block2 = loc1.getBlock();
			           
			           
			           for (BlockFace blockface : BlockFace.values()) {
			               if (block.getRelative(blockface).getType().equals(Material.CHEST) || block2.getRelative(blockface).getType().equals(Material.CHEST)) {
			                       e.setCancelled(true);
			                       return;
			               }
			           }
		     loc.getBlock().setType(Material.CHEST);
		     block.getRelative(BlockFace.NORTH).setType(Material.CHEST);
		     Chest chest = (Chest)block.getState();
		     Inventory inv = chest.getInventory();
		     inv.addItem(log1, log2,bookshelf, furnace, wb);
		     e.setCancelled(true);
		 		            if(p.getItemInHand().getAmount() > 1) {
		 		            	int amt = p.getItemInHand().getAmount() -1;
		 			 			ItemStack common = new ItemStack(Material.CHEST, amt);
		 			 			  ItemMeta mm = common.getItemMeta();
		 				         mm.setDisplayName("§aTier 2 : Building Package");
		 				          mm.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
		 				         common.setItemMeta(mm);
		 		            	p.setItemInHand(common);
		 		            	return;
		 		            }
		 		            p.setItemInHand(new ItemStack(Material.AIR));
		 		            return;
		 }
		     return;
		 }
		 
		 @SuppressWarnings("deprecation")
			@EventHandler
			 public void ChestSpawn2(PlayerInteractEvent e){
			     Player p = e.getPlayer();
			     
			     if(e.getAction() != Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aTier 3 : Building Package")) {
			    	 
				     if(Main.isPlayerLocatedInHisPlot(p, e.getClickedBlock()) != true) { 
				    	 e.setCancelled(true);
				    	 p.sendMessage(Main.getPrefix()  + "Must place inside your plot!");
				    	 p.updateInventory();
				    	 return;
				    	 }
			    	 
			            ItemStack stone = new ItemStack(Material.STONE, 512, (short) 6);
			            ItemStack wool = new ItemStack(Material.WOOL, 512);
			            ItemStack log3 = new ItemStack(Material.LOG, 320);
			            ItemStack quartz = new ItemStack(Material.QUARTZ_BLOCK, 640);
			            ItemStack bookshelf = new ItemStack(Material.BOOKSHELF, 16);
			            ItemStack furnace = new ItemStack(Material.FURNACE, 4);
			            ItemStack wb = new ItemStack(Material.GLASS, 320);
			            ItemStack netherbrick = new ItemStack(Material.NETHER_BRICK, 384);
			            ItemStack dye1 = new ItemStack(Material.LAPIS_ORE, 64);
			            ItemStack dye2 = new ItemStack(351, 64, (short) 1);
			            ItemStack dye3 = new ItemStack(351, 64, (short) 2);
			            ItemStack dye4 = new ItemStack(351, 64, (short) 3);
			            ItemStack dye5 = new ItemStack(351, 64, (short) 7);
			            ItemStack dye6 = new ItemStack(351, 64, (short) 6);
			            ItemStack dye7 = new ItemStack(351, 64, (short) 15);
			            ItemStack dye8 = new ItemStack(351, 64, (short) 12);
			            ItemStack dye9 = new ItemStack(351, 64, (short) 14);
			            ItemStack dye10 = new ItemStack(351, 64, (short) 8);
			            

			            
				           Location location = e.getClickedBlock().getLocation();
				           int x = location.getBlockX();
				            int y = location.getBlockY()+1;
				            int z = location.getBlockZ();
				            int z1 = location.getBlockZ()-1;
				            World w = location.getWorld();
				            Location loc = new Location(w, x, y, z); //defines new location
				            Location loc1 = new Location(w, x, y, z1); //defines new location
				     Block block = loc.getBlock();
				     Block block2 = loc1.getBlock();
				           
				           
				           for (BlockFace blockface : BlockFace.values()) {
				               if (block.getRelative(blockface).getType().equals(Material.CHEST) || block2.getRelative(blockface).getType().equals(Material.CHEST)) {
				                       e.setCancelled(true);
				                       return;
				               }
				           }
			     loc.getBlock().setType(Material.CHEST);
			     block.getRelative(BlockFace.NORTH).setType(Material.CHEST);
			     Chest chest = (Chest)block.getState();
			     Inventory inv = chest.getInventory();
			     inv.addItem(stone, wool, log3, quartz, netherbrick, dye1, dye2, dye3, dye4, dye5, dye6, dye7, dye8, dye9, dye10,bookshelf, furnace, wb);
			     p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			     e.setCancelled(true);
			 		            if(p.getItemInHand().getAmount() > 1) {
			 		            	int amt = p.getItemInHand().getAmount() -1;
			 			 			ItemStack common = new ItemStack(Material.CHEST, amt);
			 			 			  ItemMeta mm = common.getItemMeta();
			 				         mm.setDisplayName("§aTier 3 : Building Package");
			 				        mm.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
			 				         common.setItemMeta(mm);
			 		            	p.setItemInHand(common);
			 		            	return;
			 		            }
			 		            p.setItemInHand(new ItemStack(Material.AIR));
			 		            return;
			 }
			     return;
			 }
		 
		 @SuppressWarnings("deprecation")
		@EventHandler
		 public void ChestSpawn3(PlayerInteractEvent e){
		     Player p = e.getPlayer();
		     
		     if(e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aTier 3 : Building Package")) {
		    	 
			     if(Main.isPlayerLocatedInHisPlot(p, e.getClickedBlock()) != true) { 
			    	 e.setCancelled(true);
			    	 p.sendMessage(Main.getPrefix()  + "Must place inside your plot!");
			    	 p.updateInventory();
			    	 return;
			    	 }
		    	 
		            ItemStack stone = new ItemStack(Material.STONE, 512, (short) 6);
		            ItemStack wool = new ItemStack(Material.WOOL, 512);
		            ItemStack log3 = new ItemStack(Material.LOG, 320);
		            ItemStack quartz = new ItemStack(Material.QUARTZ_BLOCK, 640);
		            ItemStack bookshelf = new ItemStack(Material.BOOKSHELF, 16);
		            ItemStack furnace = new ItemStack(Material.FURNACE, 4);
		            ItemStack wb = new ItemStack(Material.GLASS, 320);
		            ItemStack netherbrick = new ItemStack(Material.NETHER_BRICK, 384);
		            ItemStack dye1 = new ItemStack(Material.LAPIS_ORE, 64);
		            ItemStack dye2 = new ItemStack(351, 64, (short) 1);
		            ItemStack dye3 = new ItemStack(351, 64, (short) 2);
		            ItemStack dye4 = new ItemStack(351, 64, (short) 3);
		            ItemStack dye5 = new ItemStack(351, 64, (short) 7);
		            ItemStack dye6 = new ItemStack(351, 64, (short) 6);
		            ItemStack dye7 = new ItemStack(351, 64, (short) 15);
		            ItemStack dye8 = new ItemStack(351, 64, (short) 12);
		            ItemStack dye9 = new ItemStack(351, 64, (short) 14);
		            ItemStack dye10 = new ItemStack(351, 64, (short) 8);
		            

		            
			           Location location = e.getClickedBlock().getLocation();
			           int x = location.getBlockX();
			            int y = location.getBlockY()+1;
			            int z = location.getBlockZ();
			            int z1 = location.getBlockZ()-1;
			            World w = location.getWorld();
			            Location loc = new Location(w, x, y, z); //defines new location
			            Location loc1 = new Location(w, x, y, z1); //defines new location
			     Block block = loc.getBlock();
			     Block block2 = loc1.getBlock();
			           
			           
			           for (BlockFace blockface : BlockFace.values()) {
			               if (block.getRelative(blockface).getType().equals(Material.CHEST) || block2.getRelative(blockface).getType().equals(Material.CHEST)) {
			                       e.setCancelled(true);
			                       return;
			               }
			           }
		     loc.getBlock().setType(Material.CHEST);
		     block.getRelative(BlockFace.NORTH).setType(Material.CHEST);
		     Chest chest = (Chest)block.getState();
		     Inventory inv = chest.getInventory();
		     inv.addItem(stone, wool, log3, quartz, netherbrick, dye1, dye2, dye3, dye4, dye5, dye6, dye7, dye8, dye9, dye10,bookshelf, furnace, wb);
		     e.setCancelled(true);
		 		            if(p.getItemInHand().getAmount() > 1) {
		 		            	int amt = p.getItemInHand().getAmount() -1;
		 			 			ItemStack common = new ItemStack(Material.CHEST, amt);
		 			 			  ItemMeta mm = common.getItemMeta();
		 				         mm.setDisplayName("§aTier 3 : Building Package");
		 				          mm.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
		 				         common.setItemMeta(mm);
		 		            	p.setItemInHand(common);
		 		            	return;
		 		            }
		 		            p.setItemInHand(new ItemStack(Material.AIR));
		 		            return;
		 }
		     return;
		 }

}



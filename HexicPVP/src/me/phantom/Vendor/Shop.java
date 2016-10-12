package me.phantom.Vendor;

import java.util.Arrays;
import java.util.List;

import me.phantom.Main;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Tokens.tokenStorage;
import me.phantom.Util.debugStorage;
import me.phantom.Util.pPlotMe;
import me.phantom.Vendor.PurchaseAmount.AlreadyPurchased;
import me.phantom.Vendor.PurchaseAmount.PurchaseAmount;
import me.phantom.Vendor.PvPTokens.PointsStorage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop implements Listener {

	
	  private Main plugin;

	  public Shop(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  @EventHandler
	  public void PlayerRightClick(PlayerInteractEntityEvent event) {
	    if ((event.getRightClicked() instanceof Player)) {
	      Player target = (Player) event.getRightClicked();
	      Player p = event.getPlayer();
	      if (target.getDisplayName().equalsIgnoreCase("§c§lVendor")) {
	    	  if(AlreadyPurchased.getPlayerBought(p).equalsIgnoreCase("nTokens")) {
	    		  AlreadyPurchased.storePlayerBought(p, "false");
	    	  }
	    	  if(AlreadyPurchased.loadPlayerBought(p).equalsIgnoreCase("true")){
	    		  event.setCancelled(true);
	    		  p.sendMessage("§c§lVendor§8 >§7 Sorry out of stock, come back tomorrow!");
	    		  return;
	    	  }
	    		if(currentItem.getPlayerItem(p) == "nItem") {
	    			 currentItem.storePlayerItem(p, VendorItems.getVendorItem());
	    		}
	        ItemStack Item = VendorItems.getItem(currentItem.loadPlayerItem(p));
	        ItemStack Extra = new ItemStack(160, 1, (short) 7);
	        
	        ItemMeta meta = Extra.getItemMeta();
	        meta.setDisplayName(" ");
	        Extra.setItemMeta(meta);
	        
	        Inventory Vendor = Bukkit.createInventory(null, 9, "Vendor");
	        
	        Vendor.setItem(0, Extra);
	        Vendor.setItem(1, Extra);
	        Vendor.setItem(2, Extra);
	        Vendor.setItem(3, Extra);
	        Vendor.setItem(4, Item);
	        Vendor.setItem(5, Extra);
	        Vendor.setItem(6, Extra);
	        Vendor.setItem(7, Extra);
	        Vendor.setItem(8, Extra);
	        
	        p.openInventory(Vendor);
	    }
	  }
	  }
	  
	  @EventHandler
	  public void onClick(InventoryClickEvent e)
	  {
	    Player p = (Player)e.getWhoClicked();
	    if (e.getInventory().getName() == "Vendor") {
	      e.setCancelled(true);

	      if (e.getSlot() == 4) {


	    	  ItemStack Item = VendorItems.getItem(currentItem.loadPlayerItem(p));
	    	  String s1 = PointsStorage.loadPlayerTokens(p);
	    	  int tokens = Integer.parseInt(s1);
	    	  int tokenz = Integer.parseInt(s1) - getPrice(Item);
	    	  String token = Integer.toString(tokenz);

	    	  
	        if (tokens >= getPrice(Item)) {
	        	String s = currentItem.getPlayerItem(p);
	   		 
	        	
				  //Common
				  if(s.equalsIgnoreCase("SpeedBoots")) {
					  ItemStack SpeedB = new ItemStack(Material.LEATHER_BOOTS, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§a§lKiller Boots of Shear Speed");
				        meta0.setLore(Arrays.asList(new String[] { "§7Speed II" , "§7Health: 100", "§a§oˮArmour forged by the Phantomˮ"}));
				        SpeedB.setItemMeta(meta0);
				        SpeedB.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
				        SpeedB.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
				        p.getInventory().addItem(SpeedB);
				  }
				  if(s.equalsIgnoreCase("T1Build")) {
					  ItemStack SpeedB = new ItemStack(Material.CHEST, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§aTier 1 : Building Package");
				        meta0.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
				        SpeedB.setItemMeta(meta0);
				        p.getInventory().addItem(SpeedB);

				  }
				  if(s.equalsIgnoreCase("PvPToken Global Boost(1)")) {
					  ItemStack SpeedB = new ItemStack(Material.NETHER_STAR, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§c§lPvPPoints Global Boost - T1");
				        meta0.setLore(Arrays.asList(new String[] { "§e2X Points for 30 Minutes", "§7Right Click to Activate"}));
				        SpeedB.setItemMeta(meta0);
				        p.getInventory().addItem(SpeedB);
				        
				  }
				  if(s.equalsIgnoreCase("T2Build")) {
					  ItemStack SpeedB = new ItemStack(Material.CHEST, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§aTier 2 : Building Package");
				        meta0.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
				        SpeedB.setItemMeta(meta0);
				        p.getInventory().addItem(SpeedB);

				  }
				  if(s.equalsIgnoreCase("WarAxe")) {
				  ItemStack SpeedB = new ItemStack(Material.STONE_AXE, 1);
				    ItemMeta meta0 = SpeedB.getItemMeta();
			        meta0.setDisplayName("§e§lIcy War-Axe of Power");
			        meta0.setLore(Arrays.asList(new String[] { "§7Damage: 50", "§e§oˮWeapon forged by the Imperialˮ"}));
			        SpeedB.setItemMeta(meta0);
			        SpeedB.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			        SpeedB.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
			        p.getInventory().addItem(SpeedB);

				  }
				  
				  //Uncommon
				  if(s.equalsIgnoreCase("PvPToken Global Boost(2)")) {
					  ItemStack SpeedB = new ItemStack(Material.NETHER_STAR, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§c§lPvPPoints Global Boost - T2");
				        meta0.setLore(Arrays.asList(new String[] { "§e3X Points for 30 Minutes", "§7Right Click to Activate"}));
				        SpeedB.setItemMeta(meta0);
				        p.getInventory().addItem(SpeedB);

				  }
				  if(s.equalsIgnoreCase("Color Signs")) {
					  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName()
					  		+ " essentials.signs.color ");
					  p.sendMessage("§c§lVendor§8 >§7 You can now use color codes on signs!");

				  }
				  if(s.equalsIgnoreCase("Cactus V Chestplate")) {
						  ItemStack SpeedB = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
						    ItemMeta meta0 = SpeedB.getItemMeta();
					        meta0.setDisplayName("§e§lBreast Plate of Cactus Execution");
					        meta0.setLore(Arrays.asList(new String[] { "§7Cactus V" , "§7Health: 215", "§e§oˮArmour forged by the Phantomˮ"}));
					        SpeedB.setItemMeta(meta0);
					        SpeedB.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
					        SpeedB.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
					        p.getInventory().addItem(SpeedB);

				  }
				  if(s.equalsIgnoreCase("Plot")) {
					  if(pPlotMe.loadPlayerPlots(p).equalsIgnoreCase("false")) {
				        	p.sendMessage("§c§lVendor§8 >§7 You can now claim a plot!");
				        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " plotme.use.claim");
				        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " plotme.limit.1");
				        	tokenStorage.storePlayerTokens(p, token);
				        	pPlotMe.storePlayerPlots(p, "true");
				        	ScoreboardUpdaters.setBoard(p);
				        	return;
					  }
			        	p.sendMessage("§c§lVendor§8 >§7 You already own a plot!");
			        	return;
				  }
				  if(s.equalsIgnoreCase("T3Build")) {
					  ItemStack SpeedB = new ItemStack(Material.CHEST, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§aTier 3 : Building Package");
				        meta0.setLore(Arrays.asList(new String[] { "§7Place on your plot"}));
				        SpeedB.setItemMeta(meta0);
				        p.getInventory().addItem(SpeedB);
				  }
				  
				  //Rare
				  if(s.equalsIgnoreCase("SaturationPlate")) {
					  ItemStack SpeedB = new ItemStack(Material.IRON_CHESTPLATE, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§b§lFuture Thundering Saturation Plate");
				        meta0.setLore(Arrays.asList(new String[] { "§7Saturation V", "§7Health: 345", "§b§oˮArmour forged by the Phantomˮ"}));
				        SpeedB.setItemMeta(meta0);
				        SpeedB.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				        SpeedB.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
				        p.getInventory().addItem(SpeedB);

				  }
				  if(s.equalsIgnoreCase("/fix command")) {
					  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName() + " eseentials.repair");
						  p.sendMessage("§c§lVendor§8 >§7 You can now use the command /fix");

				  }
				  if(s.equalsIgnoreCase("Personal Vault")) {
					  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuaddp " + p.getName()
						  		+ " playervaults.amount.1");
					  p.sendMessage("§c§lVendor§8 >§7 You can now open your vault using /pv 1");

				  }
				  if(s.equalsIgnoreCase("Hologram On Plot")) {
					  ItemStack SpeedB = new ItemStack(Material.PAPER, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§e§lHologram on your plot");
				        meta0.setLore(Arrays.asList(new String[] { "§7Trade with admin to recieve", "§7holo on your plot"}));
				        SpeedB.setItemMeta(meta0);
				        p.getInventory().addItem(SpeedB);

				  }
				  if(s.equalsIgnoreCase("Wither V Sword")) {
					  ItemStack SpeedB = new ItemStack(Material.IRON_SWORD, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§b§lLongsword of the Wither of Health Abosrbing");
				        meta0.setLore(Arrays.asList(new String[] { "§7Wither V", "§7Damage: 70", "§b§oˮWeapon forged by the Netherˮ"}));
				        SpeedB.setItemMeta(meta0);
				        SpeedB.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				        SpeedB.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
				        p.getInventory().addItem(SpeedB);
	
				  }
				  
				  //Legendary
				  if(s.equalsIgnoreCase("Sub+ Rank")) {
					  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + p.getName() + " sub+");
					  rankStorage.storePlayerRank(p, "sub+");
					  p.sendMessage("§c§lVendor§8 >§7 You're now Sub+, enjoy your rank!");

				  }
				  if(s.equalsIgnoreCase("Sub++ Rank")) {
					  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + p.getName() + " sub++");
					  rankStorage.storePlayerRank(p, "sub++");
					  p.sendMessage("§c§lVendor§8 >§7 You're now Sub++, enjoy your rank!");

				  }
				  if(s.equalsIgnoreCase("SecretSword")) {
					  ItemStack SpeedB = new ItemStack(Material.IRON_SWORD, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§6§lSecret Sword of the Hidden Gods'");
				        meta0.setLore(Arrays.asList(new String[] { "§7Damage: 130", "§6§oˮWeapon forged by the Godsˮ"}));
				        SpeedB.setItemMeta(meta0);
				        SpeedB.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				        SpeedB.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				        p.getInventory().addItem(SpeedB);
				  }
				  if(s.equalsIgnoreCase("Jordans")) {
					  ItemStack SpeedB = new ItemStack(Material.DIAMOND_BOOTS, 1);
					    ItemMeta meta0 = SpeedB.getItemMeta();
				        meta0.setDisplayName("§6§lFine Embossed Jordans");
				        meta0.setLore(Arrays.asList(new String[] { "§7Flight I", "§7Health: 512", "§6§oˮArmour forged by the Angelsˮ"}));
				        SpeedB.setItemMeta(meta0);
				        p.getInventory().addItem(SpeedB);
				  }
				  if(s.equalsIgnoreCase("Token Party")) {
					  Bukkit.broadcastMessage("§c§lVendor§8 >§7 Token Party! +5 Tokens to everyone.");
					  for (Player pl : Bukkit.getOnlinePlayers()) {
						  int tokes = Integer.parseInt(tokenStorage.loadPlayerTokens(pl));
						  int toke = tokes+5;
						  String tokenss = Integer.toString(toke);
						  tokenStorage.storePlayerTokens(pl, tokenss);
						  ScoreboardUpdaters.setBoard(pl);
						  if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
			  				  p.sendMessage("§a§l      +5 Token");
			  			  }
					  }
			  }
				  AlreadyPurchased.storePlayerBought(p, "true");
	        	PurchaseAmount.storePurchaseItems(p);
	        	PointsStorage.storePlayerTokens(p, token);
	        	p.closeInventory();
	        	return;
	        }
	        p.closeInventory();
	        p.sendMessage("§c§lVendor§8 >§7 Sorry, you don't have enough to buy this item");
	        return;
	      }
	    }
	  }
	  
	  public static int getPrice(ItemStack i) {
		    if ((i != null) && (i.hasItemMeta()) && (i.getItemMeta().hasLore())) {
		      List<String> lore = i.getItemMeta().getLore();
		      for (String s : lore) {
		        s = ChatColor.stripColor(s);
		        if (s.startsWith("Price:")) {
		          int value = Integer.parseInt(s.substring(s.indexOf(" ") + 1));
		          return value;
		        }
		      }
		    }

		    return 10;
		  }
}

package me.phantom.Vendor;



import java.util.Arrays;
import java.util.Random;

import me.phantom.Main;
import me.phantom.Vendor.PurchaseAmount.Common.PvPTokenOne;
import me.phantom.Vendor.PurchaseAmount.Common.SpeedBoots;
import me.phantom.Vendor.PurchaseAmount.Common.T1Build;
import me.phantom.Vendor.PurchaseAmount.Common.T2Build;
import me.phantom.Vendor.PurchaseAmount.Common.WarAxe;
import me.phantom.Vendor.PurchaseAmount.Legendary.Jordans;
import me.phantom.Vendor.PurchaseAmount.Legendary.SecretSword;
import me.phantom.Vendor.PurchaseAmount.Legendary.SubOne;
import me.phantom.Vendor.PurchaseAmount.Legendary.SubTwo;
import me.phantom.Vendor.PurchaseAmount.Legendary.Token;
import me.phantom.Vendor.PurchaseAmount.Rare.Hologram;
import me.phantom.Vendor.PurchaseAmount.Rare.Saturation;
import me.phantom.Vendor.PurchaseAmount.Rare.Vault;
import me.phantom.Vendor.PurchaseAmount.Rare.Wither;
import me.phantom.Vendor.PurchaseAmount.Rare.fix;
import me.phantom.Vendor.PurchaseAmount.Uncommon.CactusChestplate;
import me.phantom.Vendor.PurchaseAmount.Uncommon.ColorSigns;
import me.phantom.Vendor.PurchaseAmount.Uncommon.Plots;
import me.phantom.Vendor.PurchaseAmount.Uncommon.PvPTokenTwo;
import me.phantom.Vendor.PurchaseAmount.Uncommon.T3Build;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VendorItems implements Listener {
	
	  private Main plugin;

	  public VendorItems(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  
	  public static String getVendorItem() {
		  Random random = new Random();
		  int Chance = random.nextInt(8005) + 1;
		  
		  //Common 62%
		  if(Chance < 1000) {
		  	  return "T1Build";
		  }
		  if(Chance > 1000 && Chance < 2000) {
		  	  return "T2Build";
		  }
		  if(Chance > 2000 && Chance < 3000) {
		  	  return "PvPToken Global Boost(1)";
		  }
		  if(Chance > 3000 && Chance < 4000) {
		  	  return "SpeedBoots";
		  }
		  if(Chance > 4000 && Chance < 5000) {
		  	  return "WarAxe";
		  }
		  
		  
		  //Uncommon   31%
		  if(Chance > 5000 && Chance < 5500) {
		  	  return "PvPToken Global Boost(2)";
		  }
		  if(Chance > 5500 && Chance < 6000) {
		  	  return "Color Signs";
		  }
		  if(Chance > 6000 && Chance < 6500) {
		  	  return "Cactus V Chestplate";
		  }
		  if(Chance > 6500 && Chance < 7000) {
		  	  return "T3Build";
		  }
		  if(Chance > 7000 && Chance < 7500) {
		  	  return "Plot";
		  }
		  
		  //Rare  6%
		  if(Chance > 7500 && Chance < 7600) {
		  	  return "SaturationPlate";
		  }
		  if(Chance > 7600 && Chance < 7700) {
		  	  return "/fix command";
		  }
		  if(Chance > 7700 && Chance < 7800) {
		  	  return "Personal Vault";
		  }
		  if(Chance > 7800 && Chance < 7900) {
		  	  return "Hologram On Plot";
		  }
		  if(Chance > 7900 && Chance < 8000) {
		  	  return "Wither V Sword";
		  }
		  
		  //Legendary 0.06%
		  if(Chance == 8001) {
		  	  return "Sub+ Rank";
		  }
		  if(Chance == 8002) {
		  	  return "Sub++ Rank";
		  }
		  if(Chance == 8003) {
		  	  return "Token Party";
		  }
		  if(Chance == 8004) {
		  	  return "Jordans";
		  }
		  if(Chance == 8005) {
		  	  return "SecretSword";
		  }
		  
		  
		  return "";
		  }
	  
	  public static ItemStack getItem(String s) {
		  //Common
		  if(s.equalsIgnoreCase("SpeedBoots")) {
			  ItemStack SpeedB = new ItemStack(Material.LEATHER_BOOTS, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§a§lSpeed Boots §c(§7Common§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Speed II", "§7Health: 100", "§cPrice:§7 9" , "§bPurchases:§7 " + SpeedBoots.loadPurchaseData()}));
		        
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("T1Build")) {
			  ItemStack SpeedB = new ItemStack(Material.CHEST, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§a§lTier 1 : Building Package §c(§7Common§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§cPrice:§7 6" , "§bPurchases:§7 " + T1Build.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("PvPToken Global Boost(1)")) {
			  ItemStack SpeedB = new ItemStack(Material.NETHER_STAR, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§c§lPvPPoints Global Boost  §c(§7Common§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§e2X Points for 30 Minutes", "§cPrice:§7 8" , "§bPurchases:§7 " + PvPTokenOne.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("T2Build")) {
			  ItemStack SpeedB = new ItemStack(Material.CHEST, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§a§lTier 2 : Building Package §c(§7Common§c)");
		        meta0.setLore(Arrays.asList(new String[] {  "§cPrice:§7 8" , "§bPurchases:§7 " + T2Build.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("WarAxe")) {
			  ItemStack SpeedB = new ItemStack(Material.STONE_AXE, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§e§lIcy War-Axe of Power §c(§7Common§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Damage: 50", "§cPrice:§7 9" , "§bPurchases:§7 " + WarAxe.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  
		  //Uncommon
		  if(s.equalsIgnoreCase("PvPToken Global Boost(2)")) {
			  ItemStack SpeedB = new ItemStack(Material.NETHER_STAR, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
			    meta0.setDisplayName("§c§lPvPPoints Global Boost §c(§eUncommon§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§e3X Points for 30 Minutes", "§cPrice:§7 32" , "§bPurchases:§7 " + PvPTokenTwo.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Color Signs")) {
			  ItemStack SpeedB = new ItemStack(Material.SIGN, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§4§lColored Signs §c(§eUncommon§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Ability to use colorcodes", "§7on signs", "§ePrice:§7 41" , "§bPurchases:§7 " + ColorSigns.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Cactus V Chestplate")) {
			  ItemStack SpeedB = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§e§lPlate of Cactus Execution §c(§eUncommon§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Cactus V", "§7Health: 215", "§ePrice:§7 36" , "§bPurchases:§7 " + CactusChestplate.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("T3Build")) {
			  ItemStack SpeedB = new ItemStack(Material.CHEST, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§a§lTier 3 : Building Package §c(§eUncommon§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§cPrice:§7 29" , "§bPurchases:§7 " + T3Build.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Plot")) {
			  ItemStack SpeedB = new ItemStack(Material.BOOK, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§6§l30x30 Player Plot §c(§eUncommon§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Your own personal plot" ,"§cPrice:§7 35" , "§bPurchases:§7 " + Plots.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  
		  //Rare
		  if(s.equalsIgnoreCase("SaturationPlate")) {
			  ItemStack SpeedB = new ItemStack(Material.PAPER, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§b§lFuture Thundering Saturation Plate §c(§bRare§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Saturation V", "§7Health: 345" ,"§cPrice:§7 68" , "§bPurchases:§7 " + Saturation.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("/fix command")) {
			  ItemStack SpeedB = new ItemStack(Material.PAPER, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§e§l/fix command §c(§bRare§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Ability to use the", "§7/fix command" ,"§cPrice:§7 93" , "§bPurchases:§7 " + fix.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Personal Vault")) {
			  ItemStack SpeedB = new ItemStack(Material.CHEST, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§e§lPersonal Player Vault §c(§bRare§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Ability to use the", "§7/pv command" ,"§cPrice:§7 54" , "§bPurchases:§7 " + Vault.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Hologram On Plot")) {
			  ItemStack SpeedB = new ItemStack(Material.PAPER, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§e§lHologram on your plot §c(§bRare§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Trade with admin to recieve", "§7holo on your plot" ,"§cPrice:§7 62" , "§bPurchases:§7 " + Hologram.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Wither V Sword")) {
			  ItemStack SpeedB = new ItemStack(Material.IRON_SWORD, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§b§lWither Sword §c(§bRare§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Wither V" ,"§7Damage: 70", "§cPrice:§7 98" , "§bPurchases:§7 " + Wither.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  
		  //Legendary
		  if(s.equalsIgnoreCase("SecretSword")) {
			  ItemStack SpeedB = new ItemStack(Material.WOOD_SWORD, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§6§lSecret Sword §c(§6Legendary§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Damage: 130" ,"§cPrice:§7 350" , "§bPurchases:§7 " + SecretSword.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Sub+ Rank")) {
			  ItemStack SpeedB = new ItemStack(Material.BOOK, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§a§lSUB+ Rank §c(§6Legendary§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Recieve SUB+ Rank" ,"§cPrice:§7 264" , "§bPurchases:§7 " + SubOne.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Sub++ Rank")) {
			  ItemStack SpeedB = new ItemStack(Material.BOOK, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§a§lSUB++ Rank §c(§6Legendary§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Recieve SUB++ Rank" ,"§cPrice:§7 370" , "§bPurchases:§7 " + SubTwo.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Jordans")) {
			  ItemStack SpeedB = new ItemStack(Material.DIAMOND_BOOTS, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§6§lFine Embossed Jordans §c(§6Legendary§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Flight I" , "§7Health: 512", "§cPrice:§7 500" , "§bPurchases:§7 " + Jordans.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		  if(s.equalsIgnoreCase("Token Party")) {
			  ItemStack SpeedB = new ItemStack(Material.PAPER, 1);
			    ItemMeta meta0 = SpeedB.getItemMeta();
		        meta0.setDisplayName("§6§lToken Party §c(§6Legendary§c)");
		        meta0.setLore(Arrays.asList(new String[] { "§7Give every player on 5 tokens" ,"§cPrice:§7 298" , "§bPurchases:§7 " + Token.loadPurchaseData()}));
		        SpeedB.setItemMeta(meta0);
		        return SpeedB;
		  }
		return null;
		  
	  }
	  
	  public static String getItemTier(String s) {
		  
		  if(s.equalsIgnoreCase("SpeedBoots") || s.equalsIgnoreCase("T2Build") || s.equalsIgnoreCase("PvPToken Global Boost(1)") ||
				  s.equalsIgnoreCase("WarAxe") || s.equalsIgnoreCase("T1Build")) {
			  return "Common";
		  }
		  if(s.equalsIgnoreCase("PvPToken Global Boost(2)") || s.equalsIgnoreCase("Color Signs") || s.equalsIgnoreCase("Cactus V Chestplate") ||
				  s.equalsIgnoreCase("Plot") || s.equalsIgnoreCase("T3Build")) {
			  return "Uncommon";
		  }
		  if(s.equalsIgnoreCase("SaturationPlate") || s.equalsIgnoreCase("/fix command") || s.equalsIgnoreCase("Personal Vault") ||
				  s.equalsIgnoreCase("Hologram On Plot") || s.equalsIgnoreCase("Wither V Sword")) {
			  return "Rare";
		  }
		  if(s.equalsIgnoreCase("Sub+ Rank") || s.equalsIgnoreCase("Sub++ Rank") || s.equalsIgnoreCase("Token Party") ||
				  s.equalsIgnoreCase("Jordans") || s.equalsIgnoreCase("SecretSword")) {
			  return "Legendary";
		  }
		return s;
		  
	  }
	  
	  


}

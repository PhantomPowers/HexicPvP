package me.phantom.Kits;

import java.util.Arrays;

import me.phantom.Main;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.Tutorial.Tutorial;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class playerRespawnEvent implements Listener{
	
	  private Main plugin;

	  public playerRespawnEvent(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  @EventHandler
	    public void onPlayerRespawn(PlayerRespawnEvent e) {
	        Player p = (Player) e.getPlayer();
	
	        ItemStack Helmet = new ItemStack(Material.IRON_HELMET, 1);
		    ItemStack Chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		    ItemStack Leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		    ItemStack Boots = new ItemStack(Material.IRON_BOOTS, 1); 
		    ItemStack Sword = new ItemStack(Material.IRON_SWORD, 1);
		    ItemStack Bow = new ItemStack(Material.BOW,1);
		    ItemStack Gapple = new ItemStack(Material.GOLDEN_APPLE, 12);
		    ItemStack Steak = new ItemStack(Material.COOKED_BEEF, 64);
		    ItemStack Arrow = new ItemStack(Material.ARROW,64);
		    
	        ItemStack vHelmet = new ItemStack(Material.IRON_HELMET, 1);
		    ItemStack vChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		    ItemStack vLeggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		    ItemStack vBoots = new ItemStack(Material.IRON_BOOTS, 1);
		    ItemStack vSword = new ItemStack(Material.IRON_SWORD, 1);
		    ItemStack vBow = new ItemStack(Material.BOW,1);
		    
	        ItemStack v1Helmet = new ItemStack(Material.IRON_HELMET, 1);
		    ItemStack v1Chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		    ItemStack v1Leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		    ItemStack v1Boots = new ItemStack(Material.IRON_BOOTS, 1);
		    ItemStack v1Sword = new ItemStack(Material.IRON_SWORD, 1);
		    ItemStack v1Bow = new ItemStack(Material.BOW,1);
		    
	        ItemStack sHelmet = new ItemStack(Material.IRON_HELMET, 1);
		    ItemStack sChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		    ItemStack sLeggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		    ItemStack sBoots = new ItemStack(Material.IRON_BOOTS, 1);
		    ItemStack sSword = new ItemStack(Material.DIAMOND_SWORD, 1);
		    ItemStack sGapple = new ItemStack(Material.GOLDEN_APPLE, 32);
		    ItemStack sBow = new ItemStack(Material.BOW,1);
		    
	        ItemStack s1Helmet = new ItemStack(Material.IRON_HELMET, 1);
		    ItemStack s1Chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		    ItemStack s1Leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		    ItemStack s1Boots = new ItemStack(Material.IRON_BOOTS, 1);
		    ItemStack s1Sword = new ItemStack(Material.DIAMOND_SWORD, 1);
		    ItemStack s1Gapple = new ItemStack(Material.GOLDEN_APPLE, 64);
		    ItemStack s1Bow = new ItemStack(Material.BOW,1);
		    // DEFAULT
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
	        
	        //VIP
	        ItemMeta meta8 = vHelmet.getItemMeta();
	        meta8.setDisplayName("§rHexic Helmet");
	        vHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        meta8.setLore(Arrays.asList(new String[] { "§7VIP Helmet"}));
	        vHelmet.setItemMeta(meta8);
	        
		    ItemMeta meta5 = vChestplate.getItemMeta();
		    meta5.setDisplayName("§rHexic Chestplate");
		    meta5.setLore(Arrays.asList(new String[] { "§7VIP Chestplate"}));
	        vChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        vChestplate.setItemMeta(meta5);
	        
		    ItemMeta meta6 = vLeggings.getItemMeta();
		    meta6.setDisplayName("§rHexic Leggings");
		    meta6.setLore(Arrays.asList(new String[] { "§7VIP Leggings"}));
	        vLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        vLeggings.setItemMeta(meta6);
	        
		    ItemMeta meta7 = vBoots.getItemMeta();
		    meta7.setDisplayName("§rHexic Boots");
		    meta7.setLore(Arrays.asList(new String[] { "§7VIP Boots"}));
	        vBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        vBoots.setItemMeta(meta7);
	        
	        ItemMeta meta81 = vSword.getItemMeta();
	        meta81.setDisplayName("§aVIP Sword");
	        vSword.addEnchantment(Enchantment.DURABILITY, 3);
	        vSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	        vSword.setItemMeta(meta81);
	        
	        ItemMeta meta811 = vBow.getItemMeta();
	        meta811.setDisplayName("§aVIP Bow");
	        vBow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
	        vBow.setItemMeta(meta811);
	        
	        
	        //VIP+ Kit
	        
	        ItemMeta meta18 = v1Helmet.getItemMeta();
	        meta18.setDisplayName("§rHexic Helmet");
	        v1Helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        v1Helmet.addEnchantment(Enchantment.DURABILITY, 3);
	        meta18.setLore(Arrays.asList(new String[] { "§7VIP+ Helmet"}));
	        v1Helmet.setItemMeta(meta18);
	        
		    ItemMeta meta325 = v1Chestplate.getItemMeta();
		    meta325.setDisplayName("§rHexic Chestplate");
		    meta325.setLore(Arrays.asList(new String[] { "§7VIP+ Chestplate"}));
	        v1Chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        v1Chestplate.addEnchantment(Enchantment.DURABILITY, 3);
	        v1Chestplate.setItemMeta(meta325);
	        
		    ItemMeta met426 = v1Leggings.getItemMeta();
		    met426.setDisplayName("§rHexic Leggings");
		    met426.setLore(Arrays.asList(new String[] { "§7VIP+ Leggings"}));
	        v1Leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        v1Boots.addEnchantment(Enchantment.DURABILITY, 3);
	        v1Leggings.setItemMeta(met426);
	        
		    ItemMeta met3a7 = v1Boots.getItemMeta();
		    met3a7.setDisplayName("§rHexic Boots");
		    met3a7.setLore(Arrays.asList(new String[] { "§7VIP+ Boots"}));
	        v1Boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        v1Boots.addEnchantment(Enchantment.DURABILITY, 3);
	        v1Boots.setItemMeta(met3a7);
	        
	        ItemMeta met3a81 = v1Sword.getItemMeta();
	        met3a81.setDisplayName("§aVIP+ Sword");
	        v1Sword.addEnchantment(Enchantment.DURABILITY, 3);
	        v1Sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	        v1Sword.setItemMeta(met3a81);
	        
	        ItemMeta met3a811 = v1Bow.getItemMeta();
	        meta8.setDisplayName("§aVIP+ Bow");
	        v1Bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
	        v1Bow.addEnchantment(Enchantment.DURABILITY, 3);
	        v1Bow.setItemMeta(met3a811);
	        
	        //SUB+ Kit
	        
	        ItemMeta meta128 = sHelmet.getItemMeta();
	        meta128.setDisplayName("§rHexic Helmet");
	        sHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	        sHelmet.addEnchantment(Enchantment.DURABILITY, 3);
	        meta128.setLore(Arrays.asList(new String[] { "§bSUB+ Helmet"}));
	        sHelmet.setItemMeta(meta128);
	        
		    ItemMeta metae325 = sChestplate.getItemMeta();
		    metae325.setDisplayName("§rHexic Chestplate");
		    metae325.setLore(Arrays.asList(new String[] { "§bSUB+ Chestplate"}));
	        sChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	        sChestplate.addEnchantment(Enchantment.DURABILITY, 3);
	        sChestplate.setItemMeta(metae325);
	        
		    ItemMeta met42d6 = sLeggings.getItemMeta();
		    met42d6.setDisplayName("§rHexic Leggings");
		    met42d6.setLore(Arrays.asList(new String[] { "§bSUB+ Leggings"}));
	        sLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	        sLeggings.addEnchantment(Enchantment.DURABILITY, 3);
	        sLeggings.setItemMeta(met42d6);
	        
		    ItemMeta met3ad7 = sBoots.getItemMeta();
		    met3ad7.setDisplayName("§rHexic Boots");
		    met3ad7.setLore(Arrays.asList(new String[] { "§bSUB+ Boots"}));
	        sBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	        sBoots.addEnchantment(Enchantment.DURABILITY, 3);
	        sBoots.setItemMeta(met3ad7);
	        
	        ItemMeta met3a8d1 = sSword.getItemMeta();
	        met3a8d1.setDisplayName("§bSUB+ Sword");
	        sSword.addEnchantment(Enchantment.DURABILITY, 3);
	        sSword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
	        sSword.setItemMeta(met3a8d1);
	        
	        ItemMeta met3aa811 = sBow.getItemMeta();
	        met3aa811.setDisplayName("§bSUB+ Bow");
	        sBow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
	        sBow.addEnchantment(Enchantment.DURABILITY, 3);
	        sBow.setItemMeta(met3aa811);
	        
	        //SUB++ Kit
	        
	        ItemMeta meta1d28 = s1Helmet.getItemMeta();
	        meta1d28.setDisplayName("§b§lHexic Helmet");
	        s1Helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	        s1Helmet.addEnchantment(Enchantment.DURABILITY, 3);
	        meta1d28.setLore(Arrays.asList(new String[] { "§bSUB++ Helmet"}));
	        s1Helmet.setItemMeta(meta1d28);
	        
		    ItemMeta metaes325 = s1Chestplate.getItemMeta();
		    metaes325.setDisplayName("§b§lHexic Chestplate");
		    metaes325.setLore(Arrays.asList(new String[] { "§bSUB++ Chestplate"}));
	        s1Chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	        s1Chestplate.addEnchantment(Enchantment.DURABILITY, 3);
	        s1Chestplate.setItemMeta(metaes325);
	        
		    ItemMeta met42sd6 = s1Leggings.getItemMeta();
		    met42sd6.setDisplayName("§b§lHexic Leggings");
		    met42sd6.setLore(Arrays.asList(new String[] { "§bSUB++ Leggings"}));
	        s1Leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	        s1Leggings.addEnchantment(Enchantment.DURABILITY, 3);
	        s1Leggings.setItemMeta(met42sd6);
	        
		    ItemMeta met3sad7 = s1Boots.getItemMeta();
		    met3sad7.setDisplayName("§b§lHexic Boots");
		    met3sad7.setLore(Arrays.asList(new String[] { "§bSUB++ Boots"}));
	        s1Boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	        s1Boots.addEnchantment(Enchantment.DURABILITY, 3);
	        s1Boots.setItemMeta(met3sad7);
	        
	        ItemMeta mes3a8d1 = s1Sword.getItemMeta();
	        mes3a8d1.setDisplayName("§bSUB++ Sword");
	        s1Sword.addEnchantment(Enchantment.DURABILITY, 3);
	        s1Sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
	        s1Sword.setItemMeta(mes3a8d1);
	        
	        ItemMeta met3saa811 = s1Bow.getItemMeta();
	        met3saa811.setDisplayName("§bSUB++ Bow");
	        s1Bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
	        s1Bow.addEnchantment(Enchantment.DURABILITY, 2);
	        s1Bow.setItemMeta(met3saa811);
	        
	        if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("vip")) {
	        	
	        	vHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	vChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	vLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	vBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	
	            vSword.addEnchantment(Enchantment.DURABILITY, 3);
	 	        vSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	 	        

	 	        vBow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
	        	
	        	p.getInventory().setHelmet(vHelmet);
	        	p.getInventory().setChestplate(vChestplate);
	        	p.getInventory().setLeggings(vLeggings);
	        	p.getInventory().setBoots(vBoots);
	        	p.getInventory().addItem(vSword);
	        	p.getInventory().addItem(vBow);
	        	p.getInventory().addItem(Arrow);
	        	p.getInventory().addItem(Steak);
	        	p.getInventory().addItem(Gapple);
	        	
	        }
	        
	        if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("vip+")) {
	        	
		        v1Helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		        v1Helmet.addEnchantment(Enchantment.DURABILITY, 3);
		        v1Chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		        v1Chestplate.addEnchantment(Enchantment.DURABILITY, 3);
		        v1Leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		        v1Leggings.addEnchantment(Enchantment.DURABILITY, 3);
		        v1Boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		        v1Boots.addEnchantment(Enchantment.DURABILITY, 3);
		        
		        v1Sword.addEnchantment(Enchantment.DURABILITY, 3);
		        v1Sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);

		        v1Bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		        v1Bow.addEnchantment(Enchantment.DURABILITY, 3);
	        	
	        	p.getInventory().setHelmet(v1Helmet);
	        	p.getInventory().setChestplate(v1Chestplate);
	        	p.getInventory().setLeggings(v1Leggings);
	        	p.getInventory().setBoots(v1Boots);
	        	p.getInventory().addItem(v1Sword);
	        	p.getInventory().addItem(v1Bow);
	        	p.getInventory().addItem(Arrow);
	        	p.getInventory().addItem(Steak);
	        	p.getInventory().addItem(Gapple);
	        	
	        }
	        
	        if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("sub+")) {
	        	
		        sHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		        sHelmet.addEnchantment(Enchantment.DURABILITY, 3);
		        sChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		        sChestplate.addEnchantment(Enchantment.DURABILITY, 3);
		        sLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		        sLeggings.addEnchantment(Enchantment.DURABILITY, 3);
		        sBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		        sBoots.addEnchantment(Enchantment.DURABILITY, 3);
		        
		        sSword.addEnchantment(Enchantment.DURABILITY, 3);
		        sSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);

		        sBow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		        sBow.addEnchantment(Enchantment.DURABILITY, 3);
	        	
	        	p.getInventory().setHelmet(sHelmet);
	        	p.getInventory().setChestplate(sChestplate);
	        	p.getInventory().setLeggings(sLeggings);
	        	p.getInventory().setBoots(sBoots);
	        	p.getInventory().addItem(sSword);
	        	p.getInventory().addItem(sBow);
	        	p.getInventory().addItem(Arrow);
	        	p.getInventory().addItem(Steak);
	        	p.getInventory().addItem(Gapple);
	        	
	        }
	        if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("sub++") || rankStorage.loadPlayerRank(p).equalsIgnoreCase("owner")|| rankStorage.loadPlayerRank(p).equalsIgnoreCase("developer")
	        		|| rankStorage.loadPlayerRank(p).equalsIgnoreCase("admin") || rankStorage.loadPlayerRank(p).equalsIgnoreCase("coowner") || rankStorage.loadPlayerRank(p).equalsIgnoreCase("moderator")) {
	        	
	        	
		        s1Helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		        s1Helmet.addEnchantment(Enchantment.DURABILITY, 3);
		        s1Chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		        s1Chestplate.addEnchantment(Enchantment.DURABILITY, 3);
		        s1Leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		        s1Leggings.addEnchantment(Enchantment.DURABILITY, 3);
		        s1Boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		        s1Boots.addEnchantment(Enchantment.DURABILITY, 3);
	        	
		        s1Sword.addEnchantment(Enchantment.DURABILITY, 3);
		        s1Sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		        
		        s1Bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
		        s1Bow.addEnchantment(Enchantment.DURABILITY, 2);
	        	
	        	p.getInventory().setHelmet(s1Helmet);
	        	p.getInventory().setChestplate(s1Chestplate);
	        	p.getInventory().setLeggings(s1Leggings);
	        	p.getInventory().setBoots(s1Boots);
	        	p.getInventory().addItem(s1Sword);
	        	p.getInventory().addItem(s1Bow);
	        	p.getInventory().addItem(Arrow);
	        	p.getInventory().addItem(Steak);
	        	p.getInventory().addItem(s1Gapple);
	        	
	        }
	        if(rankStorage.loadPlayerRank(p).toLowerCase().equalsIgnoreCase("default")) {
	    	p.getInventory().setHelmet(Helmet);
	    	p.getInventory().setChestplate(Chestplate);
	    	p.getInventory().setLeggings(Leggings);
	    	p.getInventory().setBoots(Boots);
	    	p.getInventory().addItem(Sword);
	    	p.getInventory().addItem(Bow);
	    	p.getInventory().addItem(Gapple);
	    	p.getInventory().addItem(Steak);
	    	p.getInventory().addItem(Arrow);
	        }
	        
	    }

}

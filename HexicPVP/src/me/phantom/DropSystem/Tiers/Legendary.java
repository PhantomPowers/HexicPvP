package me.phantom.DropSystem.Tiers;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Legendary {
	  public static ItemStack getItem() {
		  Random random = new Random();
      int typeChance = random.nextInt(350) + 1;
      ItemStack item = null;
      String item1 = null;
      String tier = null;
        	  if(typeChance < 50) {
       		   item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
       		   item1 = "chestplate";
       		   tier = "4";
       	  }
        	   if(typeChance < 150 && typeChance > 50) {
       		   item = new ItemStack(Material.DIAMOND_HELMET, 1);
       		   item1 = "helmet";
       		tier = "4";
       	  }
       	  if(typeChance < 200 && typeChance > 150) {
       		   item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
       		   item1 = "leggings";
       		tier = "4";
       	  }
       	  if(typeChance < 300 && typeChance > 200) {
       		  item = new ItemStack(Material.DIAMOND_BOOTS, 1);
       		  item1 = "boots";
       		tier = "4";
       	  }
       	 if(typeChance < 350 && typeChance > 300) {
       		  item = new ItemStack(Material.DIAMOND_SWORD, 1);
       		  item1 = "sword";
       		tier = "4";
       	  }
       	 if(typeChance < 450 && typeChance > 350) {
       		  item = new ItemStack(Material.DIAMOND_AXE, 1);
       		  item1 = "axe";
       		tier = "4";
       	  }
	   
	  if(item1.equalsIgnoreCase("helmet") || item1.equalsIgnoreCase("chestplate") || item1.equalsIgnoreCase("leggings") || item1.equalsIgnoreCase("boots")) {
		  ItemMeta armor = item.getItemMeta();
		  armor.setDisplayName(getTierColor(tier) + getRandomItemName(item1));
		  armor.setLore(Arrays.asList(new String[] {"§7Health: " + getLegendaryHealth(), getTierColor(tier) + "§oˮArmour forged by", getTierColor(tier) + "§o" + getRandomItemLore(), getTierColor(tier) + "Legendary"}));
		  item.setItemMeta(armor);
		  return getLegendaryEnchantment(item, item1);
		  
	  }
	    if(item1.equalsIgnoreCase("axe") || item1.equalsIgnoreCase("sword")) {
    		  ItemMeta armor = item.getItemMeta();
    		  armor.setDisplayName(getTierColor(tier) + getRandomItemName(item1));
    		  armor.setLore(Arrays.asList(new String[] { "§7Damage: " + getLegendaryDamage(),getTierColor(tier) + "§oˮWeapon forged by", getTierColor(tier) + "§o" + getRandomItemLore(), getTierColor(tier) + "Legendary"}));
    		  item.setItemMeta(armor);
    		  return getLegendaryEnchantment(item, item1);
	  }
	  
  
	return item;
}

public static String getTierColor(String s) {
	  if(s.equalsIgnoreCase("1")) {
		  return "§a";
	  }
	   if(s.equalsIgnoreCase("2")) {
		  return "§e";
	  }
	   if(s.equalsIgnoreCase("3")) {
		  return "§b";
	  }
	   if(s.equalsIgnoreCase("4")) {
		  return "§6";
	  }
	return s;
}

public static String getRandomItemLore() {
	  
	  Random random = new Random();
  int Chance = random.nextInt(350);
  String s1 = null;

  if(Chance == 1 || Chance == 0){
	  s1 = "the gods of LegendPvPˮ";
  }
  if(Chance > 1 && Chance < 50) {
	  s1 = "the Imperialˮ";
  }
   if(Chance > 50 && Chance < 60) {
	   s1 = " the prophetsˮ";
  }
   if(Chance > 60 && Chance < 100) {
	   s1 = "The Phantomˮ";
  }
   if(Chance > 100 && Chance < 250) {
	   s1 = "the poorˮ";
  }
   if(Chance > 250 && Chance < 300) {
	   s1 = "the scumˮ";
  }
   if(Chance > 300 && Chance < 350) {
	   s1 = "the extra scrapˮ";
  }
  
	return s1;
}

public static String getRandomItemName(String s) {
	  
	  Random random = new Random();
  int Chance = random.nextInt(100);
  
  if(Chance == 1 || Chance == 0) {
	  if(s.equalsIgnoreCase("axe")) {
	  return "Icy War-axe";
	  }
	   if(s.equalsIgnoreCase("sword")) {
		  return "Vorpal Atal of Good Drakes";
	  }
	   if(s.equalsIgnoreCase("helmet")) {
		  return "Howling Helm of Glorified Magma Ring";
	  }
	   if(s.equalsIgnoreCase("chestplate")) {
		  return "Breast Plate of Serene Executioners";
	  }
	   if(s.equalsIgnoreCase("leggings")) {
		  return "Haunted Greaves of Magma";
	  }
	   if(s.equalsIgnoreCase("boots")) {
		  return "Killers' Boots of Stone Zone";
	  }
  }
    if(Chance > 1 && Chance < 25) {
	  if(s.equalsIgnoreCase("axe")) {
	  return "Cruel Krakens' Axe";
	  }
	   if(s.equalsIgnoreCase("sword")) {
		  return "Defenders' Longsword of the Ogre";
	  }
	   if(s.equalsIgnoreCase("helmet")) {
		  return "Otherworldly Ogre's Helm of Slime Alteration";
	  }
	   if(s.equalsIgnoreCase("chestplate")) {
		  return "Bear's Breast Plate of Exalted Snakes";
	  }
	    if(s.equalsIgnoreCase("leggings")) {
		  return "Accursed Gothic Greaves";
	  }
	   if(s.equalsIgnoreCase("boots")) {
		  return "Sly Screamers' Sabaton";
	  }
  }
   if(Chance >= 25 && Chance < 50) {
	  if(s.equalsIgnoreCase("axe")) {
	  return "Axe of the Cunning Haunter";
	  }
	    if(s.equalsIgnoreCase("sword")) {
		  return "Longsword of the Heavenly Fletcher";
	  }
	   if(s.equalsIgnoreCase("helmet")) {
		  return "Living Helm of Control Goblins";
	  }
	    if(s.equalsIgnoreCase("chestplate")) {
		  return "Breast Plate of Lava Blast";
	  }
	   if(s.equalsIgnoreCase("leggings")) {
		  return "Savage Icy Greaves";
	  }
	   if(s.equalsIgnoreCase("boots")) {
		  return "Monstrous Massive Sabatons";
	  }
  }
   if(Chance > 50 && Chance < 75) {
	  if(s.equalsIgnoreCase("axe")) {
	  return "Infernal Keen Hammer";
	  }
	    if(s.equalsIgnoreCase("sword")) {
		  return "Imperial Sword of the Angels' Spell of Time";
	  }
	   if(s.equalsIgnoreCase("helmet")) {
		  return "Keen Helm of Generosity";
	  }
	   if(s.equalsIgnoreCase("chestplate")) {
		  return "Breast Plate of Intoxication";
	  }
	   if(s.equalsIgnoreCase("leggings")) {
		  return "Greaves of Greater Slime Breaths";
	  }
	   if(s.equalsIgnoreCase("boots")) {
		  return "Sacred Sabatons of Control Platinum";
	  }
  }
   if(Chance >= 75 && Chance < 100) {
	  if(s.equalsIgnoreCase("axe")) {
	  return "War-axe of Heat Transformation";
	  }
	   if(s.equalsIgnoreCase("sword")) {
		  return "Longsword of the Hex of Alter Absorbing";
	  }
	   if(s.equalsIgnoreCase("helmet")) {
		  return "Helm of the Conjuration of Thorns and Agility";
	  }
	   if(s.equalsIgnoreCase("chestplate")) {
		  return "Future Thundering Breast Plate";
	  }
	   if(s.equalsIgnoreCase("leggings")) {
		  return "Greaves of Sanity Lances";
	  }
	   if(s.equalsIgnoreCase("boots")) {
		  return "Fine Embossed Sabatons";
	  }
  }  
	return "Fine Embossed Sabatons";

}

public static ItemStack getLegendaryEnchantment(ItemStack s, String s1) {
	  
	  Random random = new Random();
  int Chance = random.nextInt(250);
  int lvl10 = random.nextInt(10) + 1;
  int lvl5 = random.nextInt(5) + 1;
  int lvl3 = random.nextInt(3) + 1;
  int lvl2 = random.nextInt(2) + 1;
  int lvl1 = random.nextInt(1) + 1;
	  if(Chance >= 1 && Chance < 50) {
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
		  return s;
	  }
	   if(Chance >= 50 && Chance < 100) {
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
		  return s;
	  }
	  if(Chance >= 100 && Chance < 150) {
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl3);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl3);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
		  return s;
	  }
	  if(Chance >= 150 && Chance < 250) {
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl1);
		  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl1);
		  return s;
	  }
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl1);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl1);
	return s;

}


public static int getLegendaryHealth() {
	  Random r = new Random();
      int Chance = r.nextInt(250);
      int max = r.nextInt(512-345) + 345;
      int lvl5 = r.nextInt(467-345) + 345;
      int lvl3 = r.nextInt(415-345) + 345;
      int lvl2 = r.nextInt(356-345) + 345;
      if(Chance >= 1 && Chance < 50) {
      	return max;
      }
      if(Chance >=50 && Chance < 100) {
      	return lvl5;
      }
      if(Chance >= 100 && Chance < 150) {
      	return lvl3;
      }
      if(Chance >= 150 && Chance < 250) {
      	return lvl2;
      }
	  
	return lvl2;
	  
}

public static int getLegendaryDamage() {
	  Random r = new Random();
      int Chance = r.nextInt(250);
      int max = r.nextInt(123-69) + 69;
      int lvl5 = r.nextInt(94-69) + 69;
      int lvl3 = r.nextInt(83-69) + 69;
      int lvl2 = r.nextInt(74-69) + 69;
      if(Chance >= 1 && Chance < 50) {
      	return max;
      }
      if(Chance >=50 && Chance < 100) {
      	return lvl5;
      }
      if(Chance >= 100 && Chance < 150) {
      	return lvl3;
      }
      if(Chance >= 150 && Chance < 250) {
      	return lvl2;
      }
	  
	return lvl2;
	  
}


public static Enchantment getRandomEnchant( String s1) {
	  
	  Random random = new Random();
  int Chance = random.nextInt(155);
  int Chance1 = random.nextInt(135);
  Enchantment ench = null;
  
  if(s1 == "axe" || s1 == "sword") {
	  if(Chance < 10) {
		  ench = Enchantment.DAMAGE_ALL;
	  }
	  if(Chance >= 10 && Chance < 50) {
		  ench = Enchantment.DURABILITY;
	  }
	   if(Chance >= 50 && Chance < 55) {
		   ench = Enchantment.FIRE_ASPECT;
	  }
	   if(Chance >= 55 && Chance < 100) {
		   ench = Enchantment.KNOCKBACK;
	  }
	   if(Chance >= 100 && Chance < 135) {
		   ench = Enchantment.DAMAGE_ARTHROPODS;    	  
	  }
	   if(Chance >= 135 && Chance < 155) {
		   ench = Enchantment.LOOT_BONUS_MOBS;
	  }

  }
  if(s1 == "boots" || s1 == "leggings" || s1 == "chestplate" || s1 == "helmet") {
	  if(Chance1 < 10) {
		  ench = Enchantment.PROTECTION_ENVIRONMENTAL;
	  }
	   if(Chance1 >= 10 && Chance < 50) {
		   ench = Enchantment.DURABILITY;
	 }
	  if(Chance1 >= 50 && Chance < 55) {
		  ench = Enchantment.PROTECTION_FIRE;
	  }
	  if(Chance1 >= 55 && Chance < 100) {
		  ench = Enchantment.PROTECTION_PROJECTILE;
	  }
	  if(Chance1 >= 100 && Chance < 135) {
		  ench = Enchantment.PROTECTION_EXPLOSIONS;
	  }

  }
	return ench;

}



}
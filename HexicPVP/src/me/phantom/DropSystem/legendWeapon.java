package me.phantom.DropSystem;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class legendWeapon {
	  public static ItemStack getWeaponItem() {
		  Random random = new Random();
   int itemChance = random.nextInt(100) + 1;
   int typeChance = random.nextInt(150) + 1;
   ItemStack item = null;
   String item1 = null;
   String tier = null;
   if(itemChance <= 100) {
         	  if(typeChance <= 50) {
        		   item = new ItemStack(Material.DIAMOND_SWORD, 1);
        		   item1 = "sword";
        		tier = "4";
        	  }
         	   if(typeChance <= 150 && typeChance > 50) {
        		   item = new ItemStack(Material.DIAMOND_AXE, 1);
        		   item1 = "axe";
        		tier = "4";
        	  }
 	  
 	  }  
	   
	  if(item1.equalsIgnoreCase("helmet") || item1.equalsIgnoreCase("chestplate") || item1.equalsIgnoreCase("leggings") || item1.equalsIgnoreCase("boots")) {
		  ItemMeta armor = item.getItemMeta();
		  armor.setDisplayName(getTierColor(tier) + getRandomItemName(item1));
		  armor.setLore(Arrays.asList(new String[] { getTierColor(tier) + "§oˮArmour forged by", getTierColor(tier) + "§oToken Shop"}));
		  item.setItemMeta(armor);
		  return getWeaponEnchantment(item, item1);
		  
	  }
	    if(item1.equalsIgnoreCase("axe") || item1.equalsIgnoreCase("sword")) {
 		  ItemMeta armor = item.getItemMeta();
 		  armor.setDisplayName(getTierColor(tier) + getRandomItemName(item1));
 		  armor.setLore(Arrays.asList(new String[] { getTierColor(tier) + "§oˮWeapon forged in", getTierColor(tier) + "§othe token shopˮ", getTierName(tier)}));
 		  item.setItemMeta(armor);
 		  return getWeaponEnchantment(item, item1);
	  }
	  

	    item = new ItemStack(Material.DIAMOND_AXE);
	    item1 = "axe";
	    tier = "4";
	    ItemMeta armor = item.getItemMeta();
		  armor.setDisplayName(getTierColor(tier) + getRandomItemName(item1));
		  armor.setLore(Arrays.asList(new String[] { getTierColor(tier) + "§oˮWeapon forged in", getTierColor(tier) + "§othe token shopˮ", getTierName(tier)}));
		  item.setItemMeta(armor);
		  return getWeaponEnchantment(item, item1);
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

public static String getTierName(String s) {
	  if(s.equalsIgnoreCase("1")) {
		  return "§aCommon";
	  }
	   if(s.equalsIgnoreCase("2")) {
		  return "§eUncommon";
	  }
	   if(s.equalsIgnoreCase("3")) {
		  return "§bRare";
	  }
	   if(s.equalsIgnoreCase("4")) {
		  return "§6Legendary";
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
if(Chance >= 50 && Chance < 60) {
	   s1 = " the prophetsˮ";
}
if(Chance >= 60 && Chance < 100) {
	   s1 = "The Phantomˮ";
}
if(Chance >= 100 && Chance < 250) {
	   s1 = "the poorˮ";
}
if(Chance >= 250 && Chance < 300) {
	   s1 = "the scumˮ";
}
if(Chance >= 300 && Chance <= 350) {
	   s1 = "the extra scrapˮ";
}

	return "the extra scrapˮ";
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
if(Chance >= 50 && Chance < 75) {
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

public static ItemStack getWeaponEnchantment(ItemStack s, String s1) {
	  
	  Random random = new Random();
int Chance = random.nextInt(100);
int lvl10 = random.nextInt(10) + 1;
int lvl5 = random.nextInt(5) + 1;
int lvl3 = random.nextInt(3) + 1;
int lvl2 = random.nextInt(2) + 1;
int lvl1 = random.nextInt(1) + 1;


if(Chance == 1) {
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl10);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
	  return s;
}
if(Chance >= 1 && Chance < 50) {
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
	  return s;
}
 if(Chance >= 50 && Chance <= 100) {
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
	  s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
	  return s;
}


	  
 s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
 s.addUnsafeEnchantment(getRandomEnchant(s1), lvl5);
 s.addUnsafeEnchantment(getRandomEnchant(s1), lvl2);
 return s;

}


public static Enchantment getRandomEnchant( String s1) {
	  
	  Random random = new Random();
int Chance = random.nextInt(250);
Enchantment ench = null;

if(s1 == "axe" || s1 == "sword") {
	  if(Chance == 1) {
		  ench = Enchantment.DAMAGE_ALL;
	  }
	  if(Chance > 1 && Chance < 50) {
		  ench = Enchantment.DURABILITY;
	  }
	   if(Chance >= 50 && Chance < 60) {
		   ench = Enchantment.FIRE_ASPECT;
	  }
	   if(Chance >= 60 && Chance < 100) {
		   ench = Enchantment.KNOCKBACK;
	  }
	   if(Chance >= 100 && Chance < 175) {
		   ench = Enchantment.DAMAGE_ARTHROPODS;    	  
	  }
	   if(Chance >= 175 && Chance <= 250) {
		   ench = Enchantment.LOOT_BONUS_MOBS;
	  }
}
	return ench;

}

}

package me.phantom.Vendor.PurchaseAmount;

import me.phantom.Vendor.currentItem;
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

import org.bukkit.entity.Player;
public class PurchaseAmount {

	
	 public static void storePurchaseItems(Player p) {
		 
		 String s = currentItem.getPlayerItem(p);
		 
	
			  //Common
			  if(s.equalsIgnoreCase("SpeedBoots")) {
				  String s5 = SpeedBoots.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  SpeedBoots.storePurchaseData(purchases);

			  }
			  if(s.equalsIgnoreCase("T1Build")) {
				  String s5 = T1Build.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  T1Build.storePurchaseData(purchases);

			  }
			  if(s.equalsIgnoreCase("PvPToken Global Boost(1)")) {
				  String s5 = PvPTokenOne.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  PvPTokenOne.storePurchaseData(purchases);

			  }
			  if(s.equalsIgnoreCase("T2Build")) {
				  String s5 = T2Build.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  T2Build.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("WarAxe")) {
				  String s5 = WarAxe.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  WarAxe.storePurchaseData(purchases);
			  }
			  
			  //Uncommon
			  if(s.equalsIgnoreCase("PvPToken Global Boost(2)")) {
				  String s5 = PvPTokenTwo.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  PvPTokenTwo.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Color Signs")) {
				  String s5 = ColorSigns.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  ColorSigns.storePurchaseData(purchases);

			  }
			  if(s.equalsIgnoreCase("Cactus V Chestplate")) {
				  String s5 = CactusChestplate.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  CactusChestplate.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("T3Build")) {
				  String s5 = T3Build.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  T3Build.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Plot")) {
				  String s5 = Plots.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  Plots.storePurchaseData(purchases);
			  }
			  
			  //Rare
			  if(s.equalsIgnoreCase("SaturationPlate")) {
				  String s5 = Saturation.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  Saturation.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("/fix command")) {
				  String s5 = fix.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  fix.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Personal Vault")) {
				  String s5 = Vault.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  Vault.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Hologram On Plot")) {
				  String s5 = Hologram.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  Hologram.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Wither V Sword")) {
				  String s5 = Wither.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  Wither.storePurchaseData(purchases);
			  }
			  
			  //Legendary
			  if(s.equalsIgnoreCase("SecretSword")) {
				  String s5 = SecretSword.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  SecretSword.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Sub+ Rank")) {
				  String s5 = SubOne.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  SubOne.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Sub++ Rank")) {
				  String s5 = SubTwo.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  SubTwo.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Jordans")) {
				  String s5 = Jordans.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  Jordans.storePurchaseData(purchases);
			  }
			  if(s.equalsIgnoreCase("Token Party")) {
				  String s5 = Token.loadPurchaseData();
				  int p1 = Integer.parseInt(s5)+1;
				  String purchases = Integer.toString(p1);
				  Token.storePurchaseData(purchases);  
		  }
		 
	 }
}

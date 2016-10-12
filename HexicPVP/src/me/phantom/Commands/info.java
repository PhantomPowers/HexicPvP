package me.phantom.Commands;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

import me.phantom.Main;
import me.phantom.Combat.HealthSystem;
import me.phantom.Events.KillStreak;
import me.phantom.LevelingSystem.experienceStorage;
import me.phantom.LevelingSystem.levelResetStorage;
import me.phantom.LevelingSystem.levelStorage;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.Tokens.tokenStorage;
import me.phantom.Util.bossKillStorage;
import me.phantom.Util.debugStorage;
import me.phantom.Util.killsStorage;
import me.phantom.Util.minionKillStorage;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class info implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("pinfo")) {
			 if (!(sender instanceof Player)) {
				 return false;
			 }
			 Player p = (Player)sender;

			 if(args.length == 0) {
				 p.sendMessage("§c/pinfo <player>");
				 return true;
			 }
			 Player target = Bukkit.getServer().getPlayer(args[0]);
			 if(target == null) {
		    	  p.sendMessage("§7Could not find player§c " + args[0] + "§7!");
		    	  p.getWorld().playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
		    	  return true;
			 }
			  String s1 = experienceStorage.loadPlayerEXP(target);
			  int r = 20 + new Random().nextInt(20);
			  int exps = Integer.parseInt(s1);;
			  String s2 = levelStorage.loadPlayerLevel(target);
			  String rnk = rankStorage.loadPlayerRank(target);
			  String rank = rnk.substring(0, 1).toUpperCase() + rnk.substring(1);
			  int level = Integer.parseInt(s2);
			  int levelup = Integer.parseInt(s2) + 1;
			  ItemStack helmet = target.getInventory().getHelmet();
				ItemStack chestplate = target.getInventory().getChestplate();
				ItemStack leggings = target.getInventory().getLeggings();
				ItemStack boots = target.getInventory().getBoots();
				int armor = 0;
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
			  int Health = HealthSystem.getHealthStat(helmet) + HealthSystem.getHealthStat(chestplate) + HealthSystem.getHealthStat(leggings) + HealthSystem.getHealthStat(boots) + armor * 10;
			  String lvl = Integer.toString(levelup);
			 p.sendMessage("§8======§cInfo: " + target.getName() +"§8======");
			 p.sendMessage("§7- UUID:§c " + target.getUniqueId().toString());
			 //p.sendMessage("§7- Balance:§c " + Main.econ.getBalance(target));
			 p.sendMessage("§7- Tokens:§c " + tokenStorage.loadPlayerTokens(target));
			 p.sendMessage("§7- Level: §c" + level );
			 p.sendMessage("§7- Level Progress:§c " + ChatColor.RED + " [" + exps + ChatColor.BOLD + "/" + ChatColor.RED + playerLevelUp.needed_exp(target) + " EXP]" );
			 p.sendMessage("§7- Rank: §c" + rank);
			 p.sendMessage("§7- Debug: §c" + getDebug(target));
			 p.sendMessage("§7- Kills: §c" + killsStorage.loadPlayerKills(target));
			 p.sendMessage("§7- Paragon Levels: §c" + levelResetStorage.loadPlayerLevelResets(target));
			 p.sendMessage("§7- Boss Kills: §c" + bossKillStorage.loadPlayerBossKills(target));
			 p.sendMessage("§7- Health: §c" + Health + " §c§lHP");
	 }
		return false;
		 
	  }

	  public static String getDebug (Player p) {
		  if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
			  return "§aEnabled";
		  }
		  if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("false")) {
			  return "§cDisabled";
		  }
		return null;
	  }
}

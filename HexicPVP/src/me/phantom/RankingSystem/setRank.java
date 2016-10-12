package me.phantom.RankingSystem;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import me.phantom.Main;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.Scoreboard.ScoreboardUpdaters;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setRank implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("setrank")) {
			 Player target = Bukkit.getServer().getPlayer(args[0]);
			 if (!(sender instanceof Player)) {
				 String new_rank = args[1];
				 String old_rank = rankStorage.loadPlayerRank(target);
				 Bukkit.getLogger().info("Successfully changed " + target.getName() + "'s rank from " + old_rank + " to " + new_rank + "!");
				 rankStorage.storePlayerRank(target, new_rank.toLowerCase());
			        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + target.getName() + " " + new_rank.toLowerCase());
			        target.sendMessage(Main.getPrefix() + "§eYou have been made a " + new_rank);
			        ScoreboardUpdaters.setBoard(target);
			        return true;
			 }
			 
			 Player p = (Player)sender;
			 if(!p.isOp()) { return true;} 
			 if(args.length == 0) {
				 p.sendMessage(Main.getPrefix() +"§c/setrank <player> <rank>");
				 return true;
			 }
			 if(target == null) {
		    	  p.sendMessage(Main.getPrefix() +"§7Could not find player§c " + args[0] + "§7!");
		    	  p.getWorld().playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
		    	  return true;
			 }
			// if(!args[1].equalsIgnoreCase("Default") || !args[1].equalsIgnoreCase("Dev") || !args[1].equalsIgnoreCase("Owner") || !args[1].equalsIgnoreCase("CoOwner") || 
			///		 !args[1].equalsIgnoreCase("Legend") || !args[1].equalsIgnoreCase("Veteran") || !args[1].equalsIgnoreCase("WarLord") || !args[1].equalsIgnoreCase("Champion") ||
			//		 !args[1].equalsIgnoreCase("God")) {
			//	 p.sendMessage(Main.getPrefix() +"§cPlease type valid rank!");
			//	 return true;
			 //}
			 String new_rank = args[1];
			 String old_rank = rankStorage.loadPlayerRank(target);
			 p.sendMessage(Main.getPrefix() + "§7Successfully changed §c" + target.getName() + "'s§7 rank from §c" + old_rank + "§7 to §c" + new_rank + "§7!");
			 rankStorage.storePlayerRank(target, new_rank.toLowerCase());
		        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "manuadd " + p.getName() + new_rank.toLowerCase());
				 ScoreboardUpdaters.setBoard(p);
				 ScoreboardUpdaters.setBoard(target);
	 }
		return false;
		 
	  }
	 
	  

}

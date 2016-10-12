package me.phantom.Commands;

import java.util.Random;

import me.phantom.Main;
import me.phantom.LevelingSystem.experienceStorage;
import me.phantom.LevelingSystem.levelResetStorage;
import me.phantom.LevelingSystem.levelStorage;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Tokens.tokenStorage;
import me.phantom.Util.debugStorage;
import me.phantom.Util.killsStorage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addTokens implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("setTokens")) {
			 
			 if (!(sender instanceof Player)) {
				 return false;
			 }
			 Player p = (Player)sender;
			 if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("developer") || rankStorage.loadPlayerRank(p).equalsIgnoreCase("admin") || rankStorage.loadPlayerRank(p).equalsIgnoreCase("owner")) {
				 if(args.length == 0) {
					 p.sendMessage("§c/settokens <player> <amt>");
					 return true;
				 }
				 Player target = Bukkit.getServer().getPlayer(args[0]);
				 if(target == null) {
			    	  p.sendMessage("§7Could not find player§c " + args[0] + "§7!");
			    	  p.getWorld().playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
			    	  return true;
				 }
				 int amt = Integer.parseInt(args[1]);
				 String tokens = Integer.toString(amt);
				 tokenStorage.storePlayerTokens(target, tokens);
				 p.sendMessage("§a" + target.getName() + "§c tokens has been set to §a" + tokens + "§c!");
				 ScoreboardUpdaters.setBoard(target);
				 if(debugStorage.loadPlayerDebug(target).equalsIgnoreCase("true")) {
					 target.playSound(target.getLocation(), Sound.LEVEL_UP, 1F, 1F);
					 target.sendMessage("§a§l      +" + tokens + " Tokens");
				 }
		 }
		 }
		return false;
	  }

}

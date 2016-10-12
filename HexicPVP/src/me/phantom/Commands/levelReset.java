package me.phantom.Commands;

import me.phantom.Main;
import me.phantom.LevelingSystem.experienceStorage;
import me.phantom.LevelingSystem.levelResetStorage;
import me.phantom.LevelingSystem.levelStorage;
import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Util.debugStorage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class levelReset implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("paragon")) {
			 if (!(sender instanceof Player)) {
				 return false;
			 }
			 Player p = (Player)sender;
			 String s1 = levelResetStorage.loadPlayerLevelResets(p);
			 int lr = Integer.parseInt(s1) + 1;
			 String lresets = Integer.toString(lr);
			 if(!levelStorage.loadPlayerLevel(p).equalsIgnoreCase("60")) {
				 p.sendMessage(Main.getPrefix() + "You must be level 60 to paragon level!");
				 return true;
		 }
			  p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1F, 1F);
			  p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "           PARAGON LEVEL UP! " + ChatColor.RED
	                    + ChatColor.UNDERLINE + (s1) + ChatColor.BOLD + " -> " + ChatColor.RED + ChatColor.UNDERLINE + lresets);
			  Bukkit.broadcastMessage(Main.getPrefix() + ChatColor.RED + "" + ChatColor.BOLD +  p.getName() + "       PARAGON LEVEL UP! " + ChatColor.RED
	                    + ChatColor.UNDERLINE + (s1) + ChatColor.BOLD + " -> " + ChatColor.RED + ChatColor.UNDERLINE + lresets);
			 levelStorage.storePlayerLevel(p, "1");
			 experienceStorage.storePlayerEXP(p, "0");
			 levelResetStorage.storePlayerLevelResets(p, lresets);
			 ScoreboardUpdaters.setBoard(p);
			 
		 }
		return false;
	  }
}

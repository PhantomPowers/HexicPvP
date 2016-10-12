package me.phantom.Tutorial.commands;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import me.phantom.LevelingSystem.experienceStorage;
import me.phantom.LevelingSystem.levelStorage;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Tokens.tokenStorage;
import me.phantom.Tutorial.Tutorial;
import me.phantom.Util.debugStorage;



public class finishTutorial implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("ftutorial")) {
			 Player target = Bukkit.getServer().getPlayer(args[0]);
			 if (!(sender instanceof Player)) {
				 
				 if(args.length == 0) {
					Bukkit.getLogger().info("§c/ftutorial <name>"); 
				 }
				 if(target == null) {
					Bukkit.getLogger().info("§cPlayer currently offline!"); 
				 }
				 
		            int x = -8;
		            int y = 78;
		            int z = -9;
		            World w = Bukkit.getWorld("world");
		            Location loc = new Location(w, x, y, z); //defines new location
			 		target.teleport(loc);
			 		Tutorial.storePlayerTutorial(target, "Complete");
			 		target.removePotionEffect(PotionEffectType.INVISIBILITY);
			 		
			 		int r = (int) (100 + new Random().nextInt(100) * playerLevelUp.getEXPBoost(target));
					  String s = experienceStorage.loadPlayerEXP(target);
			        	int i = (int) (Integer.parseInt(s) + r);;
			        	String exp = Integer.toString(i);
			        	String s4 = tokenStorage.loadPlayerTokens(target);
			  		  int tokes = Integer.parseInt(s4) + 1;
					  String tokens = Integer.toString(tokes);
					  String s2 = levelStorage.loadPlayerLevel(target);
					  int level = Integer.parseInt(s2);
					  int levelup = Integer.parseInt(s2) + 1;
					  String lvl = Integer.toString(levelup);
					  
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("");
					  target.sendMessage("§r[§b60§r]  Finn:§7 Congratulations Soldier, you've finished and passed our training with flying colors! Your adverture starts here Soldier");
					  
			        	experienceStorage.storePlayerEXP(target, exp);
			        	
			        	if(debugStorage.loadPlayerDebug(target).equalsIgnoreCase("true")) {
				        	target.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "          +" + ChatColor.RED +  r + ChatColor.BOLD + " EXP"
					                    + ChatColor.RED + ChatColor.GRAY + " [" + exp + ChatColor.BOLD + "/" + ChatColor.GRAY + playerLevelUp.needed_exp(target) + " EXP]");
				        	target.playSound(target.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				        	target.sendMessage("          §a§l+ Tutorial Complete");
				        	ScoreboardUpdaters.setBoard(target);
				        	
					  }
				        	if(i > playerLevelUp.needed_exp(target)) {
						  levelStorage.storePlayerLevel(target, lvl);
						  target.playSound(target.getLocation(), Sound.LEVEL_UP, 1F, 1F);
						  target.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "           LEVEL UP! " + ChatColor.RED
				                    + ChatColor.UNDERLINE + (level) + ChatColor.BOLD + " -> " + ChatColor.RED + ChatColor.UNDERLINE + levelup);
						  ScoreboardUpdaters.setBoard(target);
					  }
				        	  if(levelup == 3 || levelup == 6 || levelup == 9 || levelup == 12 || levelup == 15 || levelup == 18 || levelup == 21 || levelup == 24 || levelup == 27 || levelup == 30 || 
				        			  levelup == 33 || levelup == 36 || levelup == 39 || levelup == 42 || levelup == 45 || levelup == 48 || levelup == 51 || levelup == 54 || levelup == 57 || levelup == 60) {
						  			  tokenStorage.storePlayerTokens(target, tokens);
						  			  if(debugStorage.loadPlayerDebug(target).equalsIgnoreCase("true")) {
						  				  target.sendMessage("§a§l      +1 Token");
						  			  }
						  			ScoreboardUpdaters.setBoard(target);
						  			
						  			 if(levelup == 60) {
						  				 target.sendMessage(ChatColor.YELLOW + "Congratulations! You have reached " + ChatColor.UNDERLINE + "LVL 60"
							                        + ChatColor.YELLOW + " this means you can no longer gather tokens from leveling");
						  				target.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(1) " + ChatColor.YELLOW + "You can Paragon Level "
							                        + "by typing /paragon and be reset back too LVL 1 and start gathering tokens with higher EXP rates.");
						  				target.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(2) " + ChatColor.YELLOW + "You can continue farming "
							                        + " gear with better drops from mobs since you're level 60 but no longer gather tokens ");
						  			  }

					  		  }
			        	
			        ScoreboardUpdaters.setBoard(target);
			        return true;
			 }

		 
	  }
		return false;
	  }
	 
	  



}

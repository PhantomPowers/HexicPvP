package me.phantom.LevelingSystem;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

import me.phantom.Main;
import me.phantom.DropSystem.tutorialDrop;
import me.phantom.DropSystem.Tiers.Common;
import me.phantom.DropSystem.Tiers.Legendary;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Tokens.tokenStorage;
import me.phantom.Tutorial.Tutorial;
import me.phantom.Util.bossKillStorage;
import me.phantom.Util.deathStorage;
import me.phantom.Util.debugStorage;
import me.phantom.Util.killsStorage;
import me.phantom.Util.minionKillStorage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class playerLevelUp implements Listener {
	
	  private Main plugin;

	  public playerLevelUp(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
//104.128.233.164:25570
	  
	  @EventHandler
	    public void addExperience(PlayerDeathEvent e) {
		  



		  
		  Player pl = e.getEntity().getPlayer();
		  Player p = e.getEntity().getKiller();
		  
		  
		  if(Tutorial.loadPlayerTutorial(pl).equalsIgnoreCase("nTutorial")) { e.getDrops().clear();return; }
		  String s5 = killsStorage.loadPlayerKills(p);
		  int k = Integer.parseInt(s5)+1;
		  String kills = Integer.toString(k);
		  String s1 = experienceStorage.loadPlayerEXP(p);
		  int r = (int) (40 + new Random().nextInt(20) * getEXPBoost(p));
		  String s4 = tokenStorage.loadPlayerTokens(p);
		  int tokes = Integer.parseInt(s4) + 1;
		  String tokens = Integer.toString(tokes);
		  String s2 = levelStorage.loadPlayerLevel(p);
		  int level = Integer.parseInt(s2);
		  int levelup = Integer.parseInt(s2) + 1;
		  String lvl = Integer.toString(levelup);
		  killsStorage.storePlayerKills(p, kills);
		  pl.sendMessage("§eYou have been slaughtered by §a" + p.getName() + "§e who had §a" + Math.round(p.getHealth()) + "§e/§a" + p.getMaxHealth() + "§e hearts remaining!");
		  p.sendMessage("§eYou have killed §a" + pl.getName() + "§e!");
		  ScoreboardUpdaters.setBoard(pl);
			  if((level == 60)) { return; }
			  String s = experienceStorage.loadPlayerEXP(p);
	        	int i = (int) (Integer.parseInt(s) + r);;
	        	String exp = Integer.toString(i);
	        	experienceStorage.storePlayerEXP(p, exp);
	        	if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
	        	p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "          +" + ChatColor.RED +  r + ChatColor.BOLD + " EXP"
		                    + ChatColor.RED + ChatColor.GRAY + " [" + exp + ChatColor.BOLD + "/" + ChatColor.GRAY + needed_exp(p) + " EXP]");
	        	ScoreboardUpdaters.setBoard(p);
	        	
		  }
	        	if(i > needed_exp(p)) {
			  levelStorage.storePlayerLevel(p, lvl);
			  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
			  p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "           LEVEL UP! " + ChatColor.RED
	                    + ChatColor.UNDERLINE + (level) + ChatColor.BOLD + " -> " + ChatColor.RED + ChatColor.UNDERLINE + levelup);
			  ScoreboardUpdaters.setBoard(p);
		  }
	        	  if(levelup == 3 || levelup == 6 || levelup == 9 || levelup == 12 || levelup == 15 || levelup == 18 || levelup == 21 || levelup == 24 || levelup == 27 || levelup == 30 || 
			  				levelup == 33 || levelup == 36 || levelup == 39 || levelup == 42 || levelup == 45 || levelup == 48 || levelup == 51 || levelup == 54 || levelup == 57 || levelup == 60) {
			  			  tokenStorage.storePlayerTokens(p, tokens);
			  			  if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
			  				  p.sendMessage("§a§l      +1 Token");
			  			  }
			  			  ScoreboardUpdaters.setBoard(p);
			  			  if(levelup == 60) {
				  				 p.sendMessage(ChatColor.YELLOW + "Congratulations! You have reached " + ChatColor.UNDERLINE + "LVL 60"
					                        + ChatColor.YELLOW + " this means you can no longer gather tokens from leveling");
					                p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(1) " + ChatColor.YELLOW + "You can Paragon Level "
					                        + "by typing /paragon and be reset back too LVL 1 and start gathering tokens with higher EXP rates.");
					                p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(2) " + ChatColor.YELLOW + "You can continue farming "
					                        + " gear with better drops from mobs since you're level 60 but no longer gather tokens ");
				  			  }
			  			  return;
		  		  }
		  		  
	  }
	  
	  
	  @EventHandler
	    public void addExperience1(EntityDeathEvent e) {
		  if(e.getEntity().getCustomName().equalsIgnoreCase("§6Skeleton King")) {
			  Player p = e.getEntity().getKiller();
			  String s5 = killsStorage.loadPlayerKills(p);
			  int k = Integer.parseInt(s5)+1;
			  String kills = Integer.toString(k);
			  String s1 = experienceStorage.loadPlayerEXP(p);
			  int r = (int) (500 + new Random().nextInt(500) * getEXPBoost(p));
			  String s4 = tokenStorage.loadPlayerTokens(p);
			  int tokes = Integer.parseInt(s4) + 1;
			  String tokens = Integer.toString(tokes);
			  int exps = Integer.parseInt(s1) + r;;
			  String s2 = levelStorage.loadPlayerLevel(p);
			  int level = Integer.parseInt(s2);
			  int levelup = Integer.parseInt(s2) + 1;
			  String lvl = Integer.toString(levelup);
			  String s10 = bossKillStorage.loadPlayerBossKills(p);
			  int bk = Integer.parseInt(s10) + 1;
			  String bKills = Integer.toString(bk);
			  bossKillStorage.storePlayerBossKills(p, bKills);
			  ScoreboardUpdaters.setBoard(p);
			  if((level == 60)) { return; }
			  String s = experienceStorage.loadPlayerEXP(p);
			  int i = (int) (Integer.parseInt(s) + r);;
	        	String exp = Integer.toString(i);
	        	experienceStorage.storePlayerEXP(p, exp);
	        	if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
	        	p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "          +" + ChatColor.RED +  r + ChatColor.BOLD + " EXP"
		                    + ChatColor.RED + ChatColor.GRAY + " [" + exp + ChatColor.BOLD + "/" + ChatColor.GRAY + needed_exp(p) + " EXP]");
	        	ScoreboardUpdaters.setBoard(p);
	        	
	        	
		  }
	        	if(i > needed_exp(p)) {
	  			  levelStorage.storePlayerLevel(p, lvl);
	  			  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
	  			  p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "           LEVEL UP! " + ChatColor.RED
	  	                    + ChatColor.UNDERLINE + (level) + ChatColor.BOLD + " -> " + ChatColor.RED + ChatColor.UNDERLINE + levelup);
	  			  ScoreboardUpdaters.setBoard(p);
		  		  if(levelup == 3 || levelup == 6 || levelup == 9 || levelup == 12 || levelup == 15 || levelup == 18 || levelup == 21 || levelup == 24 || levelup == 27 || levelup == 30 || 
		  				levelup == 33 || levelup == 36 || levelup == 39 || levelup == 42 || levelup == 45 || levelup == 48 || levelup == 51 || levelup == 54 || levelup == 57 || levelup == 60) {
		  			  tokenStorage.storePlayerTokens(p, tokens);
		  			  if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
		  				  p.sendMessage("§a§l      +1 Token");
		  			  }
		  			  ScoreboardUpdaters.setBoard(p);
		  			  if(levelup == 60) {
		  				 p.sendMessage(ChatColor.YELLOW + "Congratulations! You have reached " + ChatColor.UNDERLINE + "LVL 60"
			                        + ChatColor.YELLOW + " this means you can no longer gather tokens from leveling");
			                p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(1) " + ChatColor.YELLOW + "You can Paragon Level "
			                        + "by typing /paragon and be reset back too LVL 1 and start gathering tokens with higher EXP rates.");
			                p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(2) " + ChatColor.YELLOW + "You can continue farming "
			                        + " gear with better drops from mobs since you're level 60 but no longer gather tokens ");
		  			  }
		  		  }
		  		  
		  		  }
	  	  }
	  }
	  
	  
	  @EventHandler
	    public void addExperience12(EntityDeathEvent e) {
		  if(e.getEntity().getCustomName().equalsIgnoreCase("§2Skeletal Minion")) {
			  Player p = e.getEntity().getKiller();
			  Random random = new Random();
	          int Chance = random.nextInt(10) + 1;
	          

			  
			  String s5 = killsStorage.loadPlayerKills(p);
			  int k = Integer.parseInt(s5)+1;
			  String kills = Integer.toString(k);
			  String s1 = experienceStorage.loadPlayerEXP(p);
			  int r = (int) (10 + new Random().nextInt(10)  * getEXPBoost(p));
			  String s4 = tokenStorage.loadPlayerTokens(p);
			  int tokes = Integer.parseInt(s4) + 1;
			  String tokens = Integer.toString(tokes);
			  int exps = Integer.parseInt(s1) + r;;
			  String s2 = levelStorage.loadPlayerLevel(p);
			  int level = Integer.parseInt(s2);
			  int levelup = Integer.parseInt(s2) + 1;
			  String lvl = Integer.toString(levelup);
			  String s10 = minionKillStorage.loadPlayerMinionKills(p);
			  int mk = Integer.parseInt(s10) + 1;
			  String mKills = Integer.toString(mk);
			  minionKillStorage.storePlayerMinionKills(p, mKills);
			  ScoreboardUpdaters.setBoard(p);
			  if((level == 60)) { return; }
			  String s = experienceStorage.loadPlayerEXP(p);
			  int i = (int) (Integer.parseInt(s) + r);;
	        	String exp = Integer.toString(i);
	        	experienceStorage.storePlayerEXP(p, exp);
	        	if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
	        	p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "          +" + ChatColor.RED +  r + ChatColor.BOLD + " EXP"
		                    + ChatColor.RED + ChatColor.GRAY + " [" + exp + ChatColor.BOLD + "/" + ChatColor.GRAY + needed_exp(p) + " EXP]");
	        	ScoreboardUpdaters.setBoard(p);
	        	
		  }
	        	if(i > needed_exp(p)) {
	  			  levelStorage.storePlayerLevel(p, lvl);
	  			  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
	  			  p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "           LEVEL UP! " + ChatColor.RED
	  	                    + ChatColor.UNDERLINE + (level) + ChatColor.BOLD + " -> " + ChatColor.RED + ChatColor.UNDERLINE + levelup);
	  			  ScoreboardUpdaters.setBoard(p);
	  			  if(levelup == 3 || levelup == 6 || levelup == 9 || levelup == 12 || levelup == 15 || levelup == 18 || levelup == 21 || levelup == 24 || levelup == 27 || levelup == 30 || 
			  				levelup == 33 || levelup == 36 || levelup == 39 || levelup == 42 || levelup == 45 || levelup == 48 || levelup == 51 || levelup == 54 || levelup == 57 || levelup == 60) {
			  			  tokenStorage.storePlayerTokens(p, tokens);
			  			  if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
			  				  p.sendMessage("§a§l      +1 Token");
			  			  }
			  			  ScoreboardUpdaters.setBoard(p);
			  			  if(levelup == 60) {
				  				 p.sendMessage(ChatColor.YELLOW + "Congratulations! You have reached " + ChatColor.UNDERLINE + "LVL 60"
					                        + ChatColor.YELLOW + " this means you can no longer gather tokens from leveling");
					                p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(1) " + ChatColor.YELLOW + "You can Paragon Level "
					                        + "by typing /paragon and be reset back too LVL 1 and start gathering tokens with higher EXP rates.");
					                p.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD.toString() + "(2) " + ChatColor.YELLOW + "You can continue farming "
					                        + " gear with better drops from mobs since you're level 60 but no longer gather tokens ");
				  			  }
			  			  return;
			  		  }
			  		  }
	  	  }
	  }
	  
	  
	  

	  public static int needed_exp(Player p) {
		  String s2 = levelStorage.loadPlayerLevel(p);
		  int level = Integer.parseInt(s2);
	        if (level == 1) {
	            return 30;
	        }
	        if (level == 2) {
	            return 123;
	        }
	        if (level == 3) {
	            return 312;
	        }
	        if (level == 4) {
	            return 630;
	        }
	        if (level == 5) {
	            return 1110;
	        }
	        if (level == 6) {
	            return 1786;
	        }
	        if (level == 7) {
	            return 2691;
	        }
	        if (level == 8) {
	            return 3859;
	        }
	        if (level == 9) {
	            return 5322;
	        }
	        if (level == 10) {
	            return 7113;
	        }
	        if (level == 11) {
	            return 9265;
	        }
	        if (level == 12) {
	            return 11809;
	        }
	        if (level == 13) {
	            return 14777;
	        }
	        if (level == 14) {
	            return 18201;
	        }
	        if (level == 15) {
	            return 22112;
	        }
	        if (level == 16) {
	            return 26538;
	        }
	        if (level == 17) {
	            return 31511;
	        }
	        if (level == 18) {
	            return 37058;
	        }
	        if (level == 19) {
	            return 43209;
	        }
	        if (level == 20) {
	            return 49991;
	        }
	        if (level == 21) {
	            return 57431;
	        }
	        if (level == 22) {
	            return 65555;
	        }
	        if (level == 23) {
	            return 74839;
	        }
	        if (level == 24) {
	            return 83956;
	        }
	        if (level == 25) {
	            return 94282;
	        }
	        if (level == 26) {
	            return 105389;
	        }
	        if (level == 27) {
	            return 117299;
	        }
	        if (level == 28) {
	            return 130033;
	        }
	        if (level == 29) {
	            return 143612;
	        }
	        if (level == 30) {
	            return 158056;
	        }
	        if (level == 31) {
	            return 173382;
	        }
	        if (level == 32) {
	            return 189610;
	        }
	        if (level == 33) {
	            return 206754;
	        }
	        if (level == 34) {
	            return 224833;
	        }
	        if (level == 35) {
	            return 243859;
	        }
	        if (level == 36) {
	            return 263848;
	        }
	        if (level == 37) {
	            return 284812;
	        }
	        if (level == 38) {
	            return 306765;
	        }
	        if (level == 39) {
	            return 329716;
	        }
	        if (level == 40) {
	            return 353677;
	        }
	        if (level == 41) {
	            return 378657;
	        }
	        if (level == 42) {
	            return 404664;
	        }
	        if (level == 43) {
	            return 431707;
	        }
	        if (level == 44) {
	            return 459792;
	        }
	        if (level == 45) {
	            return 488926;
	        }
	        if (level == 46) {
	            return 519113;
	        }
	        if (level == 47) {
	            return 550358;
	        }
	        if (level == 48) {
	            return 582665;
	        }
	        if (level == 49) {
	            return 616037;
	        }
	        if (level == 50) {
	            return 650475;
	        }
	        if (level == 51) {
	            return 685981;
	        }
	        if (level == 52) {
	            return 722555;
	        }
	        if (level == 53) {
	            return 760198;
	        }
	        if (level == 54) {
	            return 798908;
	        }
	        if (level == 55) {
	            return 838684;
	        }
	        if (level == 56) {
	            return 879524;
	        }
	        if (level == 57) {
	            return 921426;
	        }
	        if (level == 58) {
	            return 964385;
	        }
	        if (level == 59) {
	            return 1008398;
	        }
	        String s1 = experienceStorage.loadPlayerEXP(p);
	        return Integer.parseInt(s1);
	    }
	  
	  

	  public static double getEXPBoost(Player p) {
	        if (rankStorage.loadPlayerRank(p).equalsIgnoreCase("sub+")) {
	            return 1.05;
	        }
	        if (rankStorage.loadPlayerRank(p).equalsIgnoreCase("sub++")) {
	            return 1.05;
	        }
	        if (rankStorage.loadPlayerRank(p).equalsIgnoreCase("owner")) {
	            return 1.05;
	        }
	        return 1;
	    }
	  
	  @EventHandler
	    public void addExperience1(PlayerDeathEvent e) {
		  Player p = ((Player) e).getPlayer();
		  Random random = new Random();
        int Chance = random.nextInt(10) + 1;
        
        if(Tutorial.loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) { e.getDrops().clear();return; }
        
        if(Chance >= 3) {
      	 e.getEntity().getKiller().getWorld().dropItemNaturally(e.getEntity().getKiller().getLocation(), Common.getItem());
    	 return;
      }
      return;
	  }
	  
	  @EventHandler
	    public void addExperience122(EntityDeathEvent e) {
		  if(e.getEntity().getCustomName().equalsIgnoreCase("§2Skeletal Minion")) {
			  World tutorial = Bukkit.getWorld("Tutorial");
			  Player p = e.getEntity().getKiller();
			  Random random = new Random();
	          int Chance = random.nextInt(10) + 1;
			  if(e.getEntity().getWorld().equals(tutorial)) {
				  if(Chance >= 3) {
			           	 e.getEntity().getKiller().getWorld().dropItemNaturally(e.getEntity().getKiller().getLocation(), tutorialDrop.getTutorialItem());
			        	 return;
			  }
	          if(Chance >= 3) {
	           	 e.getEntity().getKiller().getWorld().dropItemNaturally(e.getEntity().getKiller().getLocation(), Common.getItem());
	        	 return;
	          }
	          return;
		  
			  }
		  }
			  
		  }
		  @EventHandler
		    public void addExperience1222(EntityDeathEvent e) {
			  if(e.getEntity().getCustomName().equalsIgnoreCase("§2Vampire")) {
				  World tutorial = Bukkit.getWorld("Tutorial");
				  Player p = e.getEntity().getKiller();
				  Random random = new Random();
		          int Chance = random.nextInt(10) + 1;
				  if(e.getEntity().getWorld().equals(tutorial)) {
					  if(Chance >= 3) {
				           	 e.getEntity().getKiller().getWorld().dropItemNaturally(e.getEntity().getKiller().getLocation(), tutorialDrop.getTutorialItem());
				        	 return;
				  }
		          if(Chance >= 3) {
		           	 e.getEntity().getKiller().getWorld().dropItemNaturally(e.getEntity().getKiller().getLocation(), Common.getItem());
		        	 return;
		          }
		          return;
			  
				  }
			  }
			  
	  }
	  
	  
	  @EventHandler
	    public void addExperience121(EntityDeathEvent e) {
		  if(e.getEntity().getCustomName().equalsIgnoreCase("§6Skeleton King")) {
			  Player p = e.getEntity().getKiller();
			  
			  Random random = new Random();
	          int Chance = random.nextInt(10) + 1;
	          
	          if(Chance >= 3 && p instanceof Player) {
	        	 p.getWorld().dropItemNaturally(p.getLocation(), Legendary.getItem());
	        	 return;
	          }
	          return;
		  }
	  }
	  
	  //@EventHandler
	  //  public void onDamage(EntityDamageByEntityEvent event){
	//	  LivingEntity entity = (LivingEntity)event.getEntity();
	//	  Random random = new Random();
		//  int boost = random.nextInt(5)+1;
	//	  event.setDamage(event.getDamage() + boost);
		//		  int damage = (int) event.getDamage() + boost; // damage
		//		  int max = (int) entity.getMaxHealth(); // max health
		//		//  int cur_hp = (int) Math.round(entity.getHealth()) - damage;
		//		  if (event.getDamager() instanceof Player) { // if a player last damaged the entity
		//		      Player player = (Player)event.getDamager(); // player who damaged the entity
		//		      player.sendMessage("     §c" + damage + "§c§l DMG§r§c ->§e " + entity.getCustomName() + "§e [" + Math.round(entity.getHealth()) + "§eHP]");
		//		  }
	  // //     return;
	 // }
      	  
      
}

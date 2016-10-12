package me.phantom.Scoreboard;

import java.text.DecimalFormat;

import me.phantom.Main;
import me.phantom.LevelingSystem.experienceStorage;
import me.phantom.LevelingSystem.levelStorage;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.Tokens.tokenStorage;
import me.phantom.Util.deathStorage;
import me.phantom.Util.killsStorage;
import net.ess3.api.events.UserBalanceUpdateEvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ScoreboardUpdaters implements Listener{
	


	  @EventHandler
	  public void onPlayerJoin(UserBalanceUpdateEvent e)
	  {
	    try
	    {
	      setBoard(e.getPlayer());
	    }
	    catch (Exception localException)
	    {
	    }
	  }
	
	  private Main plugin;

	  public ScoreboardUpdaters(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	  
	  public static void setBoard(Player p)
	  {
		  String rnk = rankStorage.loadPlayerRank(p);
		  String rank = rnk.substring(0, 1).toUpperCase() + rnk.substring(1);
		   int Tokens = Integer.parseInt(tokenStorage.loadPlayerTokens(p));
		   int Kills = Integer.parseInt(killsStorage.loadPlayerKills(p));
		   String Token = convertInt(Tokens);
		   String Kill = convertInt(Kills);
	    SBManager scoreboard = new SBManager("      §6§lLegend PvP        ");
	    scoreboard.add("§aTokens§f:");
	    scoreboard.add("§a» §b" + Token);
	    scoreboard.blankLine();
	    scoreboard.add("§aRank§f:");
	    scoreboard.add("§a» §b" + rank);
	    scoreboard.blankLine();
	    scoreboard.add("§aKills§f:");
	    scoreboard.add("§a» §b" + Kill);
	    scoreboard.blankLine();
	    scoreboard.add("§aLevel§f:");
	    scoreboard.add("§a» §b" + levelStorage.getPlayerLevel(p)); 
	    scoreboard.build();
	    scoreboard.send(new Player[] { p });
	  }
	  
	  public static String convertInt(int i) {
		    String n = Integer.toString(i);
		    int l = n.length();
		    if (l > 3) {
		        if (l < 7) {
		            return decimal(n, 3) + "K";
		        }
		        if (l < 10) {
		            return decimal(n, 6) + "M";
		        }
		        if (l < 13) {
		            return decimal(n, 9) + "B";
		        }
		        if (l < 16) {
		            return decimal(n, 12) + "T";
		        }
		        if (l < 19) {
		            return decimal(n, 15) + "Q";
		        }
		    }
		    return n;
		}
		   
		public static String decimal(String s, int i) {
		    int b = s.length() - i;
		    return s.substring(0, b) + "." + s.substring(b, b+2);
		}

}

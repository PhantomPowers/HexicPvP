package me.phantom.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.ScoreboardManager;

public class toggleSB  implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		Player p = (Player)sender;
		 if(cmd.equalsIgnoreCase("togglesb")) {
			 if(!p.getName().equalsIgnoreCase("PhantomPower")) { return false; }
			 ScoreboardManager sm = Bukkit.getServer().getScoreboardManager();   
             p.setScoreboard(sm.getNewScoreboard());
             return true;
		 }
		return false;
	  }

}

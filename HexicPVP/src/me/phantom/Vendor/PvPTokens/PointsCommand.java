package me.phantom.Vendor.PvPTokens;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PointsCommand implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("points")) {
			 if (!(sender instanceof Player)) {
				 return false;
			 }
			 Player p = (Player)sender;
			 
			 p.sendMessage("§c§lPVP-Points: " + PointsStorage.loadPlayerTokens(p));
		 }
		return false;
	  }


}

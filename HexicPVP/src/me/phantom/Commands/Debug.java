package me.phantom.Commands;



import me.phantom.Main;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.Util.debugStorage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Debug implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("debug")) {
			 
			 if (!(sender instanceof Player)) {
				 return false;
			 }
			 Player p = (Player)sender;
			 if(debugStorage.loadPlayerDebug(p).equalsIgnoreCase("true")) {
				 p.sendMessage(Main.getPrefix() +"§f§l             Debug Disabled");
				 debugStorage.storePlayerDebug(p, "false");
				 return true;
			 }
			 p.sendMessage(Main.getPrefix() + "§f§l             Debug Enabled");
			 debugStorage.storePlayerDebug(p, "true");
			 return true;
			 }
			
		return false;
	  }

}

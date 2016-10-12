package me.phantom.Vendor.PvPTokens;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pAlreadyBoughtDelete implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("resetw")) {
			 if (sender instanceof Player) {
				 return false;
			 }
			 
              File dir = new File("plugins/Vendor/pAlreadyBought");
    		 String[] children = dir.list();
    		    for (int i = 0; i < children.length; i++)
    		    {
    		       new File(dir, children[i]).delete();
    		    }
 		    dir.delete();
		 }
		return false;
	  }


}

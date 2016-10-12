package me.phantom.Report;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;




public class ReportCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
		 if(cmd.equalsIgnoreCase("report")) {
			 if (!(sender instanceof Player)) {
				 return false;
			 }
			 Player p = (Player)sender;

			 if(args.length == 0) {
				 p.sendMessage("§c/report <player>");
				 return true;
			 }
			 Player target = Bukkit.getServer().getPlayer(args[0]);
			 if(target == null) {
		    	  p.sendMessage("§7Could not find player§c " + args[0] + "§7!");
		    	  return true;
			 }
			 ItemStack slot0 = new ItemStack(Material.DIAMOND_SWORD, 1);
		        ItemStack slot1 = new ItemStack(Material.PAPER, 1);
		        ItemStack slot2= new ItemStack(Material.CHEST, 1);
		        
		        ItemMeta meta0 = slot0.getItemMeta();
		        meta0.setDisplayName("§4Hacking");
		        meta0.setLore(Arrays.asList(new String[] { "§7Report " + target.getName() + " for", "§7hacking of any sorts."}));
		        slot0.setItemMeta(meta0);
		        
		        ItemMeta meta1 = slot1.getItemMeta();
		        meta1.setDisplayName("§4Disrespect");
		        meta1.setLore(Arrays.asList(new String[] { "§7Report " + target.getName() + " for", "§7disrespecting people."}));
		        slot1.setItemMeta(meta1);
		        
		        ItemMeta meta5 = slot2.getItemMeta();
		        meta5.setDisplayName("§4Other");
		        meta5.setLore(Arrays.asList(new String[] { "§7Report " + target.getName() + " for", "§7breaking any other rules."}));
		        slot2.setItemMeta(meta5);

		        
		        
		        Inventory x104 = Bukkit.createInventory(null, 9, "Report: §4" + target.getName());

		        x104.setItem(0, slot0);
		        x104.setItem(1, slot1);
		        x104.setItem(2, slot2);
		        p.openInventory(x104);
		 }
		return false;
	  }


}

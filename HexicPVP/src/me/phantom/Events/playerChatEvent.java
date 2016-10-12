package me.phantom.Events;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import me.phantom.Main;
import me.phantom.DropSystem.Tiers.Common;
import me.phantom.DropSystem.Tiers.Legendary;
import me.phantom.DropSystem.Tiers.Rare;
import me.phantom.DropSystem.Tiers.Uncommon;
import me.phantom.LevelingSystem.levelStorage;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.Scoreboard.ScoreboardUpdaters;
import me.phantom.Tutorial.Tutorial;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class playerChatEvent implements Listener {
	  private Main plugin;

	  public playerChatEvent(Main plugin)
	  {
	    this.plugin = plugin;
	  }

@EventHandler
public void PlayerChatEvent(AsyncPlayerChatEvent e) {
	Player p = e.getPlayer();
	if(Tutorial.loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")){ e.setCancelled(true); return;}
	if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("owner")) {
		e.setCancelled(true);
		Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r] §4§lOwner §e" + p.getName() + " §7: " + e.getMessage());
		//p.getInventory().addItem(playerLevelUp.getCommonItem());
		return;
	}
	if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("developer")) {
		e.setCancelled(true);
		Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r] §e§lDev §c" + p.getName() + " §7: " + e.getMessage());
		return;
	}
	if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("vip")) {
		e.setCancelled(true);
		Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r]§a§lVIP §f" + p.getName() + " §7: " + e.getMessage());
		return;
	}
	if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("vip+")) {
		e.setCancelled(true);
		Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r]§a§lVIP+ §f" + p.getName() + " §7: " + e.getMessage());
		return;
	}
		if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("sub+")) {
			e.setCancelled(true);
			Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r] §b§lSUB+ §f" + p.getName() + " §7: " + e.getMessage());
			return;
		}
		if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("sub++")) {
			e.setCancelled(true);
			Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r] §b§lSUB++ §f" + p.getName() + " §7: " + e.getMessage());
			return;
		}
			if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("moderator")) {
				e.setCancelled(true);
				Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r] §b§lMod §f" + p.getName() + " §7: " + e.getMessage());
				return;
			}
				if(rankStorage.loadPlayerRank(p).equalsIgnoreCase("admin")) {
					e.setCancelled(true);
					Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r] §c§lAdmin §f" + p.getName() + " §7: " + e.getMessage());
					return;
				}
	e.setCancelled(true);
	Bukkit.broadcastMessage("§r[§b" + levelStorage.loadPlayerLevel(p) + "§r] §f " + p.getName() + " §7: " + e.getMessage());
	return;
}
public static String getPlayerPrefix(Player p) {
	String rank = rankStorage.loadPlayerRank(p);
	if(rank.equalsIgnoreCase("owner")) {
		return "§4§lOwner";
	}
	if(rank.equalsIgnoreCase("developer")) {
		return "§e§lDev";
	}
	if(rank.equalsIgnoreCase("vip")) {
		return "§a§lVIP";
	}
	if(rank.equalsIgnoreCase("vip+")) {
		return "§a§lVIP+";
	}
	if(rank.equalsIgnoreCase("sub+")) {
		return "§b§lSUB+";
	}
	if(rank.equalsIgnoreCase("sub++")) {
		return "§b§lSUB++";
	}
	if(rank.equalsIgnoreCase("moderator")) {
		return "§b§lMod";
	}
	if(rank.equalsIgnoreCase("admin")) {
		return "§c§lAdmin";
	}
	return null;
	
}


}


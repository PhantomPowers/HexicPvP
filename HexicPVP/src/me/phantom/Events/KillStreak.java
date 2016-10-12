package me.phantom.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.phantom.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KillStreak implements Listener{
	
	  private Main plugin;

	  public KillStreak(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  public static HashMap<String, Integer> killstreak = new HashMap();
	  HashMap<UUID, UUID> snowBall = new HashMap();

	  @EventHandler
	  public void onPlayerJoin(PlayerJoinEvent event) { killstreak.put(event.getPlayer().getName(), Integer.valueOf(0)); }

	  @EventHandler
	  public void onPlayerDeath(PlayerDeathEvent event) {
	    Player p = event.getEntity();
	    if ((p.getKiller() != null) && 
	      ((p.getKiller() instanceof Player))) {
	    	Player deead = p.getPlayer();
	      Player killer = p.getKiller();
	      if (killstreak.containsKey(killer.getName())) {
	        int kills = ((Integer)killstreak.get(killer.getName())).intValue();
	        kills++;
	        killstreak.put(killer.getName(), Integer.valueOf(kills));
	        killstreak.remove(p.getName());
	        if (kills == 5)
	        {
	          ItemStack squidg = new ItemStack(Material.INK_SACK);
	          ItemMeta sMeta = squidg.getItemMeta();
	          sMeta.setDisplayName(ChatColor.DARK_PURPLE + "Squid Grenade");
	          List lore = new ArrayList();
	          lore.add(ChatColor.GOLD + "Right click to blind your foes!");
	          sMeta.setLore(lore);
	          squidg.setItemMeta(sMeta);
	          killer.getInventory().addItem(new ItemStack[] { squidg });
	        } else if (kills == 7)
	        {
	          ItemStack hPack = new ItemStack(Material.SUGAR);
	          ItemMeta sMeta = hPack.getItemMeta();
	          sMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Epic Boost");
	          List lore = new ArrayList();
	          lore.add(ChatColor.GOLD + "Heal fully, and become invincible!");
	          sMeta.setLore(lore);
	          hPack.setItemMeta(sMeta);
	          killer.getInventory().addItem(new ItemStack[] { hPack });
	        } else if (kills == 9)
	        {
	          ItemStack FireBall = new ItemStack(Material.DRAGON_EGG);
	          ItemMeta sMeta = FireBall.getItemMeta();
	          sMeta.setDisplayName(ChatColor.DARK_PURPLE + "Summon Dragon");
	          List lore = new ArrayList();
	          lore.add(ChatColor.GOLD + "Right click to rain fire upon your foes.");
	          lore.add("3");
	          sMeta.setLore(lore);
	          FireBall.setItemMeta(sMeta);
	          killer.getInventory().addItem(new ItemStack[] { FireBall });
	        }
	      }
	      else {
	        killstreak.put(killer.getName(), Integer.valueOf(1));
	      }

	    }

	    killstreak.put(p.getName(), Integer.valueOf(0));
	  }
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent event) {
	    if (event.getPlayer().getLocation().getY() < 0.0D)
	      event.getPlayer().setHealth(0.0D);
	  }

	  @EventHandler
	  public void onPlayerInteract(PlayerInteractEvent event) {
	    Player p = event.getPlayer();
	    if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (event.hasItem())) {
	      ItemStack item = event.getItem();
	      if ((item.getItemMeta() != null) && 
	        (item.getItemMeta().getDisplayName() != null) && 
	        (item.getItemMeta().getLore() != null)) {
	        List lore = item.getItemMeta().getLore();

	        if (lore.contains(ChatColor.GOLD + "Right click to blind your foes!")) {
	          event.setCancelled(true);
	          p.setItemInHand(null);
	          Snowball snowball = (Snowball)p.launchProjectile(Snowball.class);
	          snowball.setShooter(p);
	          this.snowBall.put(snowball.getUniqueId(), snowball.getUniqueId());
	        }
	        else if (lore.contains(ChatColor.GOLD + "Heal fully, and become invincible!")) {
	          event.setCancelled(true);
	          p.setItemInHand(null);
	          p.setHealth(20.0D);
	          p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 2));
	        }
	        else if (lore.contains(ChatColor.GOLD + "Right click to rain fire upon your foes.")) {
	          event.setCancelled(true);

	          int use = Integer.valueOf((String)lore.get(1)).intValue();
	          use--;
	          if (use != 0) {
	            ItemMeta sMeta = item.getItemMeta();
	            lore.set(1, String.valueOf(use));
	            sMeta.setLore(lore);
	            item.setItemMeta(sMeta);
	          } else {
	            p.setItemInHand(null);
	          }
	          for (Entity entitys : p.getNearbyEntities(30.0D, 30.0D, 30.0D))
	            if ((entitys instanceof Player)) {
	              Location effectl = entitys.getLocation();
	              p.getWorld().playSound(effectl, Sound.ENDERDRAGON_GROWL, 10.0F, 3.0F);
	              entitys.setFireTicks(300);
	              for (int i = 0; i < 15; i++) {
	                entitys.getWorld().playEffect(effectl.add(0.0D, i, 0.0D), Effect.MOBSPAWNER_FLAMES, 1);
	                entitys.getWorld().playEffect(effectl.add(0.0D, i, 0.0D), Effect.MOBSPAWNER_FLAMES, 1);
	                entitys.getWorld().playEffect(effectl.add(0.0D, i, 0.0D), Effect.MOBSPAWNER_FLAMES, 1);
	                entitys.getWorld().playEffect(effectl.add(0.0D, i, 0.0D), Effect.MOBSPAWNER_FLAMES, 1);
	              }
	            }
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void onPlayerDamage(EntityDamageByEntityEvent event) {
	    if ((event.getDamager() instanceof Snowball)) {
	      Snowball snowball = (Snowball)event.getDamager();
	      if ((event.getEntity() instanceof Player)) {
	        Player p = (Player)event.getEntity();
	        if (this.snowBall.containsKey(snowball.getUniqueId())) {
	      p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
	        }
	      }
	    } else if (((event.getDamager() instanceof Player)) && 
	      ((event.getEntity() instanceof Player))) {
	      Player p = (Player)event.getEntity();
	      final Player damer = (Player)event.getDamager();
	      if (damer.getItemInHand() != null) {
	        ItemStack item = damer.getItemInHand();
	        if ((item.getItemMeta() != null) && (item.getItemMeta().getDisplayName() != null) && (item.getItemMeta().getLore() != null) && 
	          (item.getItemMeta().getLore().contains(ChatColor.GOLD + "Instant kill anyone. Love, Notch."))) {
	          int use = Integer.valueOf((String)item.getItemMeta().getLore().get(1)).intValue();
	          use--;
	          if (use != 0) {
	            List lore = item.getItemMeta().getLore();
	            ItemMeta sMeta = item.getItemMeta();
	            sMeta.setLore(lore);
	            item.setItemMeta(sMeta);
	            damer.setItemInHand(item);
	          } else {
	            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	            {
	              public void run() {
	                damer.getInventory().clear(damer.getInventory().getHeldItemSlot());
	                damer.updateInventory();
	              }
	            }
	            , 5L);
	            damer.playSound(p.getLocation(), Sound.ITEM_BREAK, 10.0F, 0.0F);
	          }
	          p.setHealth(0.0D);
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void onPlayerQuit(PlayerQuitEvent event) {
	    Player p = event.getPlayer();
	    if (killstreak.containsKey(p.getName()))
	      killstreak.remove(p.getName());
	  }

	  @EventHandler
	  public void onPlayerKick(PlayerKickEvent event) {
	    Player p = event.getPlayer();
	    if (killstreak.containsKey(p.getName()))
	      killstreak.remove(p.getName());
	  }
	}
	  
	  
	  



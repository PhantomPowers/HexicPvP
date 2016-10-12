package me.phantom;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

import me.phantom.Combat.HealthSystem;
import me.phantom.Combat.PlayerCombatSystem;
import me.phantom.Commands.Debug;
import me.phantom.Commands.addTokens;
import me.phantom.Commands.info;
import me.phantom.Commands.levelReset;
import me.phantom.Commands.toggleSB;
import me.phantom.Events.KillStreak;
import me.phantom.Events.playerChatEvent;
import me.phantom.Events.playerJoin;
import me.phantom.Kits.playerRespawnEvent;
import me.phantom.LevelingSystem.experienceStorage;
import me.phantom.LevelingSystem.levelResetStorage;
import me.phantom.LevelingSystem.levelStorage;
import me.phantom.LevelingSystem.playerLevelUp;
import me.phantom.RankingSystem.rankStorage;
import me.phantom.RankingSystem.setRank;
import me.phantom.Report.Report;
import me.phantom.Report.ReportCommand;
import me.phantom.Tokens.tokenShop;
import me.phantom.Tokens.tokenStorage;
import me.phantom.Tutorial.Tutorial;
import me.phantom.Tutorial.commands.finishTutorial;
import me.phantom.Util.PlotWorldSigns;
import me.phantom.Util.bossKillStorage;
import me.phantom.Util.deathStorage;
import me.phantom.Util.debugStorage;
import me.phantom.Util.killsStorage;
import me.phantom.Util.minionKillStorage;
import me.phantom.Util.pPlotMe;
import me.phantom.Vendor.ItemEvents;
import me.phantom.Vendor.Shop;
import me.phantom.Vendor.VendorItems;
import me.phantom.Vendor.currentItem;
import me.phantom.Vendor.PurchaseAmount.AlreadyPurchased;
import me.phantom.Vendor.PurchaseAmount.Common.PvPTokenOne;
import me.phantom.Vendor.PurchaseAmount.Common.SpeedBoots;
import me.phantom.Vendor.PurchaseAmount.Common.T1Build;
import me.phantom.Vendor.PurchaseAmount.Common.T2Build;
import me.phantom.Vendor.PurchaseAmount.Common.WarAxe;
import me.phantom.Vendor.PurchaseAmount.Legendary.Jordans;
import me.phantom.Vendor.PurchaseAmount.Legendary.SecretSword;
import me.phantom.Vendor.PurchaseAmount.Legendary.SubOne;
import me.phantom.Vendor.PurchaseAmount.Legendary.SubTwo;
import me.phantom.Vendor.PurchaseAmount.Legendary.Token;
import me.phantom.Vendor.PurchaseAmount.Rare.Hologram;
import me.phantom.Vendor.PurchaseAmount.Rare.Saturation;
import me.phantom.Vendor.PurchaseAmount.Rare.Vault;
import me.phantom.Vendor.PurchaseAmount.Rare.Wither;
import me.phantom.Vendor.PurchaseAmount.Rare.fix;
import me.phantom.Vendor.PurchaseAmount.Uncommon.CactusChestplate;
import me.phantom.Vendor.PurchaseAmount.Uncommon.ColorSigns;
import me.phantom.Vendor.PurchaseAmount.Uncommon.Plots;
import me.phantom.Vendor.PurchaseAmount.Uncommon.PvPTokenTwo;
import me.phantom.Vendor.PurchaseAmount.Uncommon.T3Build;
import me.phantom.Vendor.PvPTokens.KillPoints;
import me.phantom.Vendor.PvPTokens.PointsCommand;
import me.phantom.Vendor.PvPTokens.PointsStorage;
import me.phantom.Vendor.PvPTokens.pAlreadyBoughtDelete;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.worldcretornica.plotme.Plot;
import com.worldcretornica.plotme.PlotManager;



public class Main extends JavaPlugin
  implements Listener
{
	
	
	 private static HealthSystem healthSystem;
	 
	 
  public static Main plugin;
  public static Economy econ = null;
  static Plugin plotMe = Bukkit.getPluginManager().getPlugin("PlotMe-Core");
  static Plugin quests = Bukkit.getPluginManager().getPlugin("Quests-2.5.3-b92");
  
  public static boolean buff1 = false;
  
  public static long buff1_timeout = 0L;
  
  public static boolean buff2 = false;
  
  public static long buff2_timeout = 0L;

  public void onEnable() {
	  

    plugin = this;
    registerEvents(this, new Listener[] { new playerJoin(this), new levelStorage(this), new experienceStorage(this), new playerLevelUp(this), new playerChatEvent(this), new rankStorage(this)
    ,new debugStorage(this), new levelResetStorage(this), new tokenStorage(this),new killsStorage(this), new pPlotMe(this), new tokenShop(this), new deathStorage(this), new PlotWorldSigns(this), new playerRespawnEvent(this),
    new bossKillStorage(this), new minionKillStorage(this), new KillStreak(this), new Tutorial(this), new HealthSystem(this), new PlayerCombatSystem(this), new PvPTokenOne(this),
     new SpeedBoots(this), new T1Build(this), new T2Build(this), new WarAxe(this), new CactusChestplate(this), new ColorSigns(this),
      new Plots(this), new PvPTokenTwo(this), new T3Build(this), new fix(this), new Hologram(this), new Saturation(this), new Vault(this), new Wither(this),
      new Jordans(this), new SecretSword(this), new SubOne(this), new SubTwo(this), new Token(this), new AlreadyPurchased(this), new KillPoints(this),
       new PointsStorage(this), new ItemEvents(this), new currentItem(this), new Shop(this), new VendorItems(this), new Report(this), this});
    getCommand("debug").setExecutor(new Debug());
    getCommand("pinfo").setExecutor(new info());
    getCommand("report").setExecutor(new ReportCommand());
    getCommand("setrank").setExecutor(new setRank());
    getCommand("paragon").setExecutor(new levelReset());
    getCommand("setTokens").setExecutor(new addTokens());
    getCommand("ftutorial").setExecutor(new finishTutorial());
    getCommand("togglesb").setExecutor(new toggleSB());
    getCommand("points").setExecutor(new PointsCommand());
    getCommand("resetw").setExecutor(new pAlreadyBoughtDelete());
    
  
    
    this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
        public void run() {
            if (buff1 == true) {
                if ((System.currentTimeMillis() - buff1_timeout) > 0) {
                    // Time to stop the fun.
                    buff1 = false;
                    Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + ">> " + ChatColor.GOLD + "The " + ChatColor.UNDERLINE
                            + "+2x Global Kill Tokens Boost" + ChatColor.GOLD + " has expired.");
                }
            }
        }
    }, 15 * 20L, 1 * 20L);
    
    this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
        public void run() {
            if (buff2 == true) {
                if ((System.currentTimeMillis() - buff2_timeout) > 0) {
                    // Time to stop the fun.
                    buff2 = false;
                    Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + ">> " + ChatColor.GOLD + "The " + ChatColor.UNDERLINE
                            + "+3x Global Kill Tokens Boost" + ChatColor.GOLD + " has expired.");
                }
            }
        }
    }, 15 * 20L, 1 * 20L);
    
    scheduleRepeatAtTime(this, new Runnable()
    {
        public void run()
        {
        	for(Player p : Bukkit.getServer().getOnlinePlayers())
    		{
    		    p.closeInventory();
    		}
    		
    		Bukkit.broadcastMessage("§c(§4§l!§r§c) Vendor shop is resetting!");
    		 File dir = new File("plugins/Vendor/pVendorItem");
    		 File dir1 = new File("plugins/Vendor/pAlreadyBought");
    		 
    		 
    		 String[] children = dir.list();
    		    for (int i = 0; i < children.length; i++)
    		    {
    		       new File(dir, children[i]).delete();
    		    }
 		    dir.delete();
 		    
 		    getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "resetw");

    		 
    	        File userfiles;
    	        try {
    	            userfiles = new File("plugins/Vendor/pVendorItem");
    	            if(!userfiles.exists()){
    	                userfiles.mkdirs();
    	            }
    	        } catch(SecurityException e) {
    	            userfiles = null;
    	        }
    	     
    	        if(userfiles == null) {
    	            // do something...
    	        }
    	        
    	        File userfiles1;
    	        try {
    	            userfiles1 = new File("plugins/Vendor/pAlreadyBought");
    	            if(!userfiles1.exists()){
    	                userfiles1.mkdirs();
    	            }
    	        } catch(SecurityException e) {
    	            userfiles1 = null;
    	        }
    	     
    	        if(userfiles1 == null) {
    	            // do something...
    	        }

        }
    }, 12);
    if (!setupEconomy()) {
      getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", new Object[] { getDescription().getName() }));
      getServer().getPluginManager().disablePlugin(this);
      return;
    }
  }
  


  public void onDisable() {
    plugin = null;
  }
  
  
  
  
  

  private boolean setupEconomy()
  {
    if (getServer().getPluginManager().getPlugin("Vault") == null) {
      return false;
    }
    RegisteredServiceProvider rsp = getServer().getServicesManager().getRegistration(Economy.class);
    if (rsp == null) {
      return false;
    }
    econ = (Economy)rsp.getProvider();
    return econ != null;
  }

  public static void registerEvents(Plugin plugin, Listener[] listeners) {
    for (Listener listener : listeners)
      Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
  }

  public static Main getPlugin()
  {
    return plugin;
  }

  public void addRecipe() {
    ItemStack bwheat = new ItemStack(Material.WHEAT, 1);
    ItemMeta meta2 = bwheat.getItemMeta();
    meta2.setDisplayName("§eBetter Wheat");
    bwheat.setItemMeta(meta2);
    ShapedRecipe recipe = new ShapedRecipe(bwheat);
    recipe.shape(new String[] { "CAC", "ABA", "CAC" });
    recipe.setIngredient('B', Material.WHEAT);
    recipe.setIngredient('A', Material.HAY_BLOCK);
    recipe.setIngredient('C', Material.AIR);
    getServer().addRecipe(recipe);
  }
  @SuppressWarnings("deprecation")
public void addRecipe1() {
	    ItemStack bwheat = new ItemStack(Material.WHEAT, 1);
	    ItemMeta meta2 = bwheat.getItemMeta();
	    meta2.setDisplayName("§eBetter Wheat");
	    bwheat.setItemMeta(meta2);
	    ItemStack ewheat = new ItemStack(Material.WHEAT, 1);
	    ItemMeta meta3 = ewheat.getItemMeta();
	    meta3.setDisplayName("§eExcellent Wheat");
	    ewheat.setItemMeta(meta3);
	    ShapedRecipe recipe = new ShapedRecipe(ewheat);
	    recipe.shape(new String[] { "CAC", "ABA", "CAC" });
	    recipe.setIngredient('B', new MaterialData(Material.WHEAT, bwheat.getData().getData()));
	    recipe.setIngredient('A', Material.HAY_BLOCK);
	    recipe.setIngredient('C', Material.AIR);
	    getServer().addRecipe(recipe);
  }
	public static String getPrefix() {
		return  "§e(§e§l!§r§e) §7";
	}
	
	public static boolean isPlayerLocatedInHisPlot(Player player, Block b) {
		Plot plot1 = PlotManager.getPlotById(player);
        if (PlotManager.isPlotWorld(player)) {
            Plot plot = PlotManager.getPlotById(player.getLocation());
            if (plot !=null && plot.getOwner().equalsIgnoreCase(player.getName()) && PlotManager.isBlockInPlot(plot1, b.getLocation())) {
                return true;
            }
        }
        return false;
    }
	@EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        final Player p = (Player) e.getPlayer();
        
        Bukkit.getScheduler().runTaskLater( this, new Runnable() {
            @Override
            public void run() {
				ItemStack helmet = p.getInventory().getHelmet();
				ItemStack chestplate = p.getInventory().getChestplate();
				ItemStack leggings = p.getInventory().getLeggings();
				ItemStack boots = p.getInventory().getBoots();
				int Health = HealthSystem.getHealthStat(helmet) + HealthSystem.getHealthStat(chestplate) + HealthSystem.getHealthStat(leggings) + HealthSystem.getHealthStat(boots);
				p.setHealthScale(20);
				p.setHealthScaled(true);
				p.setMaxHealth(Health);
				p.setHealth(Health);
            }
        }, 1);
        if(Tutorial.loadPlayerTutorial(p).equalsIgnoreCase("nTutorial")) {
            int x = 136;
            int y = 6;
            int z = -213;
            World w = Bukkit.getWorld("spawn");
            final Location loc = new Location(w, x, y, z); //defines new location
            
            Bukkit.getScheduler().runTaskLater( this, new Runnable() {
                @Override
                public void run() {
	 		p.teleport(loc);
	 		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5 * 2000000, 2));
                }
            }, 1);
        
	 		
		  	 ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			    ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			    ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			    ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS, 1); 
			    ItemStack Sword = new ItemStack(Material.STONE_SWORD, 1);
			    ItemStack Bow = new ItemStack(Material.BOW,1);
			    ItemStack Gapple = new ItemStack(Material.GOLDEN_APPLE, 12);
			    ItemStack Steak = new ItemStack(Material.COOKED_BEEF, 64);
			    ItemStack Arrow = new ItemStack(Material.ARROW,64);
			    
			    ItemMeta meta0 = Helmet.getItemMeta();
		        meta0.setDisplayName("§rStarter Helmet");
		        meta0.setLore(Arrays.asList(new String[] { "§7Common"}));
		        Helmet.setItemMeta(meta0);
		        
			    ItemMeta meta1 = Chestplate.getItemMeta();
		        meta1.setDisplayName("§rStarter Chestplate");
		        meta1.setLore(Arrays.asList(new String[] { "§7Common"}));
		        Chestplate.setItemMeta(meta1);
		        
			    ItemMeta meta2 = Leggings.getItemMeta();
		        meta2.setDisplayName("§rStarter Leggings");
		        meta2.setLore(Arrays.asList(new String[] { "§7Common"}));
		        Leggings.setItemMeta(meta2);
		        
			    ItemMeta meta3 = Boots.getItemMeta();
		        meta3.setDisplayName("§rStarter Boots");
		        meta3.setLore(Arrays.asList(new String[] { "§7Common"}));
		        Boots.setItemMeta(meta3);
		        
			    ItemMeta meta4 = Sword.getItemMeta();
		        meta4.setDisplayName("§rStarter Sword");
		        meta4.setLore(Arrays.asList(new String[] { "§7Common"}));
		        Sword.setItemMeta(meta4);
		        
			    ItemMeta meta5 = Bow.getItemMeta();
		        meta5.setDisplayName("§rStarter Bow");
		        meta5.setLore(Arrays.asList(new String[] { "§7Common"}));
		        Bow.setItemMeta(meta5);

		        p.getInventory().setHelmet(Helmet);
		        p.getInventory().setChestplate(Chestplate);
		        p.getInventory().setLeggings(Leggings);
		        p.getInventory().setBoots(Boots);
		        p.getInventory().addItem(Sword, Bow, Gapple, Steak, Arrow);
	 		return;
        }
        return;
  }
	
	public static WorldGuardPlugin getWorldGuard() {
           Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        
           // WorldGuard may not be loaded
           if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
               return null; // Maybe you want throw an exception instead
           }
        
           return (WorldGuardPlugin) plugin;
       }
      
       public static WorldEditPlugin getWorldEdit() {
               Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
                
           // WorldGuard may not be loaded
           if (plugin == null || !(plugin instanceof WorldEditPlugin)) {
               return null; // Maybe you want throw an exception instead
           }
        
           return (WorldEditPlugin) plugin;
       }
       
    
       public static HealthSystem getHealthMechanics() {
           return healthSystem;
       }
       /**
        * Schedules a task to run at a certain hour every day.
        * @param plugin The plugin associated with this task
        * @param task The task to run
        * @param hour [0-23] The hour of the day to run the task
        * @return Task id number (-1 if scheduling failed)
        */
       public static int scheduleRepeatAtTime(Plugin plugin, Runnable task, int hour)
       {
           //Calendar is a class that represents a certain time and date.
           Calendar cal = Calendar.getInstance(); //obtains a calendar instance that represents the current time and date
        
           //time is often represented in milliseconds since the epoch,
           //as a long, which represents how many milliseconds a time is after
           //January 1st, 1970, 00:00.
        
           //this gets the current time
           long now = cal.getTimeInMillis();
           //you could also say "long now = System.currentTimeMillis()"
        
           //since we have saved the current time, we need to figure out
           //how many milliseconds are between that and the next
           //time it is 7:00pm, or whatever was passed into hour
           //we do this by setting this calendar instance to the next 7:00pm (or whatever)
           //then we can compare the times
        
           //if it is already after 7:00pm,
           //we will schedule it for tomorrow,
           //since we can't schedule it for the past.
           //we are not time travelers.
           if(cal.get(Calendar.HOUR_OF_DAY) >= hour)
               cal.add(Calendar.DATE, 1); //do it tomorrow if now is after "hours"
        
           //we need to set this calendar instance to 7:00pm, or whatever.
           cal.set(Calendar.HOUR_OF_DAY, hour);
           cal.set(Calendar.MINUTE, 0);
           cal.set(Calendar.SECOND, 0);
           cal.set(Calendar.MILLISECOND, 0);
        
           //cal is now properly set to the next time it will be 7:00pm
        
           long offset = cal.getTimeInMillis() - now;
           long ticks = offset / 50L; //there are 50 milliseconds in a tick
        
           //we now know how many ticks are between now and the next time it is 7:00pm
           //we schedule an event to go off the next time it is 7:00pm,
           //and repeat every 24 hours.
           return Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, task, ticks, 1728000L);
           //24 hrs/day * 60 mins/hr * 60 secs/min * 20 ticks/sec = 1728000 ticks
       }
   
   
}
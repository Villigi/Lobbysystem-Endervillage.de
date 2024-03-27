package de.villigi.lobbysystemendervillage;

import de.villigi.lobbysystemendervillage.commands.BuildCMD;
import de.villigi.lobbysystemendervillage.commands.setLoc_CMD;
import de.villigi.lobbysystemendervillage.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class LobbySystem extends JavaPlugin {

    public static LobbySystem instance;

    
    public static File configFile;
    public static YamlConfiguration cfg;

    public static final String prefix = "§6Lobbysystem §7|";
    public static List<Player> inBuild = new ArrayList<>();


    @Override
    public void onEnable() {
        instance = this;

        loadCommands();
        loadListener();
        loadConfig();

        LobbySystem.configFile = new File("plugins/Lobbysystem", "config.yml");
        LobbySystem.cfg  = YamlConfiguration.loadConfiguration(configFile);

        sendActionBar();
    }

    public void sendActionBar() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(int i = 0; i<inBuild.size(); i++) {
                    inBuild.get(i).sendActionBar("§a§lBuild Modus: §oAktiviert");
                }
            }
        }.runTaskTimer(this, 20, 20*2);
    }


    public void loadListener() {
        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new OverideFriendCMD(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public void loadCommands() {
        getCommand("setloc").setExecutor(new setLoc_CMD());
        getCommand("build").setExecutor(new BuildCMD());
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LobbySystem getInstance() {
        return instance;
    }
}

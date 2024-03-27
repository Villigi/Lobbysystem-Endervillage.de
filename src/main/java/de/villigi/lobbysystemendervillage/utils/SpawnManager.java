package de.villigi.lobbysystemendervillage.utils;

import de.villigi.lobbysystemendervillage.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;

public class SpawnManager {

    public static void setLocation(String name, Player p){
        File ordner = new File("plugins//LobbySystem//Spawns");
        File file = new File("plugins//LobbySystem//Spawns//" + name + ".yml");

        try {
            if(!ordner.exists()){
                ordner.mkdir();
            }
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            Location loc = p.getLocation();

            cfg.set("X", loc.getX());
            cfg.set("Y", loc.getY());
            cfg.set("Z", loc.getZ());
            cfg.set("Welt", loc.getWorld().getName());
            cfg.set("Yaw", loc.getYaw());
            cfg.set("Pitch", loc.getPitch());

            try {
                cfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void useLocation(Player p, String name){
        try {
            File file = new File("plugins//LobbySystem//Spawns//" + name + ".yml");

            if(!file.exists()){
                p.sendMessage(LobbySystem.prefix + "Die Location wurde nicht gefunden §8§l(§c§l/SETLOC§8§l)");
            }

            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            World welt = Bukkit.getWorld(cfg.getString("Welt"));
            double yaw = cfg.getDouble("Yaw");
            double pitch = cfg.getDouble("Pitch");



            p.teleport(new Location(welt, cfg.getDouble("X"), cfg.getDouble("Y"), cfg.getDouble("Z"), (float) yaw, (float) pitch));

            Vector vec = p.getVelocity();
            vec.setY(0.5);

            p.setVelocity(vec);
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    public static void useLocationfirst(Player p, String name){
        File file = new File("plugins//LobbySystem//Spawns//" + name + ".yml");

        if(!file.exists()){
            p.sendMessage(LobbySystem.prefix + "Die Location wurde nicht gefunden §8§l(§c§l/SETLOC§8§l)");
        }

        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        World welt = Bukkit.getWorld(cfg.getString("Welt"));
        double yaw = cfg.getDouble("Yaw");
        double pitch = cfg.getDouble("Pitch");


        Bukkit.getScheduler().runTaskLater(LobbySystem.getPlugin(LobbySystem.class), new Runnable() {

            @Override
            public void run() {
                p.teleport(new Location(welt, cfg.getDouble("X"), cfg.getDouble("Y"), cfg.getDouble("Z"), (float) yaw, (float) pitch));
            }
        }, 1);

    }

    public static Location getLocation(String name){
        File file = new File("plugins//LobbySystem//Spawns//" + name + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        World welt = Bukkit.getWorld(cfg.getString("Welt"));
        double yaw = cfg.getDouble("Yaw");
        double pitch = cfg.getDouble("Pitch");
        return new Location(welt, cfg.getDouble("X"), cfg.getDouble("Y"), cfg.getDouble("Z"), (float) yaw, (float) pitch);
    }


}

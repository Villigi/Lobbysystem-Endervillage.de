package de.villigi.lobbysystemendervillage.commands;

import de.villigi.lobbysystemendervillage.LobbySystem;
import de.villigi.lobbysystemendervillage.utils.SpawnManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setLoc_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("LS.Setloc")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("Spawn")) {
                    SpawnManager.setLocation("SP", p);
                    p.sendMessage(LobbySystem.prefix + "§7 Die Location '§bSpawn§7' wurde gesetzt!");
                }else if(args[0].equalsIgnoreCase("LaserTag")) {
                    SpawnManager.setLocation("LaserTag", p);
                    p.sendMessage(LobbySystem.prefix + "§7 Die Location '§bLaserTag§7' wurde gesetzt!");
                }else if(args[0].equalsIgnoreCase("City")) {
                    SpawnManager.setLocation("FB", p);
                }
            }else {
                p.sendMessage(LobbySystem.prefix + "§c Bitte benutze: §bSpawn,City, LaserTag");
            }
        }else {
            p.sendMessage(LobbySystem.prefix + "§c Keine Rechte!");
        }


        return false;
    }
}

package de.villigi.lobbysystemendervillage.commands;

import de.villigi.lobbysystemendervillage.LobbySystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BuildCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("command.build")) {
            if(!LobbySystem.inBuild.contains(p)) {
                LobbySystem.inBuild.add(p);
                p.sendMessage(LobbySystem.prefix + "§aDu bist nun im Build Modus!");
            }else{
                LobbySystem.inBuild.remove(p);
                p.sendMessage(LobbySystem.prefix + "§cDu bist nun nicht mehr im Build Modus!");
            }
        }else{
            p.sendMessage(LobbySystem.prefix + "§cDu hast keine Rechte!");
        }

        return false;
    }
}

package de.villigi.lobbysystemendervillage.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class OverideFriendCMD implements Listener {

    @EventHandler
    public void onPluginCommand(PlayerCommandPreprocessEvent event) {
        Player p = (Player) event.getPlayer();
        String command = event.getMessage();
        if(command.equalsIgnoreCase("friend")) {
            event.setCancelled(true);
            p.performCommand("f");
        }
    }
}

package de.villigi.lobbysystemendervillage.listener;

import de.villigi.lobbysystemendervillage.LobbySystem;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class BlockBreakPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(!LobbySystem.inBuild.contains(event.getPlayer())) {
            event.setCancelled(true);
        }

    }



    @EventHandler
    public void onMobSpawn(EntitySpawnEvent event) {
        if(LobbySystem.inBuild.size() == 0) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if(!LobbySystem.inBuild.contains(event.getPlayer())) {
            event.setCancelled(true);
        }

    }

}

package de.villigi.lobbysystemendervillage.listener;

import de.villigi.lobbysystemendervillage.LobbySystem;
import de.villigi.lobbysystemendervillage.utils.SpawnManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        Player p = (Player) event.getPlayer();
        event.setJoinMessage(null);
        p.getInventory().clear();
        SpawnManager.useLocation(p, "SP");
        if(!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage(LobbySystem.prefix + "§7 Der Spieler §6" + p.getDisplayName() + "§7 ist gerade das erstemal auf den Server connectet!");
        }


        ItemStack compas = new ItemStack(Material.HONEYCOMB);
        ItemMeta metaCompas = compas.getItemMeta();
        metaCompas.setDisplayName("§bNavigator");
        compas.setItemMeta(metaCompas);

        p.getInventory().setItem(4, compas);

    }


    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {
        Player p = (Player) event.getPlayer();
        event.setQuitMessage(null);


    }


}

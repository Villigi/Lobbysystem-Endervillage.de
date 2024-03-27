package de.villigi.lobbysystemendervillage.listener;

import de.villigi.lobbysystemendervillage.utils.SpawnManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();


        if(event.getView().getTitle().equalsIgnoreCase("§bNavigator")) {
            event.setCancelled(true);
        }

        if(event.getWhoClicked() != null) {
            if(event.getCurrentItem() != null) {
                if(event.getCurrentItem().getItemMeta() != null) {
                    if(event.getCurrentItem().getItemMeta().getDisplayName() != null) {
                        if(event.getClickedInventory() != null) {
                            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpawn")) {
                                p.closeInventory();
                                SpawnManager.useLocation(p, "SP");
                            }else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCity")) {
                                p.closeInventory();
                                SpawnManager.useLocation(p, "FB");
                            }
                        }
                    }
                }
            }
        }
    }




}

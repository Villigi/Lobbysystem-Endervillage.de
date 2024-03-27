package de.villigi.lobbysystemendervillage.listener;

import de.villigi.lobbysystemendervillage.utils.ItemBuilder;
import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player p = (Player) event.getPlayer();
        Action action = event.getAction();

        HashMap<Integer, ItemStack> integerItemStackHashMap = new HashMap<>();


        if(event.getItem() != null) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bNavigator")) {
                    Inventory inv = Bukkit.createInventory(null, 5*9, "§bNavigator");
                    p.openInventory(inv);

                    integerItemStackHashMap.put(4, new ItemBuilder(Material.NETHER_STAR).setDisplayname("§bSpawn").setLore("§7Rechtsklick zum Teleportieren.").build());

                    integerItemStackHashMap.put(12, new ItemBuilder(Material.BARRIER).setDisplayname("§bSoon...").build());

                    CustomStack customStack = CustomStack.getInstance("crystal_tree_sapling");

                    ItemStack stack = customStack.getItemStack();
                    ItemMeta meta = stack.getItemMeta();
                    meta.setDisplayName("§bCity");
                    List<String> lore = new ArrayList<>();
                    lore.add("§7Rechtsklick zum Teleportieren.");
                    meta.setLore(lore);
                    stack.setItemMeta(meta);

                    integerItemStackHashMap.put(14, stack);

                    integerItemStackHashMap.put(24, new ItemBuilder(Material.AZALEA).setDisplayname("§bSoon...").build());


                    integerItemStackHashMap.put(20, new ItemBuilder(Material.BARRIER).setDisplayname("§bSoon...").build());
                    integerItemStackHashMap.put(30, new ItemBuilder(Material.BARRIER).setDisplayname("§bSoon...").build());
                    integerItemStackHashMap.put(40, new ItemBuilder(Material.BARRIER).setDisplayname("§bSoon...").build());
                    integerItemStackHashMap.put(32, new ItemBuilder(Material.BARRIER).setDisplayname("§bSoon...").build());


                    integerItemStackHashMap.put(13, new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(22, new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(21, new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(23, new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(31, new ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(0, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(2, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(3, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(5, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(6, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(7, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(8, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(9, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(11, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(15, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(16, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(17, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(18, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(25, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(26, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(27, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(28, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(29, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(33, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(34, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(35, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(36, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(37, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(38, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(39, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    integerItemStackHashMap.put(41, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(42, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(43, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());
                    integerItemStackHashMap.put(44, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname("§c").build());

                    for (Map.Entry<Integer, ItemStack> integerItemStackEntry : integerItemStackHashMap.entrySet()) {
                        inv.setItem(integerItemStackEntry.getKey(), integerItemStackEntry.getValue());
                    }

                }
            }
        }


    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();




    }

}

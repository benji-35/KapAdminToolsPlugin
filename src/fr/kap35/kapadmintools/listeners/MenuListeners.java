package fr.kap35.kapadmintools.listeners;

import fr.kap35.kapadmintools.KapAdminTools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MenuListeners implements Listener {

    KapAdminTools plugin;

    public MenuListeners(KapAdminTools plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof org.bukkit.entity.Player) {
            plugin.getGuiManager().checkMenusActions(event);
        }
    }
}

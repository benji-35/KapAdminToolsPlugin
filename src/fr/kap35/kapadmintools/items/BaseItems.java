package fr.kap35.kapadmintools.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BaseItems {

    public ItemStack nextPage() {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("Next page");
            item.setItemMeta(meta);
        }

        return item;
    }

    public ItemStack previousPage() {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName("Previous page");
            item.setItemMeta(meta);
        }

        return item;
    }

}

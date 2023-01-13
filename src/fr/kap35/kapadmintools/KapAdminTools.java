package fr.kap35.kapadmintools;

import fr.kap35.kapadmintools.commands.PanelAdminCommand;
import fr.kap35.kapadmintools.items.BaseItems;
import fr.kap35.kapadmintools.listeners.MenuListeners;
import fr.kap35.kapadmintools.menus.PanelAdminGUI;
import fr.kap35.kapeasymenu.KapEasyMenu;
import fr.kap35.kapeasymenu.Menu.GuiManager;
import fr.kap35.kapeasymenu.Menu.GuiMenu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KapAdminTools extends JavaPlugin {

    BaseItems items;
    GuiManager manager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("KapAdminTools is enabled !");
        items = new BaseItems();

        getCommand("kapadmintools").setExecutor(new PanelAdminCommand(this));
        getServer().getPluginManager().registerEvents(new MenuListeners(this), this);
        manager = ((KapEasyMenu)Bukkit.getServer().getPluginManager().getPlugin("KapEasyMenu")).getGuiManager();
        manager.registerMenus(new PanelAdminGUI(this), "Panel Admin");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("KapAdminTools is disabled !");
    }

    public BaseItems getItems() {
        return items;
    }

    public GuiManager getGuiManager() {
        return manager;
    }
}

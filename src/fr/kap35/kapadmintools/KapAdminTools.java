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

import java.util.UUID;

public class KapAdminTools extends JavaPlugin {

    BaseItems items;
    GuiManager manager;
    KapEasyMenu easyMenu;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("KapAdminTools is enabled !");
        items = new BaseItems();

        getCommand("kapadmintools").setExecutor(new PanelAdminCommand(this));
        getServer().getPluginManager().registerEvents(new MenuListeners(this), this);
        easyMenu = (KapEasyMenu) Bukkit.getPluginManager().getPlugin("KapEasyMenu");
        if (easyMenu == null) {
            Bukkit.getConsoleSender().sendMessage("KapEasyMenu is not installed ! Disabling KapAdminTools...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        Bukkit.getConsoleSender().sendMessage("Using KapEasyMenu version " + easyMenu.getDescription().getVersion());
        manager = easyMenu.getGuiManager();
        manager.registerMenus(new PanelAdminGUI(this), "Panel Admin");
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("KapAdminTools is disabled !");
    }

    public BaseItems getItems() {
        return items;
    }

    public GuiManager getGuiManager() {
        return manager;
    }

    public KapEasyMenu getEasyMenu() {
        return easyMenu;
    }

    public boolean isPlayerMuted(UUID uuid) {
        return false;
    }

    public boolean isPlayerBanned(UUID uuid) {
        return false;
    }
}

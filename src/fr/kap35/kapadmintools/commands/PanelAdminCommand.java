package fr.kap35.kapadmintools.commands;

import fr.kap35.kapadmintools.KapAdminTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PanelAdminCommand implements CommandExecutor {

    KapAdminTools plugin;
    public PanelAdminCommand(KapAdminTools kapAdminTools) {
        this.plugin = kapAdminTools;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command !");
            return false;
        }
        Player p = (Player) sender;
        plugin.getGuiManager().openMenu(p, "Panel Admin");
        return true;
    }
}

package fr.kap35.kapadmintools.saves;

import fr.kap35.kapadmintools.KapAdminTools;
import fr.kap35.kapadmintools.logger.AdminLogger;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Saves {

    boolean useDatabase = false;
    AdminLogger logger;
    KapAdminTools plugin;

    FileConfiguration config;

    ArrayList<Ban> bans = new ArrayList<>();

    public Saves(KapAdminTools plugin) {
        this.plugin = plugin;
        logger = new AdminLogger();
        File _config = new File(plugin.getDataFolder(), "kapAdmin.yml");

        if (!_config.exists()) {
            _config.getParentFile().mkdirs();
            plugin.saveResource("kapAdmin.yml", false);
        }

        config = new YamlConfiguration();
        try {
            config.load(_config);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        useDatabase = config.getBoolean("config.use-database");
    }

    private void initDatabase() {
        if (useDatabase) {

        }
    }

    public boolean isUseDatabase() {
        return useDatabase;
    }

    public void banPlayer(Player player, String reason) {
        banPlayer(player, reason, -1);
    }

    public void banPlayer(Player player, String reason, int time) {
        if (useDatabase) {

        } else {
            if (time == -1) {
                config.set("ban.players", "");
            }
        }
    }

    public void banIpPlayer(Player player, String reason) {

    }

    public void mutePlayer(Player player, String reason) {
        mutePlayer(player, reason, -1);
    }

    public void mutePlayer(Player player, String reason, int time) {

    }

    //getters
    public ArrayList<Ban> getBanPlayers() {
        return bans;
    }

    private void updateListBans() {
        bans.clear();
        for (String uuid : config.getStringList("ban.players")) {
            if (config.get("ban.players." + uuid + ".time") != null) {
                bans.add(new Ban(UUID.fromString(uuid), config.getString("ban.players." + uuid + ".reason"), config.getInt("ban.players." + uuid + ".time")));
            } else {
                bans.add(new Ban(UUID.fromString(uuid), config.getString("ban.players." + uuid + ".reason")));
            }
        }
    }
}

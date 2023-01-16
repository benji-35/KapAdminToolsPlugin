package fr.kap35.kapadmintools.saves;

import org.bukkit.entity.Player;

import java.util.UUID;

public class Ban {

    private UUID uuid = null;
    private String reason = "";
    private int time = -1;

    public Ban(UUID player, String reason) {
        this.uuid = player;
        this.reason = reason;
    }

    public Ban(UUID player, String reason, int time) {
        this.uuid = player;
        this.reason = reason;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public UUID getUuid() {
        return uuid;
    }
}

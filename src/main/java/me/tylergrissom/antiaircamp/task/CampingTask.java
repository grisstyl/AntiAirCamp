package me.tylergrissom.antiaircamp.task;

import lombok.Getter;
import me.tylergrissom.antiaircamp.AntiAirCampPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright Tyler Grissom 2018
 */
public class CampingTask extends BukkitRunnable {

    @Getter
    private AntiAirCampPlugin plugin;

    @Getter
    private static Map<UUID, Integer> inactiveTime;

    static {
        inactiveTime = new HashMap<>();
    }

    public CampingTask(AntiAirCampPlugin plugin) {
        this.plugin = plugin;
    }

    private void increment(Player p) {
        if (!inactiveTime.containsKey(p.getUniqueId())) {
            inactiveTime.put(p.getUniqueId(), 0);
        }

        int current = inactiveTime.get(p.getUniqueId());

        inactiveTime.remove(p.getUniqueId());
        inactiveTime.put(p.getUniqueId(), current + 1);
    }

    public static void reset(Player p) {
        getInactiveTime().remove(p.getUniqueId());
        getInactiveTime().put(p.getUniqueId(), 0);
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(this::increment);

        Bukkit.getOnlinePlayers()
                .stream()
                .filter(player -> inactiveTime.get(player.getUniqueId()) > getPlugin().getOptions().getCampTimer() && !player.isOnGround())
                .forEach(player -> player.damage(1));
    }
}

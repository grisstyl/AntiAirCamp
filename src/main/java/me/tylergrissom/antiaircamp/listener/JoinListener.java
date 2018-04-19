package me.tylergrissom.antiaircamp.listener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.tylergrissom.antiaircamp.AntiAirCampPlugin;
import me.tylergrissom.antiaircamp.task.CampingTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public class JoinListener implements Listener {

    @Getter
    private AntiAirCampPlugin plugin;

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        Player p = event.getPlayer();

        CampingTask.getInactiveTime().put(p.getUniqueId(), 0);
    }
}

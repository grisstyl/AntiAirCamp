package me.tylergrissom.antiaircamp.listener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.tylergrissom.antiaircamp.AntiAirCampPlugin;
import me.tylergrissom.antiaircamp.task.CampingTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public class MoveListener implements Listener {

    @Getter
    private AntiAirCampPlugin plugin;

    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        Player p = event.getPlayer();

        if (p.isOnGround()) {
            CampingTask.reset(p);
        }
    }
}

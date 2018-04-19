package me.tylergrissom.antiaircamp;

import lombok.Getter;
import me.tylergrissom.antiaircamp.configuration.ConfigurationOptions;
import me.tylergrissom.antiaircamp.listener.JoinListener;
import me.tylergrissom.antiaircamp.listener.QuitListener;
import me.tylergrissom.antiaircamp.task.CampingTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Copyright Tyler Grissom 2018
 */
public class AntiAirCampPlugin extends JavaPlugin {

    @Getter
    private AntiAirCampPlugin plugin;

    @Getter
    private ConfigurationOptions options;

    @Override
    public void onEnable() {
        plugin = this;

        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }

        options = new ConfigurationOptions(getConfig());

        Bukkit.getPluginManager().registerEvents(new JoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(this), this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CampingTask(this), 0, 20);
    }
}

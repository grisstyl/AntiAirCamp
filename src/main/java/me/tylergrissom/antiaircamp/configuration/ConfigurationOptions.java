package me.tylergrissom.antiaircamp.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Copyright Tyler Grissom 2018
 */
@AllArgsConstructor
public class ConfigurationOptions {

    @Getter
    private FileConfiguration config;

    public int getCampTimer() {
        return getConfig().getInt("camp_timer", 7);
    }
}

package me.gacekmpl2.gacekskyblockmanger.essentials;

import org.bukkit.configuration.file.YamlConfiguration;


public class ConfigLoad {
    public static void loadAll() {
        load();
    }

    public static void load() {
        YamlConfiguration configuration = Configs.load("config.yml");
        assert configuration != null;
        Configs.save(configuration, "config.yml");
    }
}
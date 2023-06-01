package me.gacekmpl2.gacekskyblockmanger.essentials;

import me.gacekmpl2.gacekskyblockmanger.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configs {
    private static Main plugins = Main.getPlugin();

    public static YamlConfiguration load(String configName) {
        File file = new File(plugins.getDataFolder() + File.separator + configName);
        if (!file.exists())
            plugins.saveResource(configName, false);
        YamlConfiguration conf = new YamlConfiguration();
        try {
            conf.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        return conf;
    }

    public static void save(YamlConfiguration conf, String file) {
        try {
            conf.save(new File(plugins.getDataFolder(), file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
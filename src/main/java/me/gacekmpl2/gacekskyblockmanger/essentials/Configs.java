package me.gacekmpl2.gacekskyblockmanger.essentials;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static me.gacekmpl2.gacekskyblockmanger.essentials.Debug.log;

public class Configs {

    public static YamlConfiguration load(String configName) throws IOException {

        File file = new File("plugins/" + File.separator + "GacekSkyblockManger", configName + ".yml");

        if (!file.exists()) {

            YamlConfiguration config = new YamlConfiguration();

            config.set("sbmanager.globalprefix", "&a&lSKYBLOCK &f»");
            config.set("sbmanager.prefix", "&7[&c&lAC&7] ");
            config.set("sbmanager.nickcolor", "&c");
            config.set("sbmanager.textcolor", " &7»");
            config.set("sbmanager.ytmessage", "&7Zapraszamy na &c&lLIVE&7: &8[LINK]");
            config.set("sbmanager.hoverytmessage", "&7Kliknij tutaj, aby otworzyć!");

            config.save(file);

            return config;

        } else {

            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            if (config.getValues(false).isEmpty()) {
                log("File configuration empty.");
                config.set("sbmanager.globalprefix", "&a&lSKYBLOCK &f»");
                config.set("sbmanager.prefix", "&7[&c&lAC&7] ");
                config.set("sbmanager.nickcolor", "&c");
                config.set("sbmanager.textcolor", " &7»");
                config.set("sbmanager.ytmessage", "&7Zapraszamy na &c&lLIVE&7: &8[LINK]");
                config.set("sbmanager.hoverytmessage", "&7Kliknij tutaj, aby otworzyć!");

                config.save(file);
                return config;
            }

            try {
                config.load(file);
                return config;
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
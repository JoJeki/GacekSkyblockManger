package me.gacekmpl2.gacekskyblockmanger.essentials;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static me.gacekmpl2.gacekskyblockmanger.essentials.Debug.log;

public class ConfigUtils {

    public static String prefix = "&a&lSKYBLOCK &f»";
    public static String ACprefix = "&7[&c&lAC&7]";
    public static String ACnickcolor = "&c";
    public static String ACtextcolor = "&7»";
    public static String YTbroadcast = "&7Zapraszamy na &c&lLIVE! &8[KLIKNIJ TUTAJ]";
    public static String YTbroadcastHover = "&7Kliknij tutaj, aby otworzyć!";

    public static void loadconfig() throws IOException {
        YamlConfiguration config = load("config");

        assert config != null;
        prefix = config.getString("sbmanager.prefix");
        ACprefix = config.getString("sbmanager.acprefix");
        ACnickcolor = config.getString("sbmanager.acnickcolor");
        ACtextcolor = config.getString("sbmanager.actextcolor");
        YTbroadcast = config.getString("sbmanager.ytbroadcast");
        YTbroadcastHover = config.getString("sbmanager.ytbroadcasthover");
    }

    public static YamlConfiguration load(String configName) throws IOException {

        File file = new File("plugins/" + File.separator + "GacekSkyblockManger", configName + ".yml");

        if (file.exists()) {
            YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
            if (yaml.getValues(false).isEmpty()) {
                log("File configuration empty.");
                setValues().save(file);
                return yaml;
            }
            try {
                yaml.load(file);
                return yaml;
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
                return null;
            }

        } else {
            setValues().save(file);
            return setValues();
        }
    }

    public static YamlConfiguration setValues() {
        YamlConfiguration yaml = new YamlConfiguration();
        yaml.set("sbmanager.prefix", prefix);
        yaml.set("sbmanager.acprefix", ACprefix);
        yaml.set("sbmanager.acnickcolor", ACnickcolor);
        yaml.set("sbmanager.actextcolor", ACtextcolor);
        yaml.set("sbmanager.ytbroadcast", YTbroadcast);
        yaml.set("sbmanager.ytbroadcasthover", YTbroadcastHover);
        return yaml;
    }
}
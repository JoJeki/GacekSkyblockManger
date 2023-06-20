package me.gacekmpl2.gacekskyblockmanger.essentials;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;

public class ConfigLoad {

    public static String globalprefix = "&a&lSKYBLOCK &f»";
    public static String prefix = "&7[&c&lAC&7]";
    public static String nickcolor = "&c";
    public static String textcolor = "&7»";
    public static String ytmessage = "&7Zapraszamy na &c&lLIVE&7: &8[LINK]";
    public static String hoverytmessage = "&7Kliknij tutaj, aby otworzyć!";

    public static void loadconfig() throws IOException {
        YamlConfiguration config = Configs.load("config");

        assert config != null;

        globalprefix = config.getString("sbmanager.globalprefix");
        prefix = config.getString("sbmanager.prefix");
        nickcolor = config.getString("sbmanager.nickcolor");
        textcolor = config.getString("sbmanager.textcolor");
        ytmessage = config.getString("sbmanager.ytmessage");
        hoverytmessage = config.getString("sbmanager.hoverytmessage");

    }
}
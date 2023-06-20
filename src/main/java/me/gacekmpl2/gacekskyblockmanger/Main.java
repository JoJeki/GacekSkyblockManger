package me.gacekmpl2.gacekskyblockmanger;

import me.gacekmpl2.gacekskyblockmanger.commands.AdminChatCommand;
import me.gacekmpl2.gacekskyblockmanger.commands.GSkyBlockCommand;
import me.gacekmpl2.gacekskyblockmanger.essentials.ConfigLoad;
import me.gacekmpl2.gacekskyblockmanger.essentials.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("[GacekSkyblockManager] Plugin enabled.");

        Objects.requireNonNull(getCommand("adminchat")).setExecutor(new AdminChatCommand());
        Objects.requireNonNull(getCommand("gskyblock")).setExecutor(new GSkyBlockCommand());

        Objects.requireNonNull(getCommand("gskyblock")).setTabCompleter(new TabCompleter());

        try {
            ConfigLoad.loadconfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {

        getLogger().info("[GacekSkyblockManager] Plugin disabled.");

    }

    public static Main getInstance() {
        return instance;
    }
}
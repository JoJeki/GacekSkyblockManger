package me.gacekmpl2.gacekskyblockmanger;

import me.gacekmpl2.gacekskyblockmanger.commands.AdminChatCommand;
import me.gacekmpl2.gacekskyblockmanger.commands.ReloadCommand;
import me.gacekmpl2.gacekskyblockmanger.essentials.ConfigLoad;
import me.gacekmpl2.gacekskyblockmanger.essentials.ConfigSave;
import me.gacekmpl2.gacekskyblockmanger.essentials.ConfigUtils;
import me.gacekmpl2.gacekskyblockmanger.essentials.TabCompliter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.MemorySection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;

    private static Main plugins;

    @Override
    public void onEnable() {
        plugins = this;
        instance = this;

        getLogger().info("Plugin sie wlaczyl");
        getCommand("adminchat").setExecutor(new AdminChatCommand());
        getCommand("GSkyblock").setExecutor((CommandExecutor) new ReloadCommand());
        getCommand("GSkyblock").setTabCompleter((TabCompleter) new TabCompliter());
        ConfigLoad.loadAll();
    }

    @Override
    public void onDisable() {
        ConfigSave.saveAll();
    }

    public static Main getInstance() {
        return instance;
    }

    public static Main getPlugin() {
        return plugins;
    }
}
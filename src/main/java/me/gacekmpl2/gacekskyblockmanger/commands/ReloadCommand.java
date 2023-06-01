package me.gacekmpl2.gacekskyblockmanger.commands;

import me.gacekmpl2.gacekskyblockmanger.PermissionStorage;
import me.gacekmpl2.gacekskyblockmanger.essentials.ChatUtils;
import me.gacekmpl2.gacekskyblockmanger.essentials.ConfigLoad;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(PermissionStorage.admCommands)) {
            ChatUtils.sendMessage(sender, "&cNie masz dostepu do tej komendy!");
            return true;
        }
        for (Player player : Bukkit.getOnlinePlayers())
            if (!player.hasPermission("skyblockmanager.command.admin")) {
                ChatUtils.sendMessage(sender, "&cNie masz dostepu do tej komendy!");
                return true;
            }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                ConfigLoad.loadAll();
                sender.sendMessage(ChatUtils.fixColor("&f&l[&a&lSky&2&lBlock&f&l] &aPrzeladowano"));
                return true;
            }
        }
        return true;
    }
}
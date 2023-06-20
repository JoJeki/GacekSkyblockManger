package me.gacekmpl2.gacekskyblockmanger.commands;

import me.gacekmpl2.gacekskyblockmanger.PermissionStorage;
import me.gacekmpl2.gacekskyblockmanger.essentials.ChatUtils;
import me.gacekmpl2.gacekskyblockmanger.essentials.Config;
import me.gacekmpl2.gacekskyblockmanger.essentials.Debug;
import me.gacekmpl2.gacekskyblockmanger.essentials.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class AdminChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        if(!sender.hasPermission("skyblockmanager.adminchat")){
            ChatUtils.sendMessage(sender, "&cNie masz dostepu do tej komendy!");
            return true;
        }
        if (!sender.hasPermission(PermissionStorage.admminchatCommands)) {
            ChatUtils.sendMessage(sender, "&cNie masz dostepu do tej komendy!");
            return true;
        }

        if(args.length >= 1){
            String name;

            if(sender instanceof ConsoleCommandSender) {
                name = "Konsola";
            }
            else {
                name = sender.getName();
            }

            for(Player target : Bukkit.getOnlinePlayers()){
                if(target.hasPermission("skyblockmanager.adminchat")){
                    target.sendMessage(ChatUtils.fixColor(Config.prefix + Config.nickcolor + name + Config.textcolor));
                }
            }

            return true;
        }

        ChatUtils.sendMessage(sender,("&7/" + label + " <wiadomosc>"));
        return true;
    }
}

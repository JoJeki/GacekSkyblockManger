package me.gacekmpl2.gacekskyblockmanger.commands;

import me.gacekmpl2.gacekskyblockmanger.essentials.ChatUtils;
import me.gacekmpl2.gacekskyblockmanger.essentials.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {


        if(!sender.hasPermission("skyblockmanager.adminchat")){
            ChatUtils.sendMessage(sender, "&cBrak uprawnień!");
            return true;
        }

        if(args.length >= 1){
            StringBuilder ach = new StringBuilder();
            String name;

            for (String key : args) {
                ach.append(key + " ");
            }

            if(sender instanceof ConsoleCommandSender) {
                name = "KONSOLA";
            }
            else {
                name = sender.getName();
            }

            for(Player target : Bukkit.getOnlinePlayers()){
                if(target.hasPermission("skyblockmanager.adminchat")){
                    target.sendMessage(ChatUtils.fixColor(ConfigUtils.ACprefix + " " + ConfigUtils.ACnickcolor + name + " " + ConfigUtils.ACtextcolor +" "+ ach));
                }
            }

            return true;
        }

        ChatUtils.sendMessage(sender,("&7/" + label + " <wiadomosc>"));
        return true;
    }
}

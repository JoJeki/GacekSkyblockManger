package me.gacekmpl2.gacekskyblockmanger.commands;

import me.gacekmpl2.gacekskyblockmanger.PermissionStorage;
import me.gacekmpl2.gacekskyblockmanger.essentials.ChatUtils;
import me.gacekmpl2.gacekskyblockmanger.essentials.Debug;
import me.gacekmpl2.gacekskyblockmanger.essentials.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if(!player.hasPermission("skyblockmanager.adminchat")){
            ChatUtils.sendMessage(sender, "&cNie masz dostepu do tej komendy!");
            return true;
        }
        if (!sender.hasPermission(PermissionStorage.admminchatCommands)) {
            ChatUtils.sendMessage(sender, "&cNie masz dostepu do tej komendy!");
            return true;
        }

        if(args.length >= 1){

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("&7[&c&lAC&7] &c" + player.getName() + " &7» ");

            for (String arg : args) {
                stringBuilder.append(arg + " ");
            }

            for(Player target : Bukkit.getOnlinePlayers()){
                if(target.hasPermission("skyblockmanager.adminchat")){
                    target.sendMessage(ChatUtils.fixColor(stringBuilder.toString()));
                }
            }

            return true;
        }

        ChatUtils.sendMessage(sender,("&7/" + label + " <wiadomosc>"));
        return true;
    }
}

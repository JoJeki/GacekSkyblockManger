package me.gacekmpl2.gacekskyblockmanger.commands;

import me.gacekmpl2.gacekskyblockmanger.essentials.ChatUtils;
import me.gacekmpl2.gacekskyblockmanger.essentials.ConfigUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


public class GSkyBlockCommand implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (args.length == 1) {
            if (sender.hasPermission("skyblockmanager.command.reload")) {
                if (args[0].equalsIgnoreCase("reload")) {
                    try {
                        ConfigUtils.loadconfig();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    sender.sendMessage(ChatUtils.fixColor(ConfigUtils.prefix + " " + "&aPrzeładowano."));
                    return true;
                }
            } else {
                ChatUtils.sendMessage(sender, "&cBrak uprawnień!");
                return true;
            }

        }
        if (args.length == 2) {
            if (sender.hasPermission("skyblockmanager.command.livebroadcast")) {
                if (args[0].equalsIgnoreCase("ogloslive")) {
                    String url = args[1];
                    net.md_5.bungee.api.chat.TextComponent txt = new net.md_5.bungee.api.chat.TextComponent(ChatUtils.fixColor(ConfigUtils.prefix + " " + ConfigUtils.YTbroadcast));
                    txt.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatUtils.fixColor(ConfigUtils.YTbroadcastHover))));
                    txt.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage(" ");
                        player.spigot().sendMessage(txt);
                        player.sendMessage(" ");

                    }
                }
            } else {
                ChatUtils.sendMessage(sender, "&cBrak uprawnień!");
                return true;
            }
        }

        return true;
    }
}
package me.gacekmpl2.gacekskyblockmanger.essentials;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtils {


    /**
     * Changes & to minecraft colors
     *
     * @param message Message to fix
     * @return Returns ready message
     */
    public static String fixColor(String message) {
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void sendMessage(Player player, String message){
        player.sendMessage(fixColor(ConfigLoad.globalprefix + message));
    }
    public static void sendMessage(CommandSender player, String message){
        player.sendMessage(fixColor(ConfigLoad.globalprefix + message));
    }


}

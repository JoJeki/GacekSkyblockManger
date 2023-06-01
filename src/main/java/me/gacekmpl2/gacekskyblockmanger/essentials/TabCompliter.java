package me.gacekmpl2.gacekskyblockmanger.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompliter implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("GSkyblock")) {
            List<String> a = new ArrayList<>();
            if (args.length == 1) {
                a.add("reload");
            }
            return a;
        }
        return null;
    }
}

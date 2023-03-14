package org.bettermobs.betterutilities.Commands.SubCommands;

import org.bettermobs.betterutilities.Utils.Permissions.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Reload {
    public static boolean use(Plugin plugin, Permissions permissions, String commandPrefix, CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.hasPermission(permissions.getPermission("reload")))
            return false;
        plugin.reloadConfig();
        commandSender.sendMessage(ChatColor.DARK_GREEN + "Reloaded Plugin!");
        return true;
    }
}

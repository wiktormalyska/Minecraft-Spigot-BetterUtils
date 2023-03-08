package org.bettermobs.betterutilities.Commands;

import org.bettermobs.betterutilities.Commands.SubCommands.Reload;
import org.bettermobs.betterutilities.Commands.SubCommands.Trashcan;
import org.bettermobs.betterutilities.Utils.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class MainCommand implements CommandExecutor {
    Plugin plugin;
    Permissions permissions;
    String commandPrefix;
    public MainCommand(Plugin plugin, Permissions permissions, String commandPrefix){
        this.plugin = plugin;
        this.permissions = permissions;
        this.commandPrefix = commandPrefix+" ";
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length<1) {
            commandSender.sendMessage(ChatColor.RED + "Not enough arguments");
            return false;
        }
        switch (strings[0]) {
            case "trashcan":
                Trashcan.use(permissions,commandPrefix,commandSender,command,s,strings);
                break;
            case "trash":
                Trashcan.use(permissions,commandPrefix,commandSender,command,s,strings);
                break;
            case "reload":
                Reload.use(plugin, permissions, commandPrefix, commandSender, command, s,strings);
                break;
            default:
                commandSender.sendMessage( ChatColor.RED +"Not valid argument");
        }

        return true;
    }
}

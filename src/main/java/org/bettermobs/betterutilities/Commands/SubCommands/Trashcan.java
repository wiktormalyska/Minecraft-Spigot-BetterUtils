package org.bettermobs.betterutilities.Commands.SubCommands;

import org.bettermobs.betterutilities.Utils.Gui;
import org.bettermobs.betterutilities.Utils.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trashcan {
    public static boolean use(Permissions permissions, String commandPrefix, CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.hasPermission(permissions.getPermission("trashcan")))
            return false;
        Inventory trashcan = Gui.CreateGui(27, ChatColor.BOLD + "Trash Can");
        Player player = (Player) commandSender;
        player.openInventory(trashcan);

        return true;
    }
}


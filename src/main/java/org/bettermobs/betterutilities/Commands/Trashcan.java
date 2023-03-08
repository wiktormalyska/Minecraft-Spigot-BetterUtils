package org.bettermobs.betterutilities.Commands;

import org.bettermobs.betterutilities.Utils.Gui;
import org.bettermobs.betterutilities.Utils.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trashcan implements CommandExecutor {
    Permissions permissions;
    public Trashcan(Permissions permissions){
        this.permissions = permissions;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!s.equals("trash") && !s.equals("trashcan"))
            return false;
        if (!commandSender.hasPermission(permissions.getPermission("trashcan")))
            return false;
        Inventory trashcan = Gui.CreateGui(27, ChatColor.BOLD + "Trash Can");
        Player player = (Player) commandSender;
        player.openInventory(trashcan);

        return true;
    }
}


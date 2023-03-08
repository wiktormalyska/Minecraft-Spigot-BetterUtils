package org.bettermobs.betterutilities.Utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class Gui {
    public static Inventory CreateGui (int size, String title){
        Inventory gui = Bukkit.createInventory(null, size, title);
        return gui;
    }
}

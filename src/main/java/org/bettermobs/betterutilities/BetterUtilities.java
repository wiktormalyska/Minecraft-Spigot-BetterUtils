package org.bettermobs.betterutilities;

import org.bettermobs.betterutilities.Commands.Trashcan;
import org.bettermobs.betterutilities.Utils.Crafting.Slabs;
import org.bettermobs.betterutilities.Utils.Crafting.Sticks;
import org.bettermobs.betterutilities.Utils.Permissions;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class BetterUtilities extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now enabled!");

        Permissions permissions = new Permissions();

        permissions.addPermission("trashcan");
        this.getCommand("trashcan").setExecutor(new Trashcan(permissions));

        Slabs.AddAllSlabsRecipe(this);
        Sticks.AddAllStickRecipes(this);

    }

    @Override
    public void onDisable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now disabled!");

    }

}

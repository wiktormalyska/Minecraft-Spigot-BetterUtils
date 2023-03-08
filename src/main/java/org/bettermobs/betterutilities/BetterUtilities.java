package org.bettermobs.betterutilities;

import org.bettermobs.betterutilities.Commands.MainCommand;
import org.bettermobs.betterutilities.Commands.SubCommands.Reload;
import org.bettermobs.betterutilities.Commands.SubCommands.Trashcan;
import org.bettermobs.betterutilities.Utils.Crafting.Slabs;
import org.bettermobs.betterutilities.Utils.Crafting.Sticks;
import org.bettermobs.betterutilities.Utils.Permissions;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterUtilities extends JavaPlugin {
    String commandPrefix = "bu";
    @Override
    public void onEnable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now enabled!");

        this.saveDefaultConfig();

        Permissions permissions = new Permissions();

        permissions.addPermission("trashcan");
        permissions.addPermission("reload");

        this.getCommand("bu").setExecutor(new MainCommand(this, permissions, commandPrefix));



        Slabs.AddAllSlabsRecipe(this);
        Sticks.AddAllStickRecipes(this);

    }

    @Override
    public void onDisable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now disabled!");

    }

}

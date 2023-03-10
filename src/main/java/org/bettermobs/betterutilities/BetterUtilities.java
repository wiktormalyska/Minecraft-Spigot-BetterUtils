package org.bettermobs.betterutilities;

import lombok.SneakyThrows;
import org.bettermobs.betterutilities.Commands.MainCommand;
import org.bettermobs.betterutilities.Commands.SubCommands.Reload;
import org.bettermobs.betterutilities.Commands.SubCommands.Trashcan;
import org.bettermobs.betterutilities.Files.PermissionsFile;
import org.bettermobs.betterutilities.Mechanics.CropCollecting;
import org.bettermobs.betterutilities.Utils.Crafting.Slabs;
import org.bettermobs.betterutilities.Utils.Crafting.Sticks;
import org.bettermobs.betterutilities.Utils.Permissions;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

import java.io.IOException;

public final class BetterUtilities extends JavaPlugin {
    String commandPrefix = "bu";
    @SneakyThrows
    @Override
    public void onEnable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now enabled!");

        this.saveDefaultConfig();

        Permissions permissions = new Permissions();
        permissions.setNamespace("betterutilities");

        permissions.addPermission("trashcan");
        permissions.addPermission("reload");
        permissions.addPermission("cropcollect");

        this.getCommand("bu").setExecutor(new MainCommand(this, permissions, commandPrefix));

        getServer().getPluginManager().registerEvents(new CropCollecting(permissions),this);

        Slabs.AddAllSlabsRecipe(this);
        Sticks.AddAllStickRecipes(this);

        PermissionsFile permissionsFile= new PermissionsFile();
        permissionsFile.setPermissions(permissions);
        permissionsFile.write();

        int pluginId = 17912;
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now disabled!");

    }

}

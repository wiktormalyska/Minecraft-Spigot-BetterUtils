package org.bettermobs.betterutilities;

import lombok.SneakyThrows;
import org.bettermobs.betterutilities.Commands.MainCommand;
import org.bettermobs.betterutilities.Mechanics.Furnaces.FurnaceController;
import org.bettermobs.betterutilities.Mechanics.Furnaces.FurnaceEvents;
import org.bettermobs.betterutilities.Utils.Permissions.PermissionsFile;
import org.bettermobs.betterutilities.Mechanics.Crops.CropCollecting;
import org.bettermobs.betterutilities.Utils.Crafting.Slabs;
import org.bettermobs.betterutilities.Utils.Crafting.Sticks;
import org.bettermobs.betterutilities.Utils.Permissions.Permissions;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterUtilities extends JavaPlugin {
    String commandPrefix = "bu";
    @SneakyThrows
    @Override
    public void onEnable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now enabled!");
        this.saveDefaultConfig();

        //Permissions setup

        Permissions permissions = new Permissions();
        permissions.setNamespace("betterutilities");

        //Permissions adding
        permissions.addPermission("trashcan");
        permissions.addPermission("reload");
        permissions.addPermission("cropcollect");
        permissions.addPermission("ironfurnace");
        permissions.addPermission("goldfurnace");
        permissions.addPermission("diamondfurnace");
        permissions.addPermission("emeraldfurnace");
        permissions.addPermission("netheritefurnace");

        //Commands
        this.getCommand("bu").setExecutor(new MainCommand(this, permissions, commandPrefix));

        //Furnaces
        FurnaceController furnaceController = new FurnaceController();
        furnaceController.read();

        //Events
        getServer().getPluginManager().registerEvents(new CropCollecting(permissions),this);
        getServer().getPluginManager().registerEvents(new FurnaceEvents(furnaceController),this);

        //Adding recipes
        Slabs.AddAllSlabsRecipe(this);
        Sticks.AddAllStickRecipes(this);

        //Permissions generation
        PermissionsFile permissionsFile= new PermissionsFile();
        permissionsFile.setPermissions(permissions);
        permissionsFile.write();

        //Metrics
        int pluginId = 17912;
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now disabled!");

    }

}

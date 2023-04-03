package org.bettermobs.betterutilities;

import lombok.SneakyThrows;
import org.bettermobs.betterutilities.Commands.MainCommand;
import org.bettermobs.betterutilities.Utils.Permissions.PermissionsFile;
import org.bettermobs.betterutilities.Mechanics.Crops.CropCollecting;
import org.bettermobs.betterutilities.Utils.Crafting.Slabs;
import org.bettermobs.betterutilities.Utils.Crafting.Sticks;
import org.bettermobs.betterutilities.Utils.Permissions.Permissions;
import org.bstats.bukkit.Metrics;
import org.bukkit.enchantments.Enchantment;
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

        //Commands
        this.getCommand("bu").setExecutor(new MainCommand(this, permissions, commandPrefix));

        //Events
        getServer().getPluginManager().registerEvents(new CropCollecting(permissions),this);

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

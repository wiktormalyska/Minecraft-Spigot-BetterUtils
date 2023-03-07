package org.bettermobs.betterutilities;

import org.bettermobs.betterutilities.Utils.Crafting.Slabs;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now enabled!");
        Slabs.AddAllSlabsRecipe(this);

    }

    @Override
    public void onDisable() {
        this.getLogger().log(java.util.logging.Level.INFO, "BetterUtilities is now disabled!");

    }
}

package org.bettermobs.betterutilities.Utils.Crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Sticks {
    public static void SticksRecipe(Plugin plugin, Material ingredient) {
        NamespacedKey key = new NamespacedKey(plugin, "bettermobs."+ingredient.name()+".recipe");
        ItemStack sticks = new ItemStack(Material.STICK, 16);
        ItemMeta plankMeta = sticks.getItemMeta();
        sticks.setItemMeta(plankMeta);

        ShapedRecipe slabRecipe = new ShapedRecipe(key, sticks);
        slabRecipe.shape("X", "X");
        slabRecipe.setIngredient('X', ingredient);
        Bukkit.addRecipe(slabRecipe);

    }

    public static void AddAllStickRecipes(Plugin plugin){
        SticksRecipe(plugin, Material.OAK_LOG);
        SticksRecipe(plugin, Material.SPRUCE_LOG);
        SticksRecipe(plugin, Material.BIRCH_LOG);
        SticksRecipe(plugin, Material.JUNGLE_LOG);
        SticksRecipe(plugin, Material.ACACIA_LOG);
        SticksRecipe(plugin, Material.DARK_OAK_LOG);
        SticksRecipe(plugin, Material.MANGROVE_LOG);
        SticksRecipe(plugin, Material.CRIMSON_STEM);
        SticksRecipe(plugin, Material.WARPED_STEM);
    }
}

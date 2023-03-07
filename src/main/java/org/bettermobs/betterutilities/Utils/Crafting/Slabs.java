package org.bettermobs.betterutilities.Utils.Crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Slabs {
    public static void SlabsRecipe(Plugin plugin, Material ingredient, Material result) {
        NamespacedKey key = new NamespacedKey(plugin, "bettermobs."+ingredient.name()+".recipe");
        ItemStack plank = new ItemStack(result, 1);
        ItemMeta plankMeta = plank.getItemMeta();
        plank.setItemMeta(plankMeta);

        ShapedRecipe slabRecipe = new ShapedRecipe(key, plank);
        slabRecipe.shape("X", "X");
        slabRecipe.setIngredient('X', ingredient);
        Bukkit.addRecipe(slabRecipe);

    }

    public static void AddAllSlabsRecipe(Plugin plugin){
        Slabs.SlabsRecipe(plugin, Material.OAK_SLAB, Material.OAK_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.SPRUCE_SLAB, Material.SPRUCE_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.BIRCH_SLAB, Material.BIRCH_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.JUNGLE_SLAB, Material.JUNGLE_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.ACACIA_SLAB, Material.ACACIA_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.DARK_OAK_SLAB, Material.DARK_OAK_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.MANGROVE_SLAB, Material.MANGROVE_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.CRIMSON_SLAB, Material.CRIMSON_PLANKS);
        Slabs.SlabsRecipe(plugin, Material.WARPED_SLAB, Material.WARPED_PLANKS);
    }

}

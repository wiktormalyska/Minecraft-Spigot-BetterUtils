package org.bettermobs.betterutilities.Mechanics.Crops;

import org.bettermobs.betterutilities.Utils.Permissions.Permissions;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CropCollecting implements Listener {
    Permissions permissions;
    public CropCollecting(Permissions permissions){
        this.permissions = permissions;
    }
    @EventHandler
    public void event (PlayerInteractEvent e) {
        ItemStack itemInMainHand = e.getPlayer().getInventory().getItemInMainHand();
        if (!e.getPlayer().hasPermission(permissions.getPermission("cropcollect"))) return; //permission check
        if (itemInMainHand.getType() == Material.AIR || e.getClickedBlock()== null) return; //if player is not holding anything or if player is not clicking a block
        if (!toolsList().contains(itemInMainHand.getType()) || !cropsList().contains(e.getClickedBlock().getType())) return; //if player is not holding a hoe or if player is not clicking a crop
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return; //if player is not right-clicking
        if (e.getClickedBlock().getBlockData() instanceof Ageable) {
            Ageable ageable = (Ageable) e.getClickedBlock().getBlockData();
            if (ageable.getAge() != ageable.getMaximumAge()) return; //if crop is not fully grown
        }

        Block block = e.getClickedBlock();
        Collection<ItemStack> drops = block.getDrops(itemInMainHand);
        Location location = block.getLocation();
        CropsController cropsController = new CropsController();
        cropsController.setBlockType(block.getType());
        cropsController.setClickLocation(location);
        cropsController.add3x3();
        cropsController.setAgeToZero();
        Damageable itemInMainHandDamage = (Damageable) itemInMainHand.getItemMeta();
        cropsController.drop3x3(drops);
        cropsController.giveDamage(itemInMainHandDamage, itemInMainHandDamage.getDamage());
        e.getPlayer().getInventory().getItemInMainHand().setItemMeta(itemInMainHandDamage);
        e.getPlayer().playSound(e.getPlayer(), "minecraft:block.grass.break", 1.0f, 1.25f);
        if (itemInMainHandDamage.getDamage()>=itemInMainHand.getType().getMaxDurability()) {
            e.getPlayer().getInventory().setItemInMainHand(null);
            e.getPlayer().playSound(e.getPlayer(), "minecraft:entity.item.break", 1.0f, 1.0f);
        }
    }



    public List<Material> cropsList (){
        List<Material> crops = new ArrayList<>();
        crops.add(Material.POTATOES);
        crops.add(Material.BEETROOTS);
        crops.add(Material.CARROTS);
        crops.add(Material.NETHER_WART);
        crops.add(Material.WHEAT);

        return crops;
    }

    public List<Material> toolsList(){
        List<Material> tools = new ArrayList<>();
        tools.add(Material.WOODEN_HOE);
        tools.add(Material.STONE_HOE);
        tools.add(Material.IRON_HOE);
        tools.add(Material.GOLDEN_HOE);
        tools.add(Material.DIAMOND_HOE);
        tools.add(Material.NETHERITE_HOE);

        return tools;
    }



}

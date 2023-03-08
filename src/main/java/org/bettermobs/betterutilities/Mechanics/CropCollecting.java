package org.bettermobs.betterutilities.Mechanics;

import org.bettermobs.betterutilities.Utils.Permissions;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

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
            if(toolsList().contains(e.getPlayer().getInventory().getItemInMainHand().getType())){

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

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

import java.util.ArrayList;
import java.util.List;

public class CropCollecting implements Listener {
    Permissions permissions;
    public CropCollecting(Permissions permissions){
        this.permissions = permissions;
    }
    @EventHandler
    public boolean event (PlayerInteractEvent e) {
        if (!e.getPlayer().hasPermission(permissions.getPermission("cropcollect"))){
            e.getPlayer().sendMessage("You do not have permissions");
            return false;
        }
        if (e.getClickedBlock()==null){
            e.getPlayer().sendMessage("gownosd");
            return false;
        }
        if (e.getPlayer().getItemInUse()==null){
            e.getPlayer().sendMessage("gsdqsdowno");
            return false;
        }

        if (!cropsList().contains(e.getClickedBlock().getType())){
            e.getPlayer().sendMessage("gowno");
            return false;
    }
        if (!toolsList().contains(e.getPlayer().getItemInUse().getType())){
            e.getPlayer().sendMessage("item do dupy");
            return false;
        }

        Block interactedBlock = e.getClickedBlock();
        Ageable blockData = (Ageable)interactedBlock.getBlockData();
        Material blockType = blockData.getMaterial();
        Location blockLocation = interactedBlock.getLocation();
        e.getPlayer().sendMessage(blockData.getAge()+" "+blockData.getMaximumAge());

        if (blockData.getAge() != blockData.getMaximumAge())
            return false;

        interactedBlock.breakNaturally();
        Block newBlock = blockLocation.getBlock();
        newBlock.setType(blockType);
        Ageable newBlockAgeable = (Ageable)newBlock.getBlockData();
        newBlockAgeable.setAge(0);
        newBlock.setBlockData(newBlockAgeable);


        return true;
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

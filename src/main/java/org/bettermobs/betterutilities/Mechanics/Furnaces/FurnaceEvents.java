package org.bettermobs.betterutilities.Mechanics.Furnaces;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;


public class FurnaceEvents implements Listener {
    public FurnaceEvents(FurnaceController furnaceController) {
        this.furnaceController = furnaceController;
    }

    FurnaceController furnaceController;

    FurnacesList furnacesList = furnaceController.getFurnacesList();

    @EventHandler
    public void onFurnacePlace(BlockPlaceEvent e) {
        if (!e.getBlock().getType().equals(Material.FURNACE)) return; // If the block placed is not a furnace, return.
        String displayName = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        e.getPlayer().sendMessage(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName());

        // Add furnace to Controller
        Location blockLocation = e.getBlock().getLocation();
        String furnaceType = FurnaceData.getFurnaceType(displayName);
        String world = blockLocation.getWorld().getName();
        int x = blockLocation.getBlockX();
        int y = blockLocation.getBlockY();
        int z = blockLocation.getBlockZ();
        FurnaceData furnaceData = new FurnaceData(furnaceType, world, x, y, z);
        furnaceController.addFurnace(furnaceData);

    }
    public void onFurnaceBreak(BlockBreakEvent e){
        if (!e.getBlock().getType().equals(Material.FURNACE)) return; // If the block broken is not a furnace, return.
        String displayName = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        String furnaceType = FurnaceData.getFurnaceType(displayName);
        if (furnaceType.equals("NONE")) return; // If the furnace type is null, return.

        Location blockLocation = e.getBlock().getLocation();
        String world = blockLocation.getWorld().getName();
        int x = blockLocation.getBlockX();
        int y = blockLocation.getBlockY();
        int z = blockLocation.getBlockZ();
        FurnaceData furnaceData = new FurnaceData(furnaceType, world, x, y, z);

        if (!furnaceController.containsFurnace(furnaceData)) return; // If the furnace is not in the controller list, return.
        furnaceController.removeFurnace(furnaceData); // Remove furnace from controller list.

        e.setDropItems(false);
        ItemStack furnaceItem = new ItemStack(Material.FURNACE);
        furnaceItem.getItemMeta().setDisplayName(FurnaceData.getFurnaceName(furnaceType));
        e.getPlayer().getInventory().addItem(furnaceItem);

    }

}

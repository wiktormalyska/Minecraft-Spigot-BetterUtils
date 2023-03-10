package org.bettermobs.betterutilities.Mechanics;

import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CropsController {

    List<Location> locationList= new ArrayList<>();
    @Setter
    Material blockType;
    @Setter
    Location clickLocation;
    int damage = 0;

    public void setAgeToZero(){
        for (Location location : locationList) {
            if (!location.getBlock().getType().equals(blockType)) continue;
            Ageable blockData = (Ageable) location.getBlock().getBlockData();
            if (blockData.getAge() != blockData.getMaximumAge()) continue;
            damage++;
            blockData.setAge(0);
            location.getBlock().setBlockData(blockData);
        }
    }

    public void giveDamage(Damageable dmg, int oldDamage){
        dmg.setDamage(damage+oldDamage);
        damage = 0;
    }

    public void drop3x3(Collection<ItemStack> drops){
        for (ItemStack drop : drops) {
            for (int i = 0; i < damage; i++) {
                clickLocation.getWorld().dropItemNaturally(clickLocation, drop);
            }
        }
    }



    public void add3x3(){
        Location one = new Location(clickLocation.getWorld(), clickLocation.getX()+1 , clickLocation.getY(), clickLocation.getZ()-1);
        Location two = new Location(clickLocation.getWorld(), clickLocation.getX()+1 , clickLocation.getY(), clickLocation.getZ());
        Location three = new Location(clickLocation.getWorld(), clickLocation.getX()+1, clickLocation.getY(), clickLocation.getZ()+1);
        Location four = new Location(clickLocation.getWorld(), clickLocation.getX() , clickLocation.getY(), clickLocation.getZ()-1);
        Location five = new Location(clickLocation.getWorld(), clickLocation.getX() , clickLocation.getY(), clickLocation.getZ()+1);
        Location six = new Location(clickLocation.getWorld(), clickLocation.getX()-1 , clickLocation.getY(), clickLocation.getZ()-1);
        Location seven = new Location(clickLocation.getWorld(), clickLocation.getX()-1 , clickLocation.getY(), clickLocation.getZ());
        Location eight = new Location(clickLocation.getWorld(), clickLocation.getX()-1 , clickLocation.getY(), clickLocation.getZ()+1);
        locationList.add(one);
        locationList.add(two);
        locationList.add(three);
        locationList.add(four);
        locationList.add(five);
        locationList.add(six);
        locationList.add(seven);
        locationList.add(eight);
        locationList.add(clickLocation);
    }
}

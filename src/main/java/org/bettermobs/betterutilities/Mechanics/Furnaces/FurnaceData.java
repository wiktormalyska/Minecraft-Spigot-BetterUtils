package org.bettermobs.betterutilities.Mechanics.Furnaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;

@AllArgsConstructor
public class FurnaceData {
    private String furnaceType;
    private String world;
    private int x, y, z;

    public static String getFurnaceType(String name) {
        switch (name) {
            case "&7&lIron Furnace":
                return "IRON";
            case "&6&lGold Furnace":
                return "GOLD";
            case "&b&lDiamond Furnace":
                return "DIAMOND";
            case "&a&lEmerald Furnace":
                return "EMERALD";
            case "&8&lNetherite Furnace":
                return "NETHERITE";
            default:
                return "NONE";
        }
    }

    public static String getFurnaceName(String type){
        switch (type) {
            case "IRON":
                return "&7&lIron Furnace";
            case "GOLD":
                return "&6&lGold Furnace";
            case "DIAMOND":
                return "&b&lDiamond Furnace";
            case "EMERALD":
                return "&a&lEmerald Furnace";
            case "NETHERITE":
                return "&8&lNetherite Furnace";
            default:
                return "NONE";
        }
    }
}

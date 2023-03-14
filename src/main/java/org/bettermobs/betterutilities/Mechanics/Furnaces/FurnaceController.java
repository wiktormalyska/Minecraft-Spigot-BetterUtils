package org.bettermobs.betterutilities.Mechanics.Furnaces;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class FurnaceController {
    @Getter
    FurnaceFileController furnaceFileController = new FurnaceFileController();
    @Getter
    FurnacesList furnacesList = new FurnacesList();
    public FurnaceController(){

    }

    public void addFurnace(FurnaceData furnaceData){
        furnacesList.addFurnace(furnaceData);
        save();
    }

    public void removeFurnace(FurnaceData furnaceData){
        furnacesList.removeFurnace(furnaceData);
        save();
    }

    public boolean containsFurnace(FurnaceData furnaceData){
        return furnacesList.getFurnaceList().contains(furnaceData);
    }

    public void save(){
        furnaceFileController.save(furnacesList);
    }

    public void read(){
        furnacesList = furnaceFileController.read();
    }
}

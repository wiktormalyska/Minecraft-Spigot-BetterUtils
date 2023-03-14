package org.bettermobs.betterutilities.Mechanics.Furnaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class FurnacesList {
    private List<FurnaceData> furnaceList;

    public FurnacesList(){
        furnaceList = new ArrayList<>();
    }

    public void addFurnace(FurnaceData furnaceData){
        furnaceList.add(furnaceData);
    }

    public void removeFurnace(FurnaceData furnaceData){
        furnaceList.remove(furnaceData);
    }
}

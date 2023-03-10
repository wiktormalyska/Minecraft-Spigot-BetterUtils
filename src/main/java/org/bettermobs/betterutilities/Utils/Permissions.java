package org.bettermobs.betterutilities.Utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permissions {
    Map<String, String> permissions = new HashMap<>();
    @Setter
    String namespace;

    public String getPermission(String usageName){
        return permissions.get(usageName);
    }

    public void addPermission(String usageName){
        permissions.put(usageName, namespace+"."+usageName.toLowerCase().replaceAll(" ", "."));
    }

    public String generatePermissionsString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Permissions:\n");
        for (String permission : permissions.values()) {
            stringBuilder.append(permission).append("\n");
        }
        return stringBuilder.toString();
    }
}

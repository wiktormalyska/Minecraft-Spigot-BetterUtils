package org.bettermobs.betterutilities.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permissions {
    Map<String, String> permissions = new HashMap<>();
    String namespace="";

    public String getPermission(String usageName){
        return permissions.get(usageName);
    }

    public void addPermission(String usageName){
        permissions.put(usageName, namespace+usageName.toLowerCase().replaceAll(" ", "."));
    }

    public void setNamespace(String namespace){
        this.namespace = namespace+".";
    }
}

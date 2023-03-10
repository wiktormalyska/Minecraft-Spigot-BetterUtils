package org.bettermobs.betterutilities.Files;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.bettermobs.betterutilities.Utils.Permissions;

import java.io.FileWriter;
import java.io.IOException;

public class PermissionsFile {
    FileWriter writer;

    @Setter
    Permissions permissions;

    public PermissionsFile() throws IOException {
        writer = new FileWriter("plugins/BetterUtilities/permissions.txt");
    }

    public void write() throws IOException {
        writer.write("");
        writer.write(permissions.generatePermissionsString());
        writer.close();
    }

}

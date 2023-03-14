package org.bettermobs.betterutilities.Mechanics.Furnaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import lombok.SneakyThrows;

import java.io.File;


public class FurnaceFileController {
    @SneakyThrows
    public void save(FurnacesList furnaceList) {
        ObjectMapper om = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        om.writeValue(new File("plugins/BetterUtilities/data/furnaces.yaml"), furnaceList);
    }
    @SneakyThrows
    public FurnacesList read(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(new File("plugins/BetterUtilities/data/furnaces.yaml"), FurnacesList.class);
    }
}

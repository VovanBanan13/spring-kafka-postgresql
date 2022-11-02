package ru.home.application.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.home.application.models.Item;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class JsonParser {
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public List<Item> parseJacksonFile(String jsonFile) throws IOException {
        File file = new File(jsonFile);

        return objectMapper.readValue(file, new TypeReference<>(){});
    }

    public List<Item> parseJackson(String jsonFile) throws IOException {

        return objectMapper.readValue(jsonFile, new TypeReference<>(){});
    }

}

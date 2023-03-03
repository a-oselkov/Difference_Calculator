package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String dataFromFile, String extension) throws IOException {
        ObjectMapper mapper = chooseParser(extension);
        return mapper.readValue(dataFromFile, new TypeReference<Map<String, Object>>() { });
    }

    private static ObjectMapper chooseParser(String extension) throws IOException {
        return switch (extension) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new YAMLMapper();
            default -> throw new IOException("File extension " + "'" + extension + "'"  + " not available");
        };
    }
}

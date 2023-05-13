package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String dataFromFile, String extension) throws JsonProcessingException {
        ObjectMapper mapper = chooseParser(extension);
        return mapper.readValue(dataFromFile, new TypeReference<Map<String, Object>>() {
        });
    }

    private static ObjectMapper chooseParser(String extension) {
        return switch (extension) {
            case "json" -> new JsonMapper();
            case "yml", "yaml" -> new YAMLMapper();
            default -> throw new RuntimeException("File extension " + "'" + extension + "'" + " not supported");

        };
    }
}

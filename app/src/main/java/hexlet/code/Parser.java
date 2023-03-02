package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String dataFromFile, String filePath) throws IOException {
        ObjectMapper mapper = chooseParser(filePath);
        return mapper.readValue(dataFromFile, new TypeReference<Map<String, Object>>() { });
    }

    private static ObjectMapper chooseParser(String filePath) {
        return switch (getFileType(filePath)) {
            case "yml", "yaml" -> new YAMLMapper();
            default -> new ObjectMapper();
        };
    }

    private static String getFileType(String filePath) {
        String[] split = filePath.split("\\.");
        return split[split.length - 1];
    }
}

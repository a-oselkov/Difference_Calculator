package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class Parser {

    public static Map<String, Object> dataToMap(String dataFromFile, Path filePath) throws IOException {
        ObjectMapper mapper = getFileType(filePath);
        return mapper.readValue(dataFromFile, new TypeReference<Map<String, Object>>() { });
    }

    private static ObjectMapper getFileType(Path filePath) {
        if (filePath.endsWith("json")) {
            return new ObjectMapper();
        } else {
            return new YAMLMapper();
        }
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> jsonToMap(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        Map<String, Object> data = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
        return data;
    }
    public static Map<String, Object> yamlToMap(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        Map<String, Object> data = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
        return data;
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static Map<String, Object> fileToMap(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String content = Files.readString(path);
        Map<String, Object> data = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
        return data;
    }
    public static String generate(String fistFilePath, String secondFilePath) throws IOException {
        String result;
        Map<String, Object> data1 = fileToMap(fistFilePath);
        Map<String, Object> data2 = fileToMap(secondFilePath);

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        result = "{\n";
        for (String key : keys) {
            if (!data1.containsKey(key)) {
                result += "  + " + key + ":" + " " + data2.get(key) + "\n";
            } else if (!data2.containsKey(key)) {
                result += "  - " + key + ":" + " " + data1.get(key) + "\n";
            } else if (data1.get(key).equals(data2.get(key))) {
                result += "    " + key + ":" + " " + data1.get(key) + "\n";
            } else {
                result += "  - " + key + ":" + " " + data1.get(key) + "\n"
                        + "  + " + key + ":" + " " + data2.get(key) + "\n";
            }
        }
        result += "}";
        return result;
    }
}

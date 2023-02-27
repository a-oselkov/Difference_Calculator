package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String fistFilePath, String secondFilePath) throws IOException {
        String result;
        Map<String, Object> data1 = Parser.yamlToMap(fistFilePath);
        Map<String, Object> data2 = Parser.yamlToMap(secondFilePath);

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

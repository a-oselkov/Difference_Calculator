package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String fistFilePath, String secondFilePath, String format) throws IOException {

        Map<String, Object> data1 = Parser.fileToMap(fistFilePath);
        Map<String, Object> data2 = Parser.fileToMap(secondFilePath);

        List<Map<String, Object>> differences = Differences.getDifferencesList(data1, data2);

        return Formatter.makeFormat(differences, format);
    }
    public static String generate(String fistFilePath, String secondFilePath) throws IOException {
        return generate(fistFilePath, secondFilePath, "stylish");
    }
}

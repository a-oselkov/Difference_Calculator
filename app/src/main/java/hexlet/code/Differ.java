package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {

        String dataFromFile1 = getData(filePath1);

        String dataFromFile2 = getData(filePath2);

        Map<String, Object> data1 = Parser.parse(dataFromFile1, filePath1);
        Map<String, Object> data2 = Parser.parse(dataFromFile2, filePath2);

        List<Map<String, Object>> differences = Differences.getDifferencesList(data1, data2);

        return Formatter.makeFormat(differences, format);
    }
    public static String generate(String fistFilePath, String secondFilePath) throws IOException {
        return generate(fistFilePath, secondFilePath, "stylish");
    }
    public static String getData(String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}


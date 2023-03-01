package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {

        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        String dataFromFile1 = Files.readString(path1);

        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        String dataFromFile2 = Files.readString(path2);


        Map<String, Object> data1 = Parser.dataToMap(dataFromFile1, path1);
        Map<String, Object> data2 = Parser.dataToMap(dataFromFile2, path2);

        List<Map<String, Object>> differences = Differences.getDifferencesList(data1, data2);

        return Formatter.makeFormat(differences, format);
    }
    public static String generate(String fistFilePath, String secondFilePath) throws IOException {
        return generate(fistFilePath, secondFilePath, "stylish");
    }
}

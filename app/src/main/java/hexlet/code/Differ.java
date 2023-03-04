package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> parsingDataFile1 = getData(filePath1);
        Map<String, Object> parsingDataFile2 = getData(filePath2);

        List<Map<String, Object>> differences = Differences.getDifferencesList(parsingDataFile1, parsingDataFile2);

        return Formatter.makeFormat(differences, format);
    }

    public static String generate(String fistFilePath, String secondFilePath) throws IOException {
        return generate(fistFilePath, secondFilePath, "stylish");
    }

    public static Map<String, Object> getData(String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        String dataFile = Files.readString(path);
        String extension = getFileExtension(filePath);

        return Parser.parse(dataFile, extension);
    }

    public static String getFileExtension(String filePath) {
        String[] split = filePath.split("\\.");
        return split[split.length - 1];
    }
}

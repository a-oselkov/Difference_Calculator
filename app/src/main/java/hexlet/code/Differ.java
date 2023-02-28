package hexlet.code;

import java.io.IOException;
import java.util.Map;

public class Differ {
    public static String generate(String fistFilePath, String secondFilePath, String format) throws IOException {

        Map<String, Object> data1 = Parser.fileToMap(fistFilePath);
        Map<String, Object> data2 = Parser.fileToMap(secondFilePath);

        return Formatter.chooseFormat(Differences.getDifferencesList(data1, data2), format);
    }
}

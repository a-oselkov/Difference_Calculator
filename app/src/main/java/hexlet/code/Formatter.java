package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String mapToString(Map<String, Object> map) {
        return " " + map.get("key") + ": " + map.get("value") + "\n";
    }

    public static String chooseFormat(List<Map<String, Object>> differenceList, String format) throws IOException {
        switch (format) {
            case "stylish":
                return Stylish.toStylishFormat(differenceList);
//            case "plain":
//                return Plain.toPlainFormat(differenceList);
            case "json":
                return Json.toJsonFormat(differenceList);
            default:
                System.out.println("Format" + format + "is not correct!");
        }
        return Stylish.toStylishFormat(differenceList);
    }
}


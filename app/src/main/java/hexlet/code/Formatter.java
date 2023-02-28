package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {

    public static String mapToString(Map<String, Object> map) {
        return " " + map.get("key") + ": " + map.get("value") + "\n";
    }

    public static String chooseFormat(List<Map<String, Object>> differencesList, String format) throws IOException {
        switch (format) {
            case "plain" -> {
                return Plain.toPlainFormat(differencesList);
            }
            case "json" -> {
                return Json.toJsonFormat(differencesList);
            }
            default -> System.out.println("Format " + "\"" + format + "\"" + " is not supported." + "\n"
                    + "Default format is \"stylish\":");
        }
        return Stylish.toStylishFormat(differencesList);
    }
}


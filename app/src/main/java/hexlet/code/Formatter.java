package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String makeFormat(List<Map<String, Object>> differencesList, String format) {
        return switch (format) {
            case "stylish" -> Stylish.toStylishFormat(differencesList);
            case "plain" -> Plain.toPlainFormat(differencesList);
            case "json" -> Json.toJsonFormat(differencesList);
            default -> "Format " + "\"" + format + "\"" + " is not supported." + "\n"
                    + "Default format is \"stylish\":" + "\n"
                    + Stylish.toStylishFormat(differencesList);
        };
    }
}


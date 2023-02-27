package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String mapToString(Map<String, Object> map) {
        return " " + map.get("key") + ": " + map.get("value") + "\n";
    }

    public static String toStylishFormat(List<Map<String, Object>> differenceList) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> map : differenceList) {
            switch (map.get("status").toString()) {
                case "added" -> {
                    result.append("  +").append(mapToString(map));
                }
                case "removed" -> {
                    result.append("  -").append(mapToString(map));
                }
                case "unchanged" -> {
                    result.append("   ").append(mapToString(map));
                }
                default -> {
                    result.append("  -").append(mapToString(map));
                    result.append("  + ").append(map.get("key")).append(": ").append(map.get("valueNew")).append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}

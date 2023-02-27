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
            if (map.get("status").equals("added")) {
                result.append("  +").append(" ").append(map.get("key")).append(": ")
                        .append(map.get("value")).append("\n");
            } else if (map.get("status").equals("removed")) {
                result.append("  -").append(" ").append(map.get("key")).append(": ")
                        .append(map.get("value")).append("\n");
            } else if (map.get("status").equals("unchanged")) {
                result.append("   ").append(" ").append(map.get("key")).append(": ")
                        .append(map.get("value")).append("\n");
            } else {
                result.append("  -").append(" ").append(map.get("key")).append(": ")
                        .append(map.get("value")).append("\n");
                result.append("  + ").append(map.get("key")).append(": ").append(map.get("valueNew")).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}

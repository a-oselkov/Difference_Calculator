package hexlet.code.formatters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String valueType(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }

    public static String toPlainFormat(List<Map<String, Object>> differenceList) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> map : differenceList) {

            String begin = "Property " + "'" + map.get("key") + "'" + " was " + map.get("status");

            switch (map.get("status").toString()) {
                case "added" -> {
                    result.append(begin).append(" with value: ").append(valueType(map.get("value"))).append("\n");
                }
                case "removed" -> {
                    result.append(begin).append("\n");
                }
                case "updated" -> {
                    result.append(begin).append(". From ").append(valueType(map.get("value")))
                            .append(" to ").append(valueType(map.get("updatedValue"))).append("\n");
                }
                default -> { }
            }
        }
        return result.toString().trim();
    }
}


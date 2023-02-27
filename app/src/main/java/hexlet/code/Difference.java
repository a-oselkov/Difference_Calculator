package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Difference {
    public static List<Map<String, Object>> getDifferenceList(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> differenceList = new ArrayList<>();

        String status;

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key : keys) {
            Map<String, Object> differenceMap = new HashMap<>();
            differenceMap.put("key", key);
            differenceMap.put("value", data1.get(key));
            differenceMap.put("valueNew", data2.get(key));
            differenceMap.put("status", "updated");
            if (!data1.containsKey(key)) {
                status = "added";
                differenceMap = Map.of("key", key, "value", data2.get(key), "status", status);
            } else if (!data2.containsKey(key)) {
                status = "removed";
                differenceMap = Map.of("key", key, "value", data1.get(key), "status", status);
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                status = "unchanged";
                differenceMap = Map.of("key", key, "value", data1.get(key), "status", status);
            }
            differenceList.add(differenceMap);
        }
        return differenceList;
    }
}


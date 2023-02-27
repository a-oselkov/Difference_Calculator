package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Difference {
    public static List<Map<String, Object>> getDifferenceList(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> differenceList = new ArrayList<>();

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key : keys) {
            Map<String, Object> differenceMap = new LinkedHashMap<>();
            differenceMap.put("key", key);
            differenceMap.put("value", data1.get(key));
            differenceMap.put("updatedValue", data2.get(key));
            differenceMap.put("status", "updated");

            if (!data1.containsKey(key)) {
                differenceMap.put("key", key);
                differenceMap.put("value", data2.get(key));
                differenceMap.put("status", "added");
            } else if (!data2.containsKey(key)) {
                differenceMap.put("key", key);
                differenceMap.put("value", data1.get(key));
                differenceMap.put("status", "removed");
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                differenceMap.put("key", key);
                differenceMap.put("value", data1.get(key));
                differenceMap.put("status", "unchanged");
            }
            differenceList.add(differenceMap);
        }
        return differenceList;
    }
}


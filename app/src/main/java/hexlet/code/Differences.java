package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Differences {
    public static List<Map<String, Object>> getDifferencesList(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> differencesList = new ArrayList<>();

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key : keys) {
            Map<String, Object> differencesMap = new LinkedHashMap<>();
            differencesMap.put("key", key);

            if (!data1.containsKey(key)) {
                differencesMap.put("value", data2.get(key));
                differencesMap.put("status", "added");
            } else if (!data2.containsKey(key)) {
                differencesMap.put("value", data1.get(key));
                differencesMap.put("status", "removed");
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                differencesMap.put("value", data1.get(key));
                differencesMap.put("status", "unchanged");
            } else {
                differencesMap.put("value", data1.get(key));
                differencesMap.put("updatedValue", data2.get(key));
                differencesMap.put("status", "updated");
            }
            differencesList.add(differencesMap);
        }
        return differencesList;
    }
}


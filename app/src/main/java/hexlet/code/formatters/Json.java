package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String toJsonFormat(List<Map<String, Object>> differenceList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(differenceList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


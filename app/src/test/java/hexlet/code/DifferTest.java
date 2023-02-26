package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


class DifferTest {

    @Test
    void fileToMapTest() throws IOException {
        Map<String, Object> actual = Differ.fileToMap("2.json");
        Map<String, Object> expecting = new HashMap<>(
                Map.of("timeout", 20, "verbose", true, "host", "hexlet.io")
        );
        assertThat(actual).isEqualTo(expecting);
    }

    @Test
    void generateTest() throws IOException {
        String actual = Differ.generate("1.json", "2.json");
        String expecting = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        assertThat(actual).isEqualTo(expecting);
    }
}

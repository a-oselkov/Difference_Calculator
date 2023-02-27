package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

class DifferTest {

//    @Test
//    void fileToMapTest() throws IOException {
//        Map<String, Object> actual = Parser.jsonToMap("2.json");
//        Map<String, Object> expecting = new HashMap<>(
//                Map.of("timeout", 20, "verbose", true, "host", "hexlet.io")
//        );
//        assertThat(actual).isEqualTo(expecting);
//    }

    @Test
    void generateJsonTest() throws IOException {
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
    @Test
    void generateYamlTest() throws IOException {
        String actual = Differ.generate("3.yaml", "4.yaml");
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

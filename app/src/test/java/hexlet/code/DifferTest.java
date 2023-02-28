package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {
    private final String jsonFile1 = "src/test/resources/file1.json";
    private final String jsonFile2 = "src/test/resources/file2.json";
    private final String yamlFile1 = "src/test/resources/file1.yaml";
    private final String yamlFile2 = "src/test/resources/file2.yaml";
    private final Path stylishPath = Paths.get("src/test/resources/stylishTest.txt").toAbsolutePath().normalize();
    private final Path plainPath = Paths.get("src/test/resources/plainTest.txt").toAbsolutePath().normalize();
    private final Path jsonPath = Paths.get("src/test/resources/jsonTest.txt").toAbsolutePath().normalize();

    @Test
    void fileToMapTest() throws IOException {
//        Map<String, Object> actual = Parser.jsonToMap("2.json");
//        Map<String, Object> expecting = new HashMap<>(
//                Map.of("timeout", 20, "verbose", true, "host", "hexlet.io")
//        );
//        assertThat(actual).isEqualTo(expecting);
    }

    @Test
    void generateTest() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "abc");
        String expected = Files.readString(stylishPath).trim();
        assertEquals(expected, actual);
    }
    @Test
    void generateTest1() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "stylish");
        String expected = Files.readString(stylishPath).trim();
        assertEquals(expected, actual);
    }
    @Test
    void generateTest2() throws IOException {
        String actual = Differ.generate(yamlFile1, yamlFile2, "stylish");
        String expected = Files.readString(stylishPath).trim();
        assertEquals(expected, actual);
    }
    @Test
    void generateTest3() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "plain");
        String expected = Files.readString(plainPath).trim();
        assertEquals(expected, actual);
    }
    @Test
    void generateTest4() throws IOException {
        String actual = Differ.generate(yamlFile1, yamlFile2, "plain");
        String expected = Files.readString(plainPath).trim();
        assertEquals(expected, actual);
    }
    @Test
    void generateTest5() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "json");
        String expected = Files.readString(jsonPath).trim();
        assertEquals(expected, actual);
    }
    @Test
    void generateTest6() throws IOException {
        String actual = Differ.generate(yamlFile1, yamlFile2, "json");
        String expected = Files.readString(jsonPath).trim();
        assertEquals(expected, actual);
    }
}


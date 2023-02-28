package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
    private final Path plainPath = Paths.get("plainTest").toAbsolutePath().normalize();
    private final Path jsonPath = Paths.get("src/test/resources/jsonTest.txt").toAbsolutePath().normalize();

//    @Test
//    void fileToMapTest() throws IOException {
//        Map<String, Object> actual = Parser.jsonToMap("2.json");
//        Map<String, Object> expecting = new HashMap<>(
//                Map.of("timeout", 20, "verbose", true, "host", "hexlet.io")
//        );
//        assertThat(actual).isEqualTo(expecting);
//    }

    @Test
    void generateStylishTest1() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "stylish") + "\n";
        String expected = Files.readString(stylishPath);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void generateStylishTest2() throws IOException {
        String actual = Differ.generate(yamlFile1, yamlFile2, "stylish") + "\n";
        String expected = Files.readString(stylishPath);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void generateStylishTest3() throws IOException {
//        String actual = Differ.generate(jsonFile1, jsonFile2, "plain") + "\n";
//        String expected = Files.readString(plainPath);
//        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void generateStylishTest4() throws IOException {
//        String actual = Differ.generate(yamlFile1, yamlFile2, "plain") + "\n";
//        String expected = Files.readString(plainPath);
//        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void generateStylishTest5() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "json") + "\n";
        String expected = Files.readString(jsonPath);
        assertEquals(expected, actual);
        //assertThat(actual).isEqualTo(expected);
    }
    @Test
    void generateStylishTest6() throws IOException {
        String actual = Differ.generate(yamlFile1, yamlFile2, "json") + "\n";
        String expected = Files.readString(jsonPath);
        assertThat(actual).isEqualTo(expected);
    }
}


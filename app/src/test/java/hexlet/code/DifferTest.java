package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {
    private final String jsonFile1 = "src/test/resources/file1.json";
    private final String jsonFile2 = "src/test/resources/file2.json";
    private static final Path stylishPath = Paths.get("src/test/resources/stylish-test.txt")
            .toAbsolutePath().normalize();
    private static final Path plainPath = Paths.get("src/test/resources/plain-test.txt")
            .toAbsolutePath().normalize();
    private static final Path jsonPath = Paths.get("src/test/resources/json-test.txt")
            .toAbsolutePath().normalize();
    private static String stylish;
    private static String plain;
    private static String json;
    @BeforeAll
    static void readResult () throws IOException {
        stylish = Files.readString(stylishPath).trim();
        plain = Files.readString(plainPath).trim();
        json = Files.readString(jsonPath).trim();
    }
    @Test
    void generateTest1() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2);
        assertEquals(stylish, actual);
    }
    @Test
    void generateTest2() throws IOException {
        String yamlFile1 = "src/test/resources/file1.yaml";
        String yamlFile2 = "src/test/resources/file2.yaml";
        String actual = Differ.generate(yamlFile1, yamlFile2);
        assertEquals(stylish, actual);
    }
    @Test
    void generateTest3() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "plain");
        assertEquals(plain, actual);
    }
    @Test
    void generateTest4() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2, "json");
        assertEquals(json, actual);
    }
}


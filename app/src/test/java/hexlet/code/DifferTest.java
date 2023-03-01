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
    private final String yamlFile1 = "src/test/resources/file1.yaml";
    private final String yamlFile2 = "src/test/resources/file2.yaml";
    private static final Path STYLISPATH = Paths.get("src/test/resources/stylish-test.txt")
            .toAbsolutePath().normalize();
    private static final Path PLAINPATH = Paths.get("src/test/resources/plain-test.txt")
            .toAbsolutePath().normalize();
    private static final Path JSONPATH = Paths.get("src/test/resources/json-test.txt")
            .toAbsolutePath().normalize();
    private static String stylish;
    private static String plain;
    private static String json;

    @BeforeAll
    static void readResult() throws IOException {
        stylish = Files.readString(STYLISPATH).trim();
        plain = Files.readString(PLAINPATH).trim();
        json = Files.readString(JSONPATH).trim();
    }

    @Test
    void generateTest1() throws IOException {
        String actual = Differ.generate(jsonFile1, jsonFile2);
        assertEquals(stylish, actual);
    }

    @Test
    void generateTest2() throws IOException {
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


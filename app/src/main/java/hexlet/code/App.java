package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file",
            defaultValue = "src/test/resources/file1.json")
    private String filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file",
            defaultValue = "src/test/resources/file2.json")
    private String filepath2;

    @Override
    public Integer call() throws IOException {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }
}

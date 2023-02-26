package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format = "stylish";
    @Parameters(paramLabel = "filepath1", description = "path to first file", defaultValue = "1.json")
    private String filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file", defaultValue = "2.json")
    private String filepath2;

    @Override
    public String call() throws IOException {
        System.out.println(Differ.generate(filepath1, filepath2));
        return "";
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }
}

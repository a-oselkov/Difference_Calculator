package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

    @Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
            description = "Compares two configuration files and shows a difference.")
    public class App implements Callable<String> {

        @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
        String format = "stylish";
        @Parameters(paramLabel = "filepath1", description = "path to first file")
        private File file1;
        @Parameters(paramLabel = "filepath2", description = "path to second file")
        private File file2;

        @Override
        public String call() {
            // The business logic of the command goes here...
            // In this case, code for generation of ASCII art graphics
            // (omitted for the sake of brevity).
            return "";
        }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }
}

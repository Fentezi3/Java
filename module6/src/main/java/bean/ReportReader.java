package bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReportReader {
    /**
     * Read each string from output file.
     *
     * @param argument path to file.
     * @return List with strings from file.
     * @throws IOException
     */
    public static List<String> readFromFile(String argument) throws IOException {
        return Files.lines(Paths.get(argument)).collect(Collectors.toList());
    }
}

package bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    private final static String OUTPUT_FILE = "src/main/resources/outputRammTree.txt";

    /**
     * Read each string from output file.
     *
     * @return List with strings from file.
     * @throws IOException
     */
    public static List<String> readFromFile() throws IOException {
            return Files.lines(Paths.get(OUTPUT_FILE)).collect(Collectors.toList());
    }

}

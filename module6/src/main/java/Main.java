import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private final static String DIR_PREFIX = "|----";
    private final static String FILE_PREFIX = "|   ";
    private final static String DEFAULT_INDENTATION = "   ";

    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("src/main/resources/outputRammTree.txt");
            printTree(0, new File("d:/Rammstein"), writer);
            writer.close();
            List<String> stringList = readFromFile();
            calculateDirectories(stringList);
            calculateFiles(stringList);
            calculateAverageTitlesLength(stringList);
            calculateAverageFilesAmountInDirectory(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printTree(int depth, File file, Writer writer) throws IOException {
        StringBuilder indentation = new StringBuilder();
        File[] files;
        for (int i = 0; i < depth; i++) {
            indentation.append(DEFAULT_INDENTATION);
        }
        if (file.isDirectory()) {
            writer.write(indentation + DIR_PREFIX + file.getName() + "\n");
            System.out.print(indentation + DIR_PREFIX + file.getName() + "\n");
        } else {
            writer.write(indentation + FILE_PREFIX + file.getName() + "\n");
            System.out.print(indentation + FILE_PREFIX + file.getName() + "\n");
        }
        if (file.isDirectory()) {
            files = file.listFiles();
            sortFileWrappers(Arrays.asList(files));
            for (File value : files) {
                printTree(depth + 1, value, writer);
            }
        }
    }

    private static void sortFileWrappers(List<File> childFiles) {
        childFiles.sort((file1, file2) -> {
            if ((file1.isFile() && file2.isFile())
                    || (file1.isDirectory() && file2.isDirectory())) {
                return file1.getName().compareTo(file2.getName());
            }
            if (file1.isFile() && file2.isDirectory()) {
                return -1;
            }
            if (file2.isFile() && file1.isDirectory()) {
                return 1;
            }
            return 0;
        });
    }

    public static List<String> readFromFile() throws IOException {
        return Files.lines(Paths.get("src/main/resources/outputRammTree.txt")).collect(Collectors.toList());
    }

    private static void calculateDirectories(List<String> stringList) {
        int directories = (int) stringList.stream()
                .filter(s -> s.contains(DIR_PREFIX)).count();
        System.out.println("Directories amount: " + directories);
    }

    private static void calculateFiles(List<String> stringList) {
        int files = (int) stringList.stream()
                .filter(s -> s.contains(FILE_PREFIX)).count();
        System.out.println("Files amount: " + files);
    }

    private static void calculateAverageTitlesLength(List<String> stringList) {
        List<Integer> list = new ArrayList<>();
        float sum = 0;
        float average;
        for (String string : stringList) {
            if (string.contains(FILE_PREFIX)) {
                Integer length = string.length() - FILE_PREFIX.length();
                list.add(length);
            }
        }
        for (int length : list) {
            sum += length;
        }
        average = sum / list.size();
        System.out.println("Average file name length: " + average);
    }

    private static void calculateAverageFilesAmountInDirectory(List<String> stringList) {
        List<Integer> counters = new ArrayList<>();
        float sum = 0;
        int fileCounter = 0;
        for (String line : stringList) {
            if (line.contains(DIR_PREFIX)) {
                counters.add(fileCounter);
                fileCounter = 0;
            }
            if (line.contains(FILE_PREFIX)) {
                fileCounter++;
            }
        }
        if (fileCounter > 0){
            counters.add(fileCounter);
        }
        for (int counter : counters) {
            sum += counter;
        }
        long withoutNull = counters.stream().
                filter(integer -> integer > 0).count();
        float average = sum / withoutNull;
        System.out.println("Average files in directory: " + average);
        System.out.println("Directions: " + withoutNull);
    }
}

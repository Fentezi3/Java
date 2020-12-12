package bean;

import writer.ReportWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DirectoriesScanner {
    public final static String DIR_PREFIX = "|----";
    public final static String FILE_PREFIX = "|   ";
    private final static String DEFAULT_INDENTATION = "   ";

    /**
     * This method scanning directory and writing results to file.
     *
     * @param depth  difference between directories levels.
     * @param file   path to directory
     * @param writer ReportWriter object
     * @throws IOException
     */
    public static void createReportInFile(int depth, File file, ReportWriter writer) throws IOException {
        StringBuilder indentation = new StringBuilder();
        File[] files;
        for (int i = 0; i < depth; i++) {
            indentation.append(DEFAULT_INDENTATION);
        }
        if (file.isDirectory()) {
            writer.writeLine(indentation + DIR_PREFIX + file.getName() + "\n");
        } else {
            writer.writeLine(indentation + FILE_PREFIX + file.getName() + "\n");
        }
        if (file.isDirectory()) {
            files = file.listFiles();
            sortFiles(Arrays.asList(files));
            for (File value : files) {
                createReportInFile(depth + 1, value, writer);
            }
        }
    }

    private static void sortFiles(List<File> childFiles) {
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
}

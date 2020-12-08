import bean.CalculationService;
import bean.DirectoriesScanner;
import bean.ReportReader;
import writer.ReportWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    /**
     * Create .txt file with direction tree from direction path, or read information from file
     * and calculate number files and directories {@link CalculationService} in this file
     *
     * @param args can contains path to .txt file {@link ReportReader#readFromFile(String)}
     *             or to directory {@link Main#print(ReportWriter, String)} (String)}
     */
    public static void main(String[] args) {
        List<String> stringList;
        String path = args[0];
        if (isArgumentAFile(path)) {
            try {
                stringList = ReportReader.readFromFile(path);
                Calculate(stringList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            readFilesAndWriteDirectoryTree(path);
        }
    }

    private static boolean isArgumentAFile(String path) {
        boolean bool = false;
        if (path.endsWith(".txt")) {
            bool = true;
        }

        return bool;
    }

    private static void readFilesAndWriteDirectoryTree(String path) {
        ReportWriter writer = new ReportWriter();
        print(writer, path);
        try {
            writer.closeWrapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Calculate(List<String> stringList) {
        CalculationService.calculateDirectories(stringList);
        CalculationService.calculateFiles(stringList);
        CalculationService.calculateAverageTitlesLength(stringList);
        CalculationService.fileCounters(stringList);
    }

    /**
     * Read file from directory and write directories tree in output file
     *
     * @param writer object ReportWriter class for writing directories tree
     * @param path   path to directory for reading
     */
    public static void print(ReportWriter writer, String path) {
        try {
            writer.openWriter();
            DirectoriesScanner.createReportInFile(0, new File(path), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

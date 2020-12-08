import bean.CalculationService;
import bean.DirectoriesScanner;
import bean.ReportReader;
import writer.ReportWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    /**
     * Create .txt file with directories tree from directory path, or read information from file
     * and calculate number of files and directories {@link CalculationService} in this file
     *
     * @param args can contains path to .txt file {@link ReportReader#readFromFile(String)}
     *             or to directory {@link Main#readFilesAndWriteDirectoryTree(String)} (String)}
     */
    public static void main(String[] args) {
        String path = args[0];
        if (isArgumentAFile(path)) {
            try {
                List<String> stringList = ReportReader.readFromFile(path);
                allCalculationOnFile(stringList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            readFilesAndWriteDirectoryTree(path);
        }
    }

    private static boolean isArgumentAFile(String path) {
        return path.endsWith(".txt");
    }

    /**
     * Read file from directory and write directories tree in output file
     *
     * @param path path to directory for reading
     */
    public static void readFilesAndWriteDirectoryTree(String path) {
        ReportWriter writer = new ReportWriter();
        try {
            writer.openWriter();
            DirectoriesScanner.createReportInFile(0, new File(path), writer);
            writer.closeWrapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void allCalculationOnFile(List<String> stringList) {
        CalculationService.calculateDirectories(stringList);
        CalculationService.calculateFiles(stringList);
        CalculationService.calculateAverageTitlesLength(stringList);
        CalculationService.calculateAverageFilesAmountInDirectory(stringList);
    }
}

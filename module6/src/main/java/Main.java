import bean.CalculationService;
import bean.DirectoriesScanner;
import bean.FileReader;
import writer.WriterWrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WriterWrapper writer = new WriterWrapper();
        try {
            writer.openWriter();
            DirectoriesScanner.createReportInFile(0, new File("d:/Rammstein"), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> stringList = null;
        try {
            stringList = FileReader.readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.closeWrapper();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CalculationService.calculateDirectories(stringList);
        CalculationService.calculateFiles(stringList);
        CalculationService.calculateAverageTitlesLength(stringList);
        CalculationService.calculateAverageFilesAmountInDirectory(stringList);
    }
}

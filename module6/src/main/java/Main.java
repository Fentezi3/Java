import bean.CalculationService;
import bean.DirectoriesScanner;
import bean.ReportReader;
import writer.ReportWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList;
        try {
            for (String argument : args) { //change for to element[0]
                if (argument.endsWith(".txt")) {  //method
                    stringList = ReportReader.readFromFile(argument);
                    Calculate(stringList);
                } else {
                    ReportWriter writer = new ReportWriter(); //19-21 - one method
                    print(writer, argument);
                    writer.closeWrapper();
                }
            }
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

    public static void print(ReportWriter writer, String argument) {
        try {
            writer.openWriter();
            DirectoriesScanner.createReportInFile(0, new File(argument), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

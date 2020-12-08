package bean;

import java.util.ArrayList;
import java.util.List;

import static bean.DirectoriesScanner.DIR_PREFIX;
import static bean.DirectoriesScanner.FILE_PREFIX;

public class CalculationService {
    /**
     * Calculate amount of directories in string list.
     *
     * @param stringList files and directories names.
     */
    public static void calculateDirectories(List<String> stringList) {
        int directories = (int) stringList.stream()
                .filter(s -> s.contains(DIR_PREFIX)).count();
        System.out.println("Directories amount: " + directories);
    }

    /**
     * Calculate amount files in string list.
     *
     * @param stringList files and directories names.
     */
    public static void calculateFiles(List<String> stringList) {
        int files = (int) stringList.stream()
                .filter(s -> s.contains(FILE_PREFIX)).count();
        System.out.println("Files amount: " + files);
    }

    /**
     * Calculate average titles length
     *
     * @param stringList files and directories names.
     */
    public static void calculateAverageTitlesLength(List<String> stringList) {
        List<Integer> titleList = new ArrayList<>();
        float sum = 0;
        float average;
        for (String string : stringList) {
            if (string.contains(FILE_PREFIX)) {
                int length = string.trim().length() - FILE_PREFIX.length();
                titleList.add(length);
            }
        }
        for (int length : titleList) {
            sum += length;
        }
        average = sum / titleList.size();
        System.out.println("Average file name length: " + average);
    }

    /**
     * Calculate average amount files in directory.
     *
     * @param stringList files and directories names.
     */
    public static void calculateAverageFilesAmountInDirectory(List<String> stringList) {
        List<Integer> fileCounters = new ArrayList<>();
        int fileCounter = 0;
        for (String line : stringList) {
            if (line.contains(DIR_PREFIX)) {
                fileCounters.add(fileCounter);
                fileCounter = 0;
            }
            if (line.contains(FILE_PREFIX)) {
                fileCounter++;
            }
        }
        if (fileCounter > 0) {
            fileCounters.add(fileCounter);
        }
        int sumFiles = fileCounters.stream().mapToInt(Integer::valueOf).sum();
        long withoutEmptyList = fileCounters.stream().
                filter(integer -> integer > 0).count();
        float average = (float) sumFiles / withoutEmptyList;
        System.out.println("Average files in directory: " + average);
        System.out.println("Directions: " + withoutEmptyList);
    }
}

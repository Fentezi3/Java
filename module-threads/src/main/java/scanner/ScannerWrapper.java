package scanner;

import java.util.Scanner;

public class ScannerWrapper {
    private Scanner scanner;

    public void openScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public int readInput() {
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}

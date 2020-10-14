//2.Отобразить в окне консоли аргументы командной строки в обратном порядке.

package com.example;

import java.util.Scanner;

public class MainTask2 {
    public static final String SEPARATOR = " ";

    public static void main(String[] args) {
        String argumentsString = readString();

        String[] words = splitString(argumentsString);

        printReversed(words);
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        String argumentsString = scanner.nextLine();
        scanner.close();
        return argumentsString;
    }

    private static String[] splitString(String argumentsString) {
        return argumentsString.split(SEPARATOR);
    }

    private static void printReversed(String[] args) {
        for (int i = args.length; i > 0; i--) {
            System.out.print(args[i-1] + " ");
        }
        System.out.println();
    }
}

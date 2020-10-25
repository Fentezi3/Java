//5.Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

package com.example.fundamental;

import java.util.Scanner;

public class OptionalTask_5 {
    public static void main(String[] args) {
        int[] integers = readLine();
        countOdds(integers);
        countCombined(integers);
    }

    private static int[] readLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some numbers: ");
        String string = scanner.nextLine();
        scanner.close();
        String[] numbers = string.split(" ");
        int[] results = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            results[i] = Integer.parseInt(numbers[i]);
        }
        return results;
    }

    private static void countOdds(int[] integers) {
        int evens = 0;
        for (Integer chislo : integers) {
            if (isNumberContainOnlyEvens(chislo)) {
                evens++;
            }
        }
        System.out.println("evens: " + evens);
    }

    private static boolean isNumberContainOnlyEvens(Integer chislo) {
        while (chislo > 0) {
            if (isOdd(chislo)) {
                return false;
            }
            chislo = chislo / 10;
        }
        return true;
    }

    private static boolean isOdd(Integer chislo) {
        return chislo % 2 == 1;
    }

    private static void countCombined(int[] integers) {
        int combined = 0;
        for (Integer integer : integers) {
            if (isNumberEvenlyCombined(integer)) {
                combined++;
            }
        }
        System.out.println("combined: " + combined);
    }

    private static boolean isNumberEvenlyCombined(Integer integer) {
        int evens = 0;
        int odds = 0;
        while (integer > 0) {
            if (integer % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
            integer = integer / 10;
        }
        return evens == odds;
    }
}

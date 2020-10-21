//4.Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

package com.example;

import java.util.HashSet;
import java.util.Scanner;

public class OptionalTask_4 {
    public static void main(String[] args) {
        int[] integers = readLine();
        int allNumbers = allNumbersInTheArray(integers);
//        HashSet uniqueNumber = uniqueChecking(allNumbers);
//        findMinimalDifference(uniqueNumber);
    }

    private static int allNumbersInTheArray(int[] integers) {    //это main, который у меня не получилось расписать на методы.
        int indexCounter = 0;
        int minSize = Integer.MAX_VALUE;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < integers.length; i++) {
            while (i > 0) {
                if (i % 10 != 0)
                    hashSet.add(i);
            }
            i = i / 10;
            if (hashSet.size() < minSize) {
                minSize = hashSet.size();
            }
            indexCounter = i;
        }
        System.out.println("Minimum number of distinct digits is " + indexCounter);
        return indexCounter;
    }

    private static int[] readLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some numbers: ");
        String string = scanner.nextLine();
        scanner.close();
        String[] numb = string.split(" ");
        int[] results = new int[numb.length];
        for (int i = 0; i < numb.length; i++) {
            results[i] = Integer.parseInt(numb[i]);
        }
        return results;
    }
}

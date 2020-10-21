//6.Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

package com.example;

import java.util.HashSet;
import java.util.Scanner;

public class OptionalTask_6 {
    public static void main(String[] args) {
        int[] integers = readLine();

        int indexCounter = 0;
        int elementLength = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int element = 0; element < integers.length; element++) {
            indexCounter = element;
            while (element > 0) {
                if (element % 10 >= 0) {
                    hashSet.add(element);
                }
                element = element / 10;
            }
            if (hashSet.size() == elementLength) {
                break;
            }
            System.out.println("Number with distinct digits is " + indexCounter);
        }
    }
    if[i+1]-[i]>=1;
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

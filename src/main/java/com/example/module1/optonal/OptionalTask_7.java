//7.Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

package com.example.module1.optonal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OptionalTask_7 {
    public static void main(String[] args) {
        int[] integers = readLine();

        int indexCounter = 0;
        int elementLength = 0;
        Set<Integer> hashSet;
        for (int element : integers) {
            hashSet = new HashSet<>();
            indexCounter = element;
            while (element > 0) {
                elementLength++;
                if (element % 10 == 0) {
                    hashSet.add(element);
                }
                element = element / 10;
            }
            if (hashSet.size() == elementLength) {
                break;
            }
        }
        System.out.println("Number with distinct digits is " + indexCounter);
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
}

//Ввести n чисел с консоли.
//1.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

package com.example;

import java.util.Scanner;

public class Optional_1 {
    public static void main(String[] args) {
        int[] integers = readLine();
        int numLength = numberLength(integers);
        findMin(numLength);
        findMax(numLength);
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

    private static int numberLength(int[] integers) {
        int length = 0;
        for (Integer elementLength : integers) {
            if (elementLength != 0) {
                if (elementLength < 0) {
                    length++;
                }
                if (elementLength % 10 == 0) {
                    length++;
                }
            } else {
                length = 1;
            }
            length += Math.log10(Math.abs(elementLength));
        }
        return length;
    }

    private static void findMin(int numLength) {
        int min = Integer.MAX_VALUE;
        if (numLength < min) {
            min = numLength;
        }
        System.out.println(min);
    }

    private static void findMax(int numLength) {
        int max = Integer.MIN_VALUE;
        if (numLength > max) {
            max = numLength;
        }
        System.out.println(max);
    }
}

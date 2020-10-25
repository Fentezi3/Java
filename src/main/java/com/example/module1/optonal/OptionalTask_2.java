//2.Вывести числа в порядке возрастания (убывания) значений их длины.

package com.example.module1.optonal;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask_2 {
    public static void main(String[] args) {
        int[] integers = readLine();
        Arrays.sort(integers);
        for (int element : integers) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int i = integers.length - 1; i >= 0; i--) {
            System.out.print(integers[i] + " ");
        }
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

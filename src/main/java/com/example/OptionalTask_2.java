//2.Вывести числа в порядке возрастания (убывания) значений их длины.

package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask_2 {
    public static void main(String[] args) {
        int[] integers = readLine();
        Arrays.sort(integers);
        for (int element : integers) {
            System.out.printf(element + " ");
        }
        System.out.println(" ");
        for (int i = integers.length - 1; i >= 0; i--) {
            System.out.printf(integers[i] + " ");
        }
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

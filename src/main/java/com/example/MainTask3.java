//3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.

package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {
        Scanner enterQuantity = new Scanner(System.in);
        System.out.println("Enter the number of random numbers: ");
        int quantity = enterQuantity.nextInt();
        enterQuantity.close();
        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < quantity; i++) {
            int number = (int) (Math.random() * 20);
            numbers.add(number);
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}

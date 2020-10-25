//4.Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

package com.example.module1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTask4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some numbers: ");
        String enteredNumbers = scanner.nextLine();
        scanner.close();
        String[] strings = enteredNumbers.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String element : strings) {
            numbers.add(Integer.valueOf(element));
        }
        int sum = 0;
        int multi = 1;
        for (Integer element : numbers) {
            sum += element;
            multi *= element;
        }
        System.out.println("Summary = " + sum);
        System.out.println("Multi = " + multi);
    }
}

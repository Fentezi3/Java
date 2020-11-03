//1.Приветствовать любого пользователя при вводе его имени через командную строку.

package com.example.module1.main;

import java.util.Scanner;

public class MainTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce yourself:");
        String name = scanner.nextLine();
        scanner.close();
        System.out.printf("Hello, %s\n", name);
    }
}

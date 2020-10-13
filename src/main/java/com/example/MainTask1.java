//1.Приветствовать любого пользователя при вводе его имени через командную строку.

package com.example;
import java.util.Scanner;

public class MainTask1 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce yourself: ");
        String name = in.nextLine();
        System.out.printf("Hello, %s", name);
        in.close();
    }
}

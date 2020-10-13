//3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

package com.example;

import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args){
        Scanner enterQuantity = new Scanner(System.in);
        System.out.println("Enter the number of random numbers: ");
        int quantity= enterQuantity.nextInt();
        int a =0;
        int b = 10;
        for (int i = 0; i < quantity; i++) {
            System.out.println(a + (int) (Math.random()*b));
        }
    }
}


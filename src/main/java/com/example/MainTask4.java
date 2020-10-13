//4.Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

package com.example;

import java.util.Scanner;

public class MainTask4 {
    public static void main(String[] args){
        Scanner enterNumber = new Scanner(System.in);
        System.out.println("Enter some number: ");
        int enteredNumbers = enterNumber.nextInt(); //тут должен быть массив или строка, а не int?
        int sum = 0;
        if (enteredNumbers % 1 == 0){
            for (int i = 0; i < enteredNumbers.; i++) {

            }
            sum = enteredNumbers;
        }
        System.out.println("Not integer numbers.");
        System.out.println(sum);
            //если число целое(не дробное), то sum+=, else "Wrong"

    }

}

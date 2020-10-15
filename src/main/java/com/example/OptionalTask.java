//2.Вывести n чисел с консоли. Вывести числа в порядке возрастания значений их длины.

package com.example;

import java.util.Scanner;

public class OptionalTask {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter some number: ");
            int enteredNumbers  = scanner.nextInt();
            scanner.close();
            int numb[] = new int[]{enteredNumbers};

            for (int i = 0; i < numb.length-1; i++)
                for (int j = 0; j<numb.length-i-1; j++)
                    if (numb[j]>numb[j+1]){
                        int temp = numb[j];
                        numb[j] = numb[j+1];
                        numb[j+1] = temp;
                        numb.toString();
                    }
            System.out.println();
        }
}

//5.Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

package com.example.module1.main;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class MainTask5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number in the range from 1 to 12: ");
        int monthNumber = scanner.nextInt();
        scanner.close();
        System.out.println(Month.of(monthNumber).getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        System.out.println(new DateFormatSymbols(Locale.ENGLISH).getMonths()[monthNumber - 1]);
    }
}

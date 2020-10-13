//5.Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

package com.example;

import java.util.Scanner;

public class MainTask5 {
    public static void main(String[] args){
        Scanner someNumb = new Scanner(System.in);
        System.out.println("Enter a number in the range from 1 to 12: ");
        int number= someNumb.nextInt();
        String month;

        switch (number){
            case 1 : month = "January";
                break;
            case 2 : month = "February";
                break;
            case 3 : month = "March";
                break;
            case 4 : month = "April";
                break;
            case 5 : month = "May";
                break;
            case 6 : month = "June";
                break;
            case 7 : month = "Julue";
                break;
            case 8 : month = "August";
                break;
            case 9 : month = "September";
                break;
            case 10 : month = "October";
                break;
            case 11 : month = "November";
                break;
            case 12 : month = "December";
                break;
        }
        System.out.println(month);

    }
}

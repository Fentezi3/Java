//3.Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionalTask_3 {
    public static void main(String[] args) {
        int[] integers = readLine();
        int numberLength = countNumberLength(integers);
        double averageLength = countAverageLength(numberLength);
        List lessThatAverage = findLessThatAverage(integers, averageLength);
        List moreThatAverage = findMoreThatAverage(integers, averageLength);
        printLessNumbersAndLengths(lessThatAverage);
        printMoreNumbersAndLengths(moreThatAverage);
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

    private static int countNumberLength(int[] integers) {
        int length = 0;
        for (Integer elementLength : integers) {
            if (elementLength != 0) {
                if (elementLength < 0) {
                    length++;
                }
                if (elementLength % 10 == 0) {
                    length++;
                }
                length += Math.ceil(Math.log10(Math.abs(elementLength)));
            } else {
                length = 1;
            }
        }
        return length;
    }

    private static double countAverageLength(int numberLength) {
        double count;
        int check=0;
        int summary = 0;
        while (numberLength >0){
            summary += numberLength;
            check++;
        }count = summary / check;
        return count;
    }

    private static List<Integer> findLessThatAverage(int[] integers, double averageLength) {
        List <Integer> lessList = new ArrayList<>();
        for (int element : integers) {
            if (element > averageLength) {
                lessList.add(element);
            }
        }
        return lessList;
    }

    private static List<Integer> findMoreThatAverage(int[] integers, double averageLength) {
        List<Integer> moreList = new ArrayList<>();
        for (int element : integers) {
            if (element < averageLength) {
                moreList.add(element);
            }
        }
        return moreList;
    }

    private static void printLessNumbersAndLengths(List lessThatAverage) {
         Object[] lessNumber = lessThatAverage.toArray(new Integer[lessThatAverage.size()]);
         for (Object lessElement : lessThatAverage) {
            System.out.println("The less number is " + lessElement);
        }
    }

    private static void printMoreNumbersAndLengths(List moreThatAverage) {
        Object[] moreNumber = moreThatAverage.toArray(new Integer[moreThatAverage.size()]);
        for (Object moreElement : moreThatAverage) {
            System.out.println("The biggest number is " + moreElement);
        }
    }
}

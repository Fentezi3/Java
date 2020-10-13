package com.example;
import java.util.Random;
import java.util.Scanner;

public class OptionalTask {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        StringBuffer buffer = new StringBuffer();
        buffer.append(number);
        System.out.println("Your numbers is " + number);
    }
}

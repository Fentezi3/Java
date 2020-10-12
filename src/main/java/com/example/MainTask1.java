package com.example;
import java.util.Scanner;

public class MainTask1 {
    static class Test {
        public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            System.out.println("Introduce yourself: ");
            String name = in.nextLine();
            System.out.printf("Hello, %s", name);
            in.close();
        }
    }
}

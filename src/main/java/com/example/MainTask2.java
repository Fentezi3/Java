//2.Отобразить в окне консоли аргументы командной строки в обратном порядке.

package com.example;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class MainTask2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Write some data: ");
        String argumentsString = in.nextLine();
        List<String> argumentsList = new LinkedList<>((Arrays.asList(argumentsString.split(" "))));
        in.close();
        while(in.hasNext()) {
            argumentsList.add(in.next());
        }
        in.close();
        System.out.println(argumentsString);
          StringBuffer buffer = new StringBuffer();
          buffer.append(argumentsList);
          buffer.reverse();
          System.out.println(buffer);
    }
}


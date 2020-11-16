package com.remiz.module4.optional;

import com.remiz.module4.scan.ScannerWrapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File("src/main/resources/string.txt"));
             FileWriter writer = new FileWriter(new File("src/main/resources/output.txt"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            System.out.println("We're scanning and reading information from this file.\n");
            for (int i = list.size() - 1; i >= 0; i--) {
                writer.write(list.get(i) + "\n");
            }
            System.out.println("We're reversing order all lines in file.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("All lines in reverse order in output.txt file.\n");
    }
}

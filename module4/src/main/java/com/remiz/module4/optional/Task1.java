package com.remiz.module4.optional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        try (Scanner scanner = new Scanner(new File("src\\main\\resources\\string.txt"));
             FileWriter writer = new FileWriter(new File("src\\main\\resources\\output.txt"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                writer.write(list.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

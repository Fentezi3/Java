package com.remiz.module4.optional;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        List list = new ArrayList();
        try (Scanner scanner = new Scanner(new File("src/main/resources/string.txt"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            Collections.sort(list, Comparator.comparing(String::length));
            System.out.println("Lines sorted by length: " + list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

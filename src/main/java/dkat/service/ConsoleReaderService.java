package dkat.service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConsoleReaderService
{
//    public static List<Integer> readIntegersFromConsoleLine() throws NumberFormatException
//    {
//        try (Scanner scanner = new Scanner(System.in))
//        {
//            System.out.println("Please enter some numbers: ");
//            String string = scanner.nextLine();
//            return Arrays.stream(string.split(" "))
//                    .map(Integer::valueOf)
//                    .collect(Collectors.toList());
//        }
//    }
//
//    public static List<Integer> readOrderedIntegersFromConsoleLine() throws NumberFormatException
//    {
//        try (Scanner scanner = new Scanner(System.in))
//        {
//            System.out.println("Please enter some numbers: ");
//            String string = scanner.nextLine();
//            return Arrays.stream(string.split(" "))
//                    .map(Integer::valueOf)
//                    .collect(Collectors.toCollection(LinkedList::new));
//        }
//    }

    public static List<Integer> readIntegersFromConsoleLine() {
        return readIntegersFromConsoleLine(ArrayList::new);
    }

    public static List<Integer> readOrderedIntegersFromConsoleLine() {
        return readIntegersFromConsoleLine(LinkedList::new);
    }

    private static List<Integer> readIntegersFromConsoleLine(Supplier<List<Integer>> collectionSupplier)
            throws NumberFormatException
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.println("Please enter some numbers: ");
            String string = scanner.nextLine();
            return Arrays.stream(string.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(collectionSupplier));
        }
    }
}

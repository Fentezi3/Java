package dkat.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListConverterService
{
    public static List<String> convertNumbersToStrings(List<Integer> initialList)
    {
        return initialList.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static List<String> convertNumbersToStringsOrdered(List<Integer> initialList)
    {
        return initialList.stream()
                .map(String::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static List<String> sortStringsByLength(List<String> initialList)
    {
        return initialList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static List<String> sortStringsByLengthDescending(List<String> initialList)
    {
        return initialList.stream()
                .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}

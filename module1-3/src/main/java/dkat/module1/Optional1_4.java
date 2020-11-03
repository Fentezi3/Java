package dkat.module1;

import dkat.service.ConsoleReaderService;
import dkat.service.ListConverterService;
import dkat.service.StringService;

import java.util.*;

// 4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
public class Optional1_4
{
    public static void main(String[] args)
    {
        List<Integer> numbers = ConsoleReaderService.readOrderedIntegersFromConsoleLine();
        List<String> numbersAsStrings = ListConverterService.convertNumbersToStringsOrdered(numbers);

        Map<Long, String> lengthToString = new HashMap<>();
        numbersAsStrings.forEach(element ->
                lengthToString.putIfAbsent(StringService.countDistinctChars(element), element));

        Map.Entry<Long, String> minEntry = Collections.min(
                lengthToString.entrySet(),
                Comparator.comparingLong(Map.Entry::getKey)
        );

        System.out.println();
        System.out.println("First number with min amount of different digits: " + minEntry.getValue());
    }
}
package dkat.module1;

import dkat.service.ConsoleReaderService;
import dkat.service.ListConverterService;

import java.util.List;

// 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
public class Optional1_1
{
    public static void main(String[] args)
    {
        List<Integer> numbers = ConsoleReaderService.readIntegersFromConsoleLine();
        List<String> numbersAsStrings = ListConverterService.convertNumbersToStrings(numbers);
        List<String> sortedNumbersAsStrings = ListConverterService.sortStringsByLength(numbersAsStrings);

        System.out.println();

        String shortestNumber = sortedNumbersAsStrings.get(0);
        System.out.printf("The shortest number: %10s | length: %2s", shortestNumber, shortestNumber.length());

        System.out.println();

        String longestNumber = sortedNumbersAsStrings.get(sortedNumbersAsStrings.size() - 1);
        System.out.printf("The longest number:  %10s | length: %2s", longestNumber, longestNumber.length());
    }
}

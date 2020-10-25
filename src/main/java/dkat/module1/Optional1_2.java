package dkat.module1;

import dkat.service.ConsoleReaderService;
import dkat.service.ListConverterService;

import java.util.List;

// 2. Вывести числа в порядке возрастания (убывания) значений их длины.
public class Optional1_2
{
    public static void main(String[] args)
    {
        List<Integer> numbers = ConsoleReaderService.readIntegersFromConsoleLine();
        List<String> numbersAsStrings = ListConverterService.convertNumbersToStrings(numbers);
        List<String> sortedNumbersAsStrings = ListConverterService.sortStringsByLength(numbersAsStrings);
        System.out.println("Numbers in ascending length order:");
        sortedNumbersAsStrings.forEach(element -> System.out.print(element + " "));

        System.out.println();

        List<String> sortedNumbersAsStringsDescending =
                ListConverterService.sortStringsByLengthDescending(numbersAsStrings);
        System.out.println("Numbers in descending length order:");
        sortedNumbersAsStringsDescending.forEach(element -> System.out.print(element + " "));
    }
}

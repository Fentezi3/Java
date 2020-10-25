package dkat.module1;

import dkat.service.ConsoleReaderService;
import dkat.service.ListConverterService;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

// 3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
public class Optional1_3
{
    public static void main(String[] args)
    {
        List<Integer> numbers = ConsoleReaderService.readIntegersFromConsoleLine();
        List<String> numbersAsStrings = ListConverterService.convertNumbersToStrings(numbers);
        double averageLength = numbersAsStrings.stream()
                .mapToInt(String::length)
                .average().getAsDouble();

        // Print numbers using Java 8 stream
        printNumbersWithLengthLessThanAverageUsingStream(numbersAsStrings, averageLength);
        printNumbersWithLengthMoreThanAverageUsingStream(numbersAsStrings, averageLength);

        // Or pring numbers using Java 8 stream and further decomposition with Functional interface
        printNumbersWithLengthLessThanAverageUsingStreamAndFunctionalInterface(numbersAsStrings, averageLength);
        printNumbersWithLengthMoreThanAverageUsingStreamAndFunctionalInterface(numbersAsStrings, averageLength);
    }

    private static void printNumbersWithLengthMoreThanAverageUsingStream(List<String> numbersAsStrings,
                                                                         double averageLength)
    {
        System.out.println();
        List<String> numbersWithLengthMoreThanAverage = numbersAsStrings.stream()
                .filter(element -> element.length() > averageLength)
                .collect(Collectors.toList());
        System.out.println("Numbers with length more than average: " + averageLength);
        numbersWithLengthMoreThanAverage
                .forEach(element -> System.out.printf("number: %10s, length: %s\n", element, element.length()));
    }

    private static void printNumbersWithLengthLessThanAverageUsingStream(List<String> numbersAsStrings,
                                                                         double averageLength)
    {
        System.out.println();
        List<String> numbersWithLengthLessThanAverage = numbersAsStrings.stream()
                .filter(element -> element.length() < averageLength)
                .collect(Collectors.toList());
        System.out.println("Numbers with length less that average: " + averageLength);
        numbersWithLengthLessThanAverage
                .forEach(element -> System.out.printf("number: %10s, length: %s\n", element, element.length()));
    }

    private static void printNumbersWithLengthLessThanAverageUsingStreamAndFunctionalInterface(
            List<String> numbersAsStrings, double averageLength)
    {
        System.out.println();
        System.out.println("Numbers with length less that average: " + averageLength);
        printNumbersUsingStreamAndFunctionalInterface(
                numbersAsStrings,
                averageLength,
                (element, avLength) -> element.length() < averageLength
        ).forEach(element -> System.out.printf("number: %10s, length: %s\n", element, element.length()));
    }

    private static void printNumbersWithLengthMoreThanAverageUsingStreamAndFunctionalInterface(
            List<String> numbersAsStrings, double averageLength)
    {
        System.out.println();
        System.out.println("Numbers with length more that average: " + averageLength);
        printNumbersUsingStreamAndFunctionalInterface(
                numbersAsStrings,
                averageLength,
                (element, avLength) -> element.length() > averageLength
        ).forEach(element -> System.out.printf("number: %10s, length: %s\n", element, element.length()));
    }

    private static List<String> printNumbersUsingStreamAndFunctionalInterface(
            List<String> numbersAsStrings, double averageLength, BiFunction<String, Double, Boolean> filter)
    {
        return numbersAsStrings.stream()
                .filter(element -> filter.apply(element, averageLength))
                .collect(Collectors.toList());
    }
}

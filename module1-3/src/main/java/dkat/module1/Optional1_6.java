package dkat.module1;

import dkat.service.ConsoleReaderService;
import dkat.service.NumbersService;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
public class Optional1_6
{
    public static void main(String[] args)
    {
        List<Integer> numbers = ConsoleReaderService.readOrderedIntegersFromConsoleLine();
        Map<Integer, Integer> mapAbsToOriginal = numbers.stream()
                .collect(Collectors.toMap(Math::abs, Function.identity()));

        String result = numbers.stream()
                .map(Math::abs)
                .map(String::valueOf)
                .filter(element -> NumbersService.allDigitsAscending(Integer.valueOf(element)))
                .findFirst()
                .orElse("Not found");

        System.out.println(
                "First number with all ascending digits: " +
                (
                        result.equals("Not found")
                                ? "Not found"
                                : mapAbsToOriginal.get(Integer.valueOf(result))
                )
        );
    }
}

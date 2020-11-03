package dkat.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NumbersService
{
    public static boolean allDigitsAscending(Integer number)
    {
        if(number / 10 == 0)
        {
            return true;
        }

        List<Integer> digits = new LinkedList<>();
        while(number > 0)
        {
            digits.add(number % 10);
            number /= 10;
        }
        for (int i = 0; i < digits.size() - 1; i++)
        {
            if(digits.get(i) < digits.get(i + 1))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean allDigitsDifferent(Integer sourceNumber)
    {
        if(String.valueOf(sourceNumber).length() == 1)
        {
            return true;
        }

        if(String.valueOf(sourceNumber).length() > 10)
        {
            return false;
        }

        Integer operatingNumber = sourceNumber;
        Set<Integer> distinctDigits = new HashSet<>();
        while(operatingNumber > 0)
        {
            distinctDigits.add(operatingNumber % 10);
            operatingNumber /= 10;
        }
        return String.valueOf(sourceNumber).length() <= distinctDigits.size();
    }
}

package dkat.service;

public class StringService
{
    public static long countDistinctChars(String string)
    {
        return string.chars().distinct().count();
    }
}

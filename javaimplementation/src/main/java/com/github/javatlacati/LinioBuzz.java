package com.github.javatlacati;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Program that prints all the numbers from 1 to 100. However, for
 * multiples of 3, instead of the number, print "Linio". For multiples of 5 print
 * "IT". For numbers which are multiples of both 3 and 5, print "Linianos".
 */
public class LinioBuzz {
    public static String linianos(int number) {
        return IntStream.range(1, number + 1)
                .mapToObj(LinioBuzz::liniano)
                .collect(Collectors.joining(" "));
    }

    private static String liniano(int number) {
        return new ChainedValidator<>(String.valueOf(number))
                .addChainedValidation(number % 3 == 0, "Linio")
                .addChainedValidation(number % 5 == 0, "IT")
                .addChainedValidation(number % 15 == 0, "Linianos")
                .firstThatMatches();
    }

    public static void main(String[] args) {
        System.out.println(LinioBuzz.linianos(100));
    }
}

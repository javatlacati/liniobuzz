package com.github.javatlacati

import java.util.stream.Collectors
import java.util.stream.IntStream

/**
 * Program that prints all the numbers from 1 to 100. However, for
 * multiples of 3, instead of the number, print "Linio". For multiples of 5 print
 * "IT". For numbers which are multiples of both 3 and 5, print "Linianos".
 */
object LinioBuzz {
    fun linianos(number: Int): String {
        return (1..number).map { liniano(it) }.joinToString(" ")
    }

    private fun liniano(number: Int): String? {
        return ChainedValidator(number.toString())
                .addChainedValidation(number % 3 == 0, "Linio")
                .addChainedValidation(number % 5 == 0, "IT")
                .addChainedValidation(number % 15 == 0, "Linianos")
                .firstThatMatches()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(LinioBuzz.linianos(100))
    }
}

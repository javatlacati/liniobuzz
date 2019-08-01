package com.github.javatlacati

import org.junit.Test

import java.util.Random
import java.util.stream.IntStream

import org.junit.Assert.assertEquals

class ChainedValidatorTest {
    internal var random = Random()

    @Test
    fun shouldProvideDefaultValueIfNoneProvided() {
        val anInt = random.nextInt(500)
        assertEquals(anInt, ChainedValidator(anInt).firstThatMatches())
    }

    @Test
    fun shouldReplaceDefaultValueIfOneConditionMatches() {
        val anInt = random.nextInt(500)
        val i = random.nextInt(500)
        assertEquals(i, ChainedValidator(anInt).addChainedValidation(true, i).firstThatMatches())
    }

    @Test
    fun shouldProvideDefaultValueIfNoConditionMatches() {
        val anInt = random.nextInt(500)
        val i = random.nextInt(500)
        assertEquals(anInt, ChainedValidator(anInt).addChainedValidation(false, i).firstThatMatches())
    }

    @Test
    fun lastMatchingConditionWillHavePrecedence() {
        val anInt = random.nextInt(500)
        val expected = random.nextInt(500)
        val integerChainedValidator = ChainedValidator(anInt)
        IntStream.generate { random.nextInt(500) }
                .parallel()
                .limit(random.nextInt(50).toLong())
                .distinct()
                .forEach { value -> integerChainedValidator.addChainedValidation(true, value) }

        assertEquals(expected, integerChainedValidator.addChainedValidation(true, expected).firstThatMatches())
    }
}

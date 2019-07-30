package com.github.javatlacati;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ChainedValidatorTest {
    Random random = new Random();

    @Test
    public void shouldProvideDefaultValueIfNoneProvided() {
        Integer anInt = random.nextInt(500);
        assertEquals(anInt, new ChainedValidator<>(anInt).firstThatMatches());
    }

    @Test
    public void shouldReplaceDefaultValueIfOneConditionMatches() {
        Integer anInt = random.nextInt(500);
        Integer i = random.nextInt(500);
        assertEquals(i, new ChainedValidator<>(anInt).addChainedValidation(true, i).firstThatMatches());
    }

    @Test
    public void shouldProvideDefaultValueIfNoConditionMatches() {
        Integer anInt = random.nextInt(500);
        Integer i = random.nextInt(500);
        assertEquals(anInt, new ChainedValidator<>(anInt).addChainedValidation(false, i).firstThatMatches());
    }

    @Test
    public void lastMatchingConditionWillHavePrecedence() {
        Integer anInt = random.nextInt(500);
        Integer expected = random.nextInt(500);
        ChainedValidator<Integer> integerChainedValidator = new ChainedValidator<>(anInt);
        IntStream.generate(() -> random.nextInt(500))
                .parallel()
                .limit(random.nextInt(50))
                .distinct()
                .forEach(value -> integerChainedValidator.addChainedValidation(true, value));

        assertEquals(expected, integerChainedValidator.addChainedValidation(true, expected).firstThatMatches());
    }
}

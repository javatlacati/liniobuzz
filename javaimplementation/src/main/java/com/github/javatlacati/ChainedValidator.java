package com.github.javatlacati;

/**
 * Validator that maps the value in case that some condition is satisfied.
 * @param <Type>
 */
public class ChainedValidator<Type> {
    private Type currentValue;

    /**
     * Creates a ChainedValidator with a default value to make sure we don't lave the solution space
     * @param defaultValue the value that shall be returned if no validation is meet
     */
    public ChainedValidator(Type defaultValue) {
        currentValue = defaultValue;
    }

    /**
     * In case validations overlap, the last one chained will have more precedence.
     * This is an intermediate operation
     * @param condition condition to test
     * @param value value to set if condition is true
     * @return this validator instance with updated values
     */
    ChainedValidator<Type> addChainedValidation(boolean condition, Type value){
        if(condition){
            currentValue = value;
        }
        return  this;
    }

    /**
     * Gets the validation mapping status.
     * This is a terminal operation.
     * @return the value resulting from validations
     */
    public Type firstThatMatches() {
        return currentValue;
    }
}

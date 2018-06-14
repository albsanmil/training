package com.training.romans;

import com.training.regex.EfficientRomanNumberValidator;

import static com.google.common.base.Preconditions.checkArgument;

public class RomanNumber {

    private String symbols;

    private static Validator validator = new EfficientRomanNumberValidator();

    private RomanNumber(String symbols) {
        this.symbols = symbols.toUpperCase();
    }

    public static RomanNumber valueOf(String romanNumber) {
        checkArgument(validator.validate(romanNumber), "Invalid roman number " + romanNumber);
        return new RomanNumber(romanNumber);
    }

    public String getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        return symbols;
    }
}

package com.training.regex;

import com.training.romans.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EfficientRomanNumberValidator implements Validator {

    private static final Pattern pattern = Pattern.compile("(M{0,3}|CM|)(D?|CD)(C{0,3}|XC)(L?|XL)(X{0,3}|IX)(V?I{0,3}|IV)");

    public boolean validate(String romanNumber) {
        Matcher matcher = pattern.matcher(romanNumber);
        return matcher.matches();
    }
}

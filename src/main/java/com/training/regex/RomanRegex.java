package com.training.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanRegex {

    private static final Pattern pattern = Pattern.compile("I{1,3}");

    public boolean validateRomanNumber(String romanNumber) {
        Matcher matcher = pattern.matcher(romanNumber);
        return matcher.matches();
    }
}

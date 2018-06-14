package com.training.regex;

import com.training.romans.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EfficientRomanNumberValidator implements Validator {

//    private static final Pattern pattern = Pattern.compile(
//            "M{0,3}(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|(VI{0,3})?)_$");

    private static final Pattern pattern = Pattern.compile(
            "M{0,3}(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})");

//    private static final Pattern pattern = Pattern.compile(
//           "(M{0,3}(CM)?)(D?|CD)(C{0,3}(XC)?)(L?|XL)(X{0,3}(IX)?)(VI{0,3}|IV|._?)");

   // "(M{0,3}(CM)?)(D?|CD)(C{0,3}(XC)?)(L?|XL)(X{0,3}(IX)?)(V?I{0,3}|IV|.+_.*)");

    @Override
    public boolean validate(String romanNumber) {
        Matcher matcher = pattern.matcher(romanNumber);
        return matcher.matches();
    }
}

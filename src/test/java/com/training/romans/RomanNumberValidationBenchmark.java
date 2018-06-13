package com.training.romans;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RomanNumberValidationBenchmark {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource("romans/romanNumbers").toURI());
        Stream<String> lines = Files.lines(path);
        // System.nanoTime();
        lines.forEach(line -> {
            String[] lineParts = line.split("=");
            RomanNumber romanNumber = RomanNumber.valueOf(lineParts[1]);
        });
        lines.close();
    }
}

package com.training.romans;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RomanNumberValidationBenchmark {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource("romans/romanNumbers").toURI());
        Stream<String> lines = Files.lines(path);

        double initialTimeNano;
        double finalTimeNano;
        double initialTimeMillis;
        double finalTimeMillis;

        initialTimeNano = System.nanoTime();
        initialTimeMillis = System.currentTimeMillis();

        lines.forEach(line -> {
            String[] lineParts = line.split("=");
            RomanNumber romanNumber = RomanNumber.valueOf(lineParts[1]);
        });
        lines.close();

        finalTimeNano = System.nanoTime();
        finalTimeMillis = System.currentTimeMillis();

        double resultNano = (finalTimeNano - initialTimeNano);
        double resultMillis = (finalTimeMillis - initialTimeMillis);

        System.out.println("Initial time in nano seconds: " + initialTimeNano +
                "\t\t\t" + "Initial time in milli seconds: " + initialTimeMillis);
        System.out.println("Final time in nano seconds: " + finalTimeNano +
                "\t\t\t" + "Final time in milli seconds: " + finalTimeMillis);
        System.out.println("_____________________________________________________" +
                "_____________________________________________________");
        System.out.println("Result in nano seconds: " + resultNano + " Nano seconds" +
                "\t\t" + "Result in milli seconds: " + resultMillis + " Nano seconds");
        System.out.println("Result in seconds: " + resultNano / 1000000000 + " Seconds" +
                "\t\t\t\t\t" + "Result in seconds: " + resultMillis / 1000 + " Seconds");

    }
}

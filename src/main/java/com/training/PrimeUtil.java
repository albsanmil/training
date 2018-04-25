package com.training;

public class PrimeUtil {

    public int[] getPrimes(int end) {
        int[] primes = new int[end];

        return primes;
    }

    public boolean isPrime(int number) {
        if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
            return false;
        }

        double sqrt = Math.sqrt(number);
        int integerPart = (int) sqrt;
        if (Math.pow(sqrt, 2) == Math.pow(integerPart, 2)) {
            return false;
        }
        else {
            for (int i = integerPart - 1; i > 5; i--) {
                if (isPrime(i) && number % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
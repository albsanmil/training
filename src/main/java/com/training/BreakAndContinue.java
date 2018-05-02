package com.training;

public class BreakAndContinue {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 74) {
                break; // terminamos aqui el bucle
            }

            // Salto a la siguiente iteración si i no es divisible entre 9
            if (i % 9 != 0) {
                continue;
            }

            // Si I es divisible entre 9 se imprime
            System.out.println(i);
        }

        int i = 0;

        // Lazo infinito del cual se sale con break:
        while (true) {
            i++;
            if (i == 120) {
                break; // Salimos del lazo
            }
            System.out.println(i);
        }
    }
}

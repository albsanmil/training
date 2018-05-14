package com.training.romans;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {

    public static int toNumber(String roman) {

        roman = roman.toUpperCase();

        Map<Character, Integer> primRomans = new HashMap<>();

        primRomans.put('I', 1);
        primRomans.put('V', 5);
        primRomans.put('X', 10);
        primRomans.put('L', 50);
        primRomans.put('C', 100);
        primRomans.put('D', 500);
        primRomans.put('M', 1000);


        if (roman.length() == 0) {
            return 0;
        }
        else if (roman.length() == 1) {
            for (int i = 0; i < roman.length(); i++) {
                for (Character rom : primRomans.keySet()) {
                    if (rom.equals(roman.charAt(i))) {
                        return primRomans.get(rom);
                    }
                }
            }
            return 0;
        }
        else {
            int result = 0;
            int counter = 0;
            int counterV = 0;
            int counterL = 0;
            int counterD = 0;
            int k = 0;
            for (int i = 0; i < roman.length(); i++) {
                int j = i + 1;
                if (i == roman.length() - 1) {
                    j = i;
                }

                if (i != 0) {
                    k = i -1;
                }

                for (Character rom : primRomans.keySet()) {
                    if (rom.equals(roman.charAt(i)) && primRomans.get(rom) >= primRomans.get(roman.charAt(j))) {
                        result += primRomans.get(rom);
                        // Esto controla que el número romano no pueda contener mas de tres carácters iguales seguidos
                        if (k >= 0 && primRomans.get(rom).equals(primRomans.get(roman.charAt(k)))) {
                            counter++;
                            if (counter >= 4) {
                                return 0;
                            }
                        }
                        else {
                            counter = 1;
                        }
                    }
                    else if (rom.equals(roman.charAt(i)) && primRomans.get(rom) < primRomans.get(roman.charAt(j))) {
                        result -= primRomans.get(rom);
                        counter = 1;
                        // Esto controla que cuando se resta el valor de un carácter al que tiene a su derecha por ser este
                        // mayor, comprueba que su carácter de la izquierda no sea igual. Si es así retorna 0.
                        if (k != 0 && primRomans.get(rom).equals(primRomans.get(roman.charAt(k)))) {
                            return 0;
                        }
                    }
                    else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'V') {
                        counterV++;
                        if (counterV == 2) {
                            return 0;
                        }
                    }
                    else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'L') {
                        counterL++;
                        if (counterL == 2) {
                            return 0;
                        }
                    }
                    else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'D') {
                        counterD++;
                        if (counterD == 2) {
                            return 0;
                        }
                    }
                }
            }
            return result;
        }
    }
}



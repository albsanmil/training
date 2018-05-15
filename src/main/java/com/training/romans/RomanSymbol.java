package com.training.romans;

public enum RomanSymbol {

    I('I', 1),
    V('V', 5),
    X('X', 10),
    L('L', 50),
    C('C', 100),
    D('D', 500),
    M('M', 1000);

    private final char character;
    private final int code;

    RomanSymbol(char character, int code) {
        this.character = character;
        this.code = code;
    }

    public char getCharacter() {
        return character;
    }

    public int getCode() {
        return code;
    }

    public static RomanSymbol fromCharacter(char character) {
        for (RomanSymbol romanSymbol : RomanSymbol.values()) {
            if (romanSymbol.character == character) {
                return romanSymbol;
            }
        }

        throw new IllegalArgumentException("Roman character '" + character + "' does not exist");
    }
}

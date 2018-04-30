//package com.training.basic;

/*public class Exercise1 {

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Alberto");
    }
*/
public class Exercise1 {
    public static void main(String[] args) {
        int i = 9,k;
        float j = 47.9F;
        System.out.println("i: " + i + "j: " +j);
        k = (int)j; //empleo de un cast
        System.out.println("j: " + j + "k: " +k);
        j = k;//no necesita cast
        System.out.println("j: " + j + "k: " +k);
        float m = 2.3F;
//float m = 2.3; daría error al compilar.
        System.out.println("m: " +m);
    }
}
package com.training.datatypes;

import java.util.Scanner;

import static com.training.util.SpeedUtil.*;

public class DT_Exercise7 {

    public static void main(String[] args) {
        Scanner introNumber = new Scanner(System.in);

        System.out.print("Enter a calculateDistance in meters: ");
        float distance = introNumber.nextInt();

        System.out.print("Enter a time in hours: ");
        float hours = introNumber.nextInt();

        System.out.print("Enter a time in minutes: ");
        float minutes = introNumber.nextInt();

        System.out.print("Enter a time in seconds: ");
        float seconds = introNumber.nextInt();

        System.out.println("____________________________________________");
        System.out.println("Your speed in meters/second is: " + calculateSpeedInMetersPerSecond(distance, hours, minutes, seconds));
        System.out.println("Your speed in kms/h is: " + calculateSpeedInKmsPerHour(distance, hours, minutes, seconds));
        System.out.printf("Your speed in miles/h is: " + calculateSpeedInMilesPerHour(distance, hours, minutes, seconds));
    }
}

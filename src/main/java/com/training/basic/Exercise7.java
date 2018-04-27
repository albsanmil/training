package com.training.datatypes;

import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {

        Scanner introNumber = new Scanner(System.in);

        double distance;
        double hours;
        double minutes;
        double seconds;

        System.out.print("Enter a distance in meters: ");
        distance = introNumber.nextInt();
        System.out.print("Enter a time in hours: ");
        hours = introNumber.nextInt();
        System.out.print("Enter a time in minutes: ");
        minutes = introNumber.nextInt();
        System.out.print("Enter a time in seconds: ");
        seconds = introNumber.nextInt();

        System.out.println("____________________________________________");
        System.out.println("Your speed in meters/second is: " + speedMetersPerSecond(distance, hours, minutes, seconds));
        System.out.println("Your speed in kms/h is: " + speedKmsPerHour(distance, hours, minutes, seconds));
        System.out.printf("Your speed in miles/h is: " + speedMilesPerHour(distance, hours, minutes, seconds));
    }

    private  static double speedMetersPerSecond(double distance, double hours, double minutes, double seconds) {

        double time = (hours * 60 * 60) + (minutes * 60) + seconds;
        return distance / time;
    }

    private  static double speedKmsPerHour(double distance, double hours, double minutes, double seconds) {
        double distanceInKms = (distance / 1000);
        double timeInHours = (hours + (minutes / 60) + (seconds / 60 / 60));
        return distanceInKms / timeInHours;
    }

    private  static double speedMilesPerHour(double distance, double hours, double minutes, double seconds) {
        double distanceInMilles = (distance / 1609);
        double timeInHours = (hours + (minutes / 60) + (seconds / 60 / 60));
        return distanceInMilles / timeInHours;
    }
}

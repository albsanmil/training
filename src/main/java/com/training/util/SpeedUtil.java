package com.training.util;

public class SpeedUtil {

    public static float calculateSpeedInMetersPerSecond(float distance, float hours, float minutes, float seconds) {
        float time = (hours * 60 * 60) + (minutes * 60) + seconds;
        return distance / time;
    }

    public static float calculateSpeedInKmsPerHour(float distance, float hours, float minutes, float seconds) {
        float distanceInKms = (distance / 1000);
        float timeInHours = (hours + (minutes / 60) + (seconds / 60 / 60));
        return distanceInKms / timeInHours;
    }

    public static float calculateSpeedInMilesPerHour(float distance, float hours, float minutes, float seconds) {
        float distanceInMilles = (distance / 1609);
        float timeInHours = (hours + (minutes / 60) + (seconds / 60 / 60));
        return distanceInMilles / timeInHours;
    }
}

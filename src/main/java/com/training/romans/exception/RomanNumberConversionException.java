package com.training.romans.exception;

/**
 * Throwing when something goes wrong during roman numbers conversions.
 */
public class RomanNumberConversionException extends RuntimeException {

    public RomanNumberConversionException(String message) {
        super(message);
    }

    public RomanNumberConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public RomanNumberConversionException(Throwable cause) {
        super(cause);
    }
}

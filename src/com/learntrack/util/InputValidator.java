/**
 * Provides utility methods for validating user input used by the
 * LearnTrack console application.
 */
package com.learntrack.util;

import com.learntrack.entity.Student;
import com.learntrack.exception.InvalidInputException;

public class InputValidator {
    // validate string field
    public static void validateField(String fieldName, String value) throws InvalidInputException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(
                    fieldName + " cannot be empty."
            );
        }
    }

    // validate number
    public static void validatePositiveNumber(
            String fieldName,
            int value) throws InvalidInputException {

        if (value <= 0) {
            throw new InvalidInputException(
                    fieldName + " must be greater than 0."
            );
        }
    }

    // Validates email format
    public static void validateEmail(String email) throws InvalidInputException {

        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidInputException(
                    "Invalid email address."
            );
        }
    }

}

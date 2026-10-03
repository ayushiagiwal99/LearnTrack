/**
 * Provides utility methods for validating user input used by the
 * LearnTrack console application.
 */
package com.learntrack.util;

public class InputValidator {
    // Validates that a string is not null or empty
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Validates email format
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}

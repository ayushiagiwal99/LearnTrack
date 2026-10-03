/**
 * Provides utility methods for validating user input used by the
 * LearnTrack console application.
 */
package com.learntrack.util;

import com.learntrack.entity.Student;
import com.learntrack.exception.InvalidInputException;

public class InputValidator {
    // validate field
    public static void validateField(String fieldName, String value) throws InvalidInputException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(
                    fieldName + " cannot be empty."
            );
        }
    }

    // Validates email format
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    // validate student
    public static void validateStudent(Student student)
            throws InvalidInputException {

        if (student == null) {
            throw new InvalidInputException("Student cannot be null.");
        }

        validateField("First name", student.getFirstName());
        validateField("Last name", student.getLastName());
        validateField("Batch", student.getBatch());

        if (!isValidEmail(student.getEmail())) {
            throw new InvalidInputException("Invalid email address.");
        }
    }
}

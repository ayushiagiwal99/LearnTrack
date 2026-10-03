/**
 * Generates unique sequential IDs for students, courses, and enrollments.
 */
package com.learntrack.util;

public class IdGenerator {
    private static int idCounter = 1; // Centralized counter

    public static Integer generateId() {
        return idCounter++; // return and then increment
    }
}

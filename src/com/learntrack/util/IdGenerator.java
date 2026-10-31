/**
 * Generates unique sequential IDs for students, courses, and enrollments.
 */
package com.learntrack.util;

public class IdGenerator {
    // Centralized counter
    private static int studentIdCounter = 1;
    private static int courseIdCounter = 1;
    private static int enrollmentIdCounter = 1;

    // cannot create object of IdGenerator
    private IdGenerator() {};

    public static int generateStudentId() {
        return studentIdCounter++; // return and then increment
    }

    public static int generateCourseId() {
        return courseIdCounter++; // return and then increment
    }

    public static int generateEnrollmentId() {
        return enrollmentIdCounter++; // return and then increment
    }
}

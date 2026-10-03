/**
 * Represents a student's enrollment in a course, including enrollment
 * date and current enrollment status.
 */
package com.learntrack.entity;

import java.time.LocalDate;

public class Enrollment {
    private int enrollemntId;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

}

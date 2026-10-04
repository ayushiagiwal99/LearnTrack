/**
 * Represents a student's enrollment in a course, including enrollment
 * date and current enrollment status.
 */
package com.learntrack.entity;

import com.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {
    private int enrollemntId;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(int enrollemntId, int studentId, int courseId, LocalDate enrollmentDate, EnrollmentStatus status) {
        this.enrollemntId = enrollemntId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Enrollment(int id, int studentId, int courseId) {
        this(
            id,
            studentId,
            courseId,
            LocalDate.now(),
            EnrollmentStatus.ACTIVE
        );
    }

    public int getEnrollemntId() {
        return enrollemntId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public void complete() {
        this.status = EnrollmentStatus.COMPLETED;
    }

    public void cancel() {
        this.status = EnrollmentStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "ID: " + enrollemntId
            + ", Student ID: " + studentId
            + ", Course ID: " + courseId
            + ", Enrollment Date: " + enrollmentDate
            + ", Status: " + status;
    }
}

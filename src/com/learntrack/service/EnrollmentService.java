/**
 * Provides operations for managing student course enrollments,
 * including creating, searching, completing, and cancelling enrollments.
 */
package com.learntrack.service;

import com.learntrack.entity.Course;
import com.learntrack.entity.Enrollment;
import com.learntrack.entity.Student;
import com.learntrack.enums.EnrollmentStatus;
import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.exception.InvalidInputException;
import com.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class EnrollmentService {
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();

    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(
            StudentService studentService,
            CourseService courseService) {

        this.studentService = studentService;
        this.courseService = courseService;
    }

    /**
     * Enrolls an active student into an active course.
     */
    public Enrollment enrollStudent( int studentId, int courseId) throws EntityNotFoundException, InvalidInputException {

        Student student = studentService.findStudentById(studentId);

        if (!student.isActive()) {
            throw new InvalidInputException(
                "Student with ID " + studentId + " is inactive."
            );
        }

        Course course = courseService.findById(courseId);

        // Check that the course is active
        if (!course.isActive()) {
            throw new InvalidInputException(
                    "Course with ID " + courseId + " is inactive."
            );
        }

        // Prevent duplicate active enrollment
        if (isAlreadyEnrolled(studentId, courseId)) {
            throw new InvalidInputException(
                    "Student is already enrolled in this course."
            );
        }

        int id = IdGenerator.generateEnrollmentId();

        Enrollment enrollment = new Enrollment(
            id,
            studentId,
            courseId
        );

        enrollments.add(enrollment);

        return enrollment;
    }

    /**
     * Returns all enrollments for a student.
     */
    public ArrayList<Enrollment> getStudentEnrollments(
            int studentId)
            throws EntityNotFoundException {

        // Verify that student exists
        studentService.findStudentById(studentId);

        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                studentEnrollments.add(enrollment);
            }
        }

        return studentEnrollments;
    }

    /**
     * Finds an enrollment by ID.
     */
    public Enrollment findById(int id) throws EntityNotFoundException {
        return enrollments.stream()
            .filter(enrollment -> enrollment.getEnrollmentId() == id)
            .findFirst()
            .orElseThrow(() ->
                new EntityNotFoundException(
                    "Enrollment with ID " + id + " not found."
                )
            );
    }

    /**
     * Completes an active enrollment.
     */
    public void completeEnrollment(int id)
            throws EntityNotFoundException, InvalidInputException {

        Enrollment enrollment = findById(id);

        if (enrollment.getStatus() != EnrollmentStatus.ACTIVE) {
            throw new InvalidInputException(
                    "Only active enrollments can be completed."
            );
        }

        enrollment.complete();
    }

    /**
     * Cancels an active enrollment.
     */
    public void cancelEnrollment(int id)
            throws EntityNotFoundException, InvalidInputException {

        Enrollment enrollment = findById(id);

        if (enrollment.getStatus() != EnrollmentStatus.ACTIVE) {
            throw new InvalidInputException(
                    "Only active enrollments can be cancelled."
            );
        }

        enrollment.cancel();
    }

    /**
     * Returns all enrollments.
     */
    public ArrayList<Enrollment> listEnrollments() {
        return new ArrayList<>(enrollments);
    }

    /**
     * Checks whether a student already has an active enrollment
     * for the specified course.
     */
    private boolean isAlreadyEnrolled(int studentId, int courseId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId
                    && enrollment.getCourseId() == courseId
                    && enrollment.getStatus() == EnrollmentStatus.ACTIVE) {
                return true;
            }
        }

        return false;
    }


}

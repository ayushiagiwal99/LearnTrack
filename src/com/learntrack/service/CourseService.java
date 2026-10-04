/**
 * Provides operations for managing courses, including adding,
 * searching, updating, listing, and activating or deactivating courses.
 */
package com.learntrack.service;

import com.learntrack.entity.Course;
import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.exception.InvalidInputException;
import com.learntrack.util.IdGenerator;
import com.learntrack.util.InputValidator;

import java.util.ArrayList;

public class CourseService {

    private final ArrayList<Course> courses = new ArrayList<>();

    public Course addCourse(
            String courseName,
            String description,
            int durationInWeeks,
            boolean active)
            throws InvalidInputException {

        // Validate input
        validateCourseDetails(courseName, description, durationInWeeks);

        int id = IdGenerator.generateCourseId();

        Course course = new Course(
                id,
                courseName,
                description,
                durationInWeeks,
                active
        );

        courses.add(course);

        return course;
    }

    public ArrayList<Course> listCourses() {
        return courses;
    }

    public Course findById(int id) throws EntityNotFoundException {

        return courses.stream()
            .filter(course -> course.getCourseId() == id)
            .findFirst()
            .orElseThrow(() ->
                    new EntityNotFoundException(
                            "Course with ID " + id + " not found."
                    )
            );
    }

    public void updateCourse(
        int id,
        String courseName,
        String description,
        int durationInWeeks)
        throws EntityNotFoundException, InvalidInputException {

        Course course = findById(id);

        // Validate input
        validateCourseDetails(courseName, description, durationInWeeks);

        course.setCourseName(courseName);
        course.setDescription(description);
        course.setDurationInWeeks(durationInWeeks);
    }

    public void activateCourse(int id) throws EntityNotFoundException {

        Course course = findById(id);
        course.setActive(true);
    }

    public void deactivateCourse(int id)
            throws EntityNotFoundException {

        Course course = findById(id);
        course.setActive(false);
    }

    public void validateCourseDetails(
        String courseName,
        String description,
        int durationInWeeks
    ) throws InvalidInputException {
        InputValidator.validateField("Course Name", courseName);
        InputValidator.validateField("Description", description);
        InputValidator.validatePositiveNumber("Duration in weeks", durationInWeeks);
    }
}

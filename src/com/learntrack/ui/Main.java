/**
 * Entry point and console user interface for the LearnTrack application.
 * Handles menus, user input, and calls the appropriate service operations.
 */
package com.learntrack.ui;

import com.learntrack.constants.MenuConstants;
import com.learntrack.entity.Course;
import com.learntrack.entity.Enrollment;
import com.learntrack.entity.Student;
import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.exception.InvalidInputException;
import com.learntrack.service.CourseService;
import com.learntrack.service.EnrollmentService;
import com.learntrack.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();

    private static final EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case MenuConstants.STUDENT_MENU:
                    studentMenu();
                    break;
                case MenuConstants.COURSE_MENU:
                    courseMenu();
                    break;
                case MenuConstants.ENROLLMENT_MENU:
                    enrollmentMenu();
                    break;
                case MenuConstants.EXIT:
                    running = false;
                    System.out.println("Exiting LearnTrack. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // =========================
    // Main Menu
    // =========================

    private static void displayMainMenu() {

        System.out.println("\n===== LearnTrack =====");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Exit");
    }

    // =========================
    // Student Menu
    // =========================
    private static void studentMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case MenuConstants.ADD_STUDENT:
                        addStudent();
                        break;
                    case MenuConstants.VIEW_STUDENTS:
                        viewStudents();
                        break;
                    case MenuConstants.SEARCH_STUDENT:
                        searchStudent();
                        break;
                    case MenuConstants.DEACTIVATE_STUDENT:
                        deactivateStudent();
                        break;
                    case MenuConstants.BACK:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    private static void addStudent()
            throws InvalidInputException {

        String firstName = readString("Enter first name: ");
        String lastName = readString("Enter last name: ");
        String email = readString("Enter email: ");
        String batch = readString("Enter batch: ");
        studentService.addStudent(firstName, lastName, email, batch);
        System.out.println( "Student added successfully.");
    }

    private static void viewStudents() {

        ArrayList<Student> students = studentService.listStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== Students =====");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() throws EntityNotFoundException {
        int id = readInt("Enter student ID: ");
        Student student = studentService.findStudentById(id);
        System.out.println("\nStudent found:");
        System.out.println(student);
    }

    private static void deactivateStudent() throws EntityNotFoundException {
        int id = readInt("Enter student ID: ");
        studentService.deactivateStudent(id);
        System.out.println( "Student deactivated successfully.");
    }

    // =========================
    // Course Menu
    // =========================
    private static void courseMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n===== Course Management =====");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Activate Course");
            System.out.println("4. Deactivate Course");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case MenuConstants.ADD_COURSE:
                        addCourse();
                        break;
                    case MenuConstants.VIEW_COURSES:
                        viewCourses();
                        break;
                    case MenuConstants.ACTIVATE_COURSE:
                        activateCourse();
                        break;
                    case MenuConstants.DEACTIVATE_COURSE:
                        deactivateCourse();
                        break;
                    case MenuConstants.BACK:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addCourse() throws InvalidInputException {

        String courseName = readString("Enter course name: ");
        String description = readString("Enter description: ");
        boolean active = readYesNo("Course is active: [y/n]: ");
        int durationInWeeks =
                readInt("Enter duration in weeks: ");

        Course course = courseService.addCourse(
                courseName,
                description,
                durationInWeeks,
                active
        );

        System.out.println("Course added successfully");
    }

    private static void viewCourses() {

        ArrayList<Course> courses = courseService.listCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        System.out.println("\n===== Courses =====");

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void activateCourse() throws EntityNotFoundException {
        int id = readInt("Enter course ID: ");
        courseService.activateCourse(id);
        System.out.println("Course activated successfully.");
    }

    private static void deactivateCourse() throws EntityNotFoundException {
        int id = readInt("Enter course ID: ");
        courseService.deactivateCourse(id);
        System.out.println("Course deactivated successfully.");
    }

    // =========================
    // Enrollment Menu
    // =========================

    private static void enrollmentMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n===== Enrollment Management =====");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Student Enrollments");
            System.out.println("3. Complete Enrollment");
            System.out.println("4. Cancel Enrollment");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case MenuConstants.ENROLL_STUDENT:
                        enrollStudent();
                        break;
                    case MenuConstants.VIEW_STUDENT_ENROLLMENTS:
                        viewStudentEnrollments();
                        break;
                    case MenuConstants.COMPLETE_ENROLLMENT:
                        completeEnrollment();
                        break;
                    case MenuConstants.CANCEL_ENROLLMENT:
                        cancelEnrollment();
                        break;
                    case MenuConstants.BACK:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (EntityNotFoundException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void enrollStudent() throws EntityNotFoundException, InvalidInputException {

        int studentId = readInt("Enter student ID: ");
        int courseId = readInt("Enter course ID: ");

        enrollmentService.enrollStudent(
            studentId,
            courseId
        );

        System.out.println("Student enrolled successfully.");
    }

    private static void viewStudentEnrollments() throws EntityNotFoundException {

        int studentId = readInt("Enter student ID: ");
        ArrayList<Enrollment> enrollments = enrollmentService.getStudentEnrollments(studentId);

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        System.out.println("\n===== Student Enrollments =====");

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    private static void completeEnrollment() throws EntityNotFoundException, InvalidInputException {

        int enrollmentId = readInt("Enter enrollment ID: ");
        enrollmentService.completeEnrollment(enrollmentId);
        System.out.println("Enrollment completed successfully.");
    }

    private static void cancelEnrollment() throws EntityNotFoundException, InvalidInputException {

        int enrollmentId = readInt("Enter enrollment ID: ");
        enrollmentService.cancelEnrollment(enrollmentId);
        System.out.println("Enrollment cancelled successfully.");
    }

    // =========================
    // Input Helpers
    // =========================

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println( "Please enter a valid number.");
            }
        }
    }

    private static boolean readYesNo(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("y")) {
                return true;
            }

            if (input.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }


    private static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
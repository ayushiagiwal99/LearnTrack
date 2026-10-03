/**
 * Provides operations for managing students, including adding,
 * searching, updating, listing, and deactivating students.
 */
package com.learntrack.service;

import com.learntrack.entity.Student;
import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.exception.InvalidInputException;
import com.learntrack.util.IdGenerator;
import com.learntrack.util.InputValidator;

import java.util.ArrayList;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();

    // Add new student
    public Student addStudent(
        String firstName,
        String lastName,
        String email,
        String batch) throws InvalidInputException {

        Student student = new Student(
            0,
            firstName,
            lastName,
            email,
            batch,
            true
        );

        InputValidator.validateStudent(student);

        student.setId(IdGenerator.generateId());

        students.add(student);

        return student;
    }

    // Search student by ID
    public Student findStudentById(int id) throws EntityNotFoundException {
        return students.stream()
            .filter(student -> student.getId() == id)
            .findFirst()
            .orElseThrow(() ->
                new EntityNotFoundException(
                    "Student with ID " + id + " not found."
                )
            );
    }

    // Deactivate a student (set active = false instead of deleting)
    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = findStudentById(id);
        student.setActive(false);
    }

    // list students
    public ArrayList<Student> listStudents() {
        return students;
    }
}

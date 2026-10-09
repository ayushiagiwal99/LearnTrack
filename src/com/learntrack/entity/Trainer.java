/**
 * Represents a trainer enrolled in the LearnTrack system.
 * Extends Person to reuse common personal information.
 */
package com.learntrack.entity;

public class Trainer extends Person {
    private String specialization;

    public Trainer(int id, String firstName, String lastName, String email, String specialization) {
        super(id, firstName, lastName, email);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String getDisplayName() {
        return "Trainer Name: " + getFirstName() + " " + getLastName();
    }
}

/**
 * Represents a course available in the LearnTrack system.
 */
package com.learntrack.entity;

public class Course {
    private int courseId;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course(int courseId, String courseName, String description, int durationInWeeks, boolean active) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + courseId
            + ", Course: " + courseName
            + ", Description: " + description
            + ", Duration: " + durationInWeeks + " weeks"
            + ", Active: " + active;
    }
}

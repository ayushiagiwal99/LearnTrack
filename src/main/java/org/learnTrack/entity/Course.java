/**
 * Represents a course available in the LearnTrack system.
 */
package main.java.org.learnTrack.entity;

public class Course {
    private int courseId;
    private String courseName;
    private int durationInWeeks;
    private boolean active;

    public Course(int courseId, String courseName, int durationInWeeks, boolean active) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
}

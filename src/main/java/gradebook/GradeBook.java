package gradebook;

import logic.Test;

public class GradeBook {

    private String courseName;
    private String courseInstructor;

    public GradeBook() {
    }

    public GradeBook(String courseName) {
        this.courseName = courseName;
    }

    public GradeBook(String courseName, String courseInstructor) {
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayCourse() {
        if (Test.isNullOrEmpty(getCourseName()) && Test.isNullOrEmpty(getCourseInstructor())){
            System.out.printf("Welcome to this gradebook");
            return;
        }

        if (Test.isNullOrEmpty(getCourseName())){
            System.out.printf("Welcome to the gradebook. This course is instructed by %s.\n", getCourseInstructor());
            return;
        }

        if (Test.isNullOrEmpty(getCourseInstructor())){
            System.out.printf("Welcome to the gradebook for %s.\n", getCourseName());
            return;
        }
        System.out.printf("Welcome to the gradebook for %s. This course is instructed by %s.\n", getCourseName(), getCourseInstructor());
    }
}

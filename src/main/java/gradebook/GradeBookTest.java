package gradebook;

public class GradeBookTest {
    public static void main(String[] args) {
        GradeBook gradeBook1 = new GradeBook("WSW101: Java Programming Fundamentals");
        GradeBook gradeBook2 = new GradeBook("WSW102: Java Programming Integrations", "William Walsh");
        GradeBook gradeBook3 = new GradeBook();
        gradeBook3.setCourseInstructor("Salvo Marino");

        gradeBook1.displayCourse();
        gradeBook2.displayCourse();
        gradeBook3.displayCourse();
    }
}


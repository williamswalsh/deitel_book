package gradebook;

public class GradeBook_1 {
    private String courseName;
    private int[][] grades;

    public GradeBook_1(String courseName, int[][] grades) {
        this.courseName = courseName;
        this.grades = grades;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void outputBarChart() {
        System.out.println("Grade Distribution");

        int[] frequency = new int[11];

        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                ++frequency[grade / 10];
            }
        }
        for (int count = 0; count < frequency.length; count++) {
            if(count==10)
                System.out.printf("%5d: ",100);
            else
                System.out.printf("%02d-%02d: ",count * 10, count * 10 + 9);

            for (int stars = 0; stars < frequency[count]; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

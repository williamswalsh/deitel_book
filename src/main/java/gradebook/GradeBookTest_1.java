package gradebook;

public class GradeBookTest_1 {
    public static void main(String[] args) {
        int[][] grades = {{30, 90, 78, 67, 58, 93}, {21, 56, 90, 99, 100}, {94, 98, 97, 96}, {100, 97, 99, 98, 97, 93}, {93, 92, 91, 99, 90, 89}};
        GradeBook_1 gb = new GradeBook_1("Computer Networking - hands on", grades);
        gb.outputBarChart();

    }
}

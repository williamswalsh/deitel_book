package sorting;

import java.util.Arrays;

public class InsertionSortArrayTest {

    public static void main(String[] args) {
        InsertionSortArray app = new InsertionSortArray(10000, 10000);
        System.out.println(Arrays.toString(app.data));

        long startTime = System.nanoTime();
        app.sort();
        long endTime = System.nanoTime();
        System.out.println("Delta: " + ((endTime - startTime)/1000000) + " miliseconds");       // 1039
    }
}

package sorting;

import java.util.Arrays;

public class MergeSortArrayTest {

    public static void main(String[] args) {
        MergeSortArray app = new MergeSortArray(10000, 10000);
        System.out.println(Arrays.toString(app.data));
        long startTime = System.nanoTime();
        app.sort(app.data);
        long endTime = System.nanoTime();
        System.out.println("Delta: " + ((endTime - startTime) / 1000000) + " miliseconds");       // 2 - 4 ms
    }
}


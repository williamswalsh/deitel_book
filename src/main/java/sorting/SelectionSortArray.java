package sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortArray {
    public int[] data;
    private Random rand;

    public SelectionSortArray(int size, int bound) {
        data = new int[size];
        rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(bound);
        }
    }

    public void sort() {
        int smallestIndex;

        for (int i = 0; i < data.length; i++) {
            smallestIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            swap(i, smallestIndex);
        }
    }

    public void swap(int first, int second) {
        int tmp = data[first];
        data[first] = data[second];
        data[second] = tmp;
    }
}

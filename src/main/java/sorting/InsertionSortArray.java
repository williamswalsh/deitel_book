package sorting;

import java.util.Random;

/**
 * Insertion Sort Algorithm
 * <p>
 * 1) works by comparing element 1 & element 2
 * 2) then comparing element 1, 2 & 3
 * 3) then comparing element 1, 2, 3 & 4
 */
public class InsertionSortArray {
    public int[] data;
    private Random rand;

    public InsertionSortArray(int size, int bound) {
        data = new int[size];
        rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(bound);
        }
    }

    public void sort() {
        int insert;
        for (int i = 1; i < data.length; i++) {
            insert = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > insert) {
                data[j + 1] = data[j];
                j--;
            }
            j++;
            data[j] = insert;
        }
    }
}
// 3 7 2 1
//   ^
// 7 > 3
// 3 7 2 1
//     ^
// 2 < 7
// shift 7 one right
// 2 < 3
// shift 3 one right
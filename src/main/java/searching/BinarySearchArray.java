package searching;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchArray {
    public int[] data;
    private Random rand;

    public BinarySearchArray(int size) {
        data = new int[size];
        rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(4000);
        }
        Arrays.sort(data);
    }

    public int search(int searchKey) {
        int middleIndex;
        int startIndex = 0;
        int endIndex = data.length - 1;
        int location = -1;

        do {
            middleIndex = (startIndex + endIndex + 1) / 2;

            if (data[middleIndex] > searchKey) {
                endIndex = middleIndex - 1;
            } else if (data[middleIndex] < searchKey) {
                startIndex = middleIndex + 1;
            } else {
                location = middleIndex;
            }
        } while (location == -1 && startIndex <= endIndex);

        return location;
    }
}
// 1 3 6 7 9
//     ^
//     8
// 6 < 8
// startIndex = 3
// 1 3 6 7 9
//       ^
// 7 < 8
// startIndex = 4 end = 4
// 1 3 6 7 9
//         ^
// 9 > 8
// end = middle -1
// end = 4 -1
// end = 3 start = 4
// (4 <= 3) -> False

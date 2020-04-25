package sorting;

import java.util.Random;

public class MergeSortArray {
    public int[] data;
    private Random rand;

    public MergeSortArray(int size, int bound) {
        data = new int[size];
        rand = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(bound);
        }
    }

    public void sort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;

        int middle = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, middle);
        mergeSort(arr, temp, middle + 1, rightEnd);
        merge(arr, temp, leftStart, rightEnd);
    }

    public void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }


        // Only one of these lines will have an effect
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);

        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }
}

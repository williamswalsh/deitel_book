package data_manipulation;

public class FindLargestInt {

    public static int findLargestInt(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {30, 3, 56, 33, 890, 8967, 5346};
        int[] b = {30, 3, 56, 567789, 80, 8967, 78};
        int[] c = {3322320, 433, 5623232, 4333, 890, 56433, 5346};
        System.out.printf("Largest Number: %d\n", findLargestInt(a));
        System.out.printf("Largest Number: %d\n", findLargestInt(b));
        System.out.printf("Largest Number: %d\n", findLargestInt(c));
    }
}

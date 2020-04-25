package google_interview;

public class Q1 {

    public static void main(String[] args) {
        int[] input = {2, 6, 4, 6, 6, -9, -9, -9, -0, -100,  -9, 77};
        System.out.println(mostFrequentInt(input));
    }

    public static int mostFrequentInt(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must have at least 1 element");
        }

        int[] numberSet = new int[numbers.length];
        int[] freqSet = new int[numbers.length];
        int numberSetIndex = 0;
        int numberSetPosition = 0;

        for (int i = 0; i < numbers.length; i++) {
            numberSetIndex = numberExists(numbers[i], numberSet);

            if (numberSetIndex == -1) {

                // New number
                numberSetPosition++;
                numberSet[numberSetPosition] = numbers[i];
                freqSet[numberSetPosition] = 1;

            } else {
                // Duplicate
                freqSet[numberSetIndex]++;
            }
        }
        return numberSet[maxPosition(freqSet)];
    }

    private static int numberExists(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static int maxPosition(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must have at least 1 element");
        }

        int maxPos = 0;
        if (numbers.length == 1) {
            return maxPos;
        }

        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxPos = i;
            }
        }
        return maxPos;
    }
}
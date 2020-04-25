package recursion;

import java.util.Arrays;

/**
 * Get the smallest integer from an array using a recursive algorithm
 */
public class RecursiveMin {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] a = {3, 4, 56, 1, 0, 2, 65};
        System.out.println("MIN: " + calc2(a, a.length));
    }

    public static int calc(int[] in) {
        if (in.length < 1) {
            throw new RuntimeException("Array must have at least one element.");
        }
        int curr = in[0];

        if (curr < min) {
            min = curr;
        }
        if (in.length == 1) {
            return min;
        }
        int[] restOfArray = Arrays.copyOfRange(in, 1, in.length);

        return calc(restOfArray);
    }

    /**
     * Calculates the min element in an array recursively
     * Doesn't modify the array size
     * Just specifies a different size
     * Elements outside "size" elements are ignored
     *
     * @param in   Input array of primitive integers to calculate the min of
     * @param size Size of the input array
     * @return The minimum element in the array
     */
    public static int calc2(int[] in, int size) {
        if (size == 1) {
            return in[0];
        }
        return Math.min(in[size - 1], calc2(in, size - 1));
    }
}

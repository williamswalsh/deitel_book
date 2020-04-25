package generics;

import java.util.Comparator;

public class MaxGeneric {
    public static void main(String[] args) {

        // Auto-boxing still works even for generic methods
        Double d = max(3.4, 5.6, 8.99);
        System.out.println(d);
    }

    private static <T extends Comparable<T>> T max(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}

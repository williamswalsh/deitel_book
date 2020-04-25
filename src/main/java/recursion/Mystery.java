package recursion;

/**
 * Reverses array by using recursion beginning at start of array (index 0)
 * Final method called returns then preceding method calls return string suffixing on their data (int element)
 *
 */
public class Mystery {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 2, 9, 12};
        System.out.println(method(a, 0));
    }

    public static String method(int[] arr, int x) {
        if (x < arr.length) {
            return String.format("%s%d ", method(arr, x + 1), arr[x]);
        } else {
            return "";
        }
    }
}

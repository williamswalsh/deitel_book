package arrays;

import java.util.Arrays;

public class ArraysClass {
    public static void main(String[] args) {
        // Arrays.sort(a1) -> sorts array in place
        // Arrays.fill(a1, 0) -> fills array with single int 0
        // boolean areEqual = Arrays.equals(a1, a2);



        // Array needs to be sorted for binary search
        // Works for all values that come before an incorrectly sorted item -> 2 & 3 - Not 1

        // int location = Arrays.binarySearch(array, searchTarget)
        // System.arrayCopy(a1, startIndex1, a2, startIndex2, numElementsToCopy)

        int [] a = {2,3,1};
//        int location = Arrays.binarySearch(a, 3);
//        System.out.println(location);
        int [] b = a;
        System.out.println("" + a[0] + "" + a[1] + "" + a[2] + "");
        System.out.println("" + b[0] + "" + b[1] + "" + b[2] + "");


        b[0]=666;
        System.out.println("" + a[0] + "" + a[1] + "" + a[2] + "");
        System.out.println("" + b[0] + "" + b[1] + "" + b[2] + "");
    }

}

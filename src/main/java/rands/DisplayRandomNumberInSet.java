package rands;

import java.util.Random;

public class DisplayRandomNumberInSet {

    private static Random r;

    public static void main(String[] args) {

        r = new Random();
        int[] nums = { 6,10,14,18,22, 34, 67, 78678 };
        int[] out = get100RandNumFromArray(nums, r);

        for (int i = 0; i < out.length; i++) {
            System.out.println("Result: " + out[i]);
        }
    }


    private static int getRandNumFromArray( int[] arr, Random rand ){
        return arr[ r.nextInt(arr.length) ];
    }

    private static void print100RandNumFromArray( int[] arr, Random rand ){
        for (int i = 0; i < 100; i++) {
            System.out.println(arr[r.nextInt(arr.length)]);
        }
    }

    private static int[] get100RandNumFromArray( int[] arr, Random rand ){
        int[] out = new int[100];
        int inputArrLength = arr.length;


        for (int i = 0; i < 100; i++) {
            out[i] = arr[r.nextInt(inputArrLength)];
        }

        return out;
    }
}

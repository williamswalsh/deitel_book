package data_manipulation;

import java.util.Random;

public class BinaryStrToInteger {

    private static Random r = new Random();

    // Note: Integer.parseInt(str)
    // Removes leading zeros -> 001010 -> 1010
    //                            ^       ^
    public static int binaryStrToInt(String str) {
        int intOfStr = Integer.parseInt(str);
        int sum = 0;
        int exponent = 0;

        while (intOfStr > 0) {
            sum += ((intOfStr % 10) == 1) ? Math.pow(2, exponent) : 0;

            intOfStr = intOfStr / 10;
            exponent++;
        }
        return sum;
    }

    public static String createRandBinaryString() {
        int value = r.nextInt(256);
        String binStr = Integer.toBinaryString(value);

        return binStr;
    }

    public static String[] createRandBinaryStrings(int amount) {
        String[] binStrArr = new String[amount];

        for (int i = 0; i < amount; i++) {
            binStrArr[i] = createRandBinaryString();
        }
        return binStrArr;
    }

    public static void testBinaryStrToInt() {
        String[] binaryStrs = createRandBinaryStrings(10000);
        String str8Bits;

        for (int i = 0; i < binaryStrs.length; i++) {
            str8Bits = String.format("%8s", binaryStrs[i]).replace(' ', '0');
            System.out.printf("Binary: %s,\tInteger Value: %d\n", str8Bits, binaryStrToInt(binaryStrs[i]));
        }
    }

//    private static int binaryToInt(byte[] in){
//        return 0;
//    }

    public static void main(String[] args) {
        testBinaryStrToInt();
    }
}

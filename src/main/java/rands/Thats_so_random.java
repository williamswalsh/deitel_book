package rands;

import java.util.Random;

public class Thats_so_random {

    public static void main(String[] args) {

        calcRandomAvg();
    }


    private static double calcRandomAvg() {
        int i = 1;
        int sum = 0;
        int result;
        double avg = 0;

        while (i < 1000) {

            // NB -> Is it possible to Pass a method to another method??
            result = createRandRangesMinus3_plus11();
            sum += result;

            // Casting to force double division
            // Not integer division
            avg = (double) sum / i;

            System.out.printf("Current: %-14d\tAvg: %f\n", result, avg);
            i++;
        }
        return avg;
    }

    // 0 -> 1
    private static int createRandRanges0_1() {
        Random r = new Random();
        return (r.nextBoolean() ? 1 : 0) + 1;
    }

    // 0-> 100
    private static int createRandRanges0_100() {
        Random r = new Random();
        return r.nextInt(100) + 1;
    }

    // 0 -> 9
    private static int createRandRanges0_9() {
        Random r = new Random();
        return r.nextInt(10);
    }

    // 1 -> 9
    private static int createRandRanges1_9() {
        Random r = new Random();
        return r.nextInt(9) + 1;
    }

    // 1000 -> 1112
    private static int createRandRanges1000_1112() {
        Random r = new Random();
        return r.nextInt(13) + 1000;
    }

    // -1 -> +1
    private static int createRandRangesMinus1_plus1() {
        Random r = new Random();
        return r.nextInt(3) - 1;
    }

    // -3 -> +11
    private static int createRandRangesMinus3_plus11() {
        Random r = new Random();
        return r.nextInt(15) - 3;
    }

}

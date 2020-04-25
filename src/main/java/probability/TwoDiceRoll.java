package probability;

import java.util.Random;

public class TwoDiceRoll {

    private static Random rand = new Random();

    private static int rollDie() {
        return rand.nextInt(6) + 1;
    }

    private static int rollTwoDice() {
        return rollDie() + rollDie();
    }

    public static void main(String[] args) {
        getFrequencyOfFaces(3000000);
    }

    private static void getFrequencyOfFaces(int rolls) {
        int[] frequency = new int[13];
        int sum;

        for (int roll = 0; roll < rolls; roll++) {
            sum = rollTwoDice();
            ++frequency[sum];
        }
        for (int i = 2; i < 13; i++) {
            System.out.println( i + ": " + frequency[i]);
        }
    }
}

// 6 unique permutations for 3 distinct numbers -> {1,2,3} -> 123 132 213 231 312 321

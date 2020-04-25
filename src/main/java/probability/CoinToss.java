package probability;

import java.util.Random;
import java.util.Scanner;

public class CoinToss {
    private static Random r = new Random();

    private static CoinState flip () {
        if (r.nextBoolean()){
            return CoinState.HEADS;
        }
        return CoinState.TAILS;
    }


        public static void main(String[] args) {

        }
}

enum CoinState {
    HEADS, TAILS
}

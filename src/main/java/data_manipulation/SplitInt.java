package data_manipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SplitInt {
    public static void main(String[] args) {

    }

    private static List<Integer> getDigits(int num) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while ( num > 0 ){
            digits.add( num % 10 );
            num /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    private static List<Integer> getDigitsInReverse(int num) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while ( num > 0 ){
            digits.add( num % 10 );
            num /= 10;
        }
        return digits;
    }
}

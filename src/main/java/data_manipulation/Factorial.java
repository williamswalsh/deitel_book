package data_manipulation;

import java.math.BigInteger;
public class Factorial {
    public static BigInteger factorial(int num) {
        if (num < 0) {
//          throw new IllegalArgumentException("Factorial only accepts non negative numbers.");
            System.out.println("Factorial only accepts non negative numbers. Skipping");
            return BigInteger.valueOf(-1);
        }

        BigInteger factorial = BigInteger.valueOf(1);
        while (num > 0) {
            factorial = factorial.multiply(BigInteger.valueOf(num));
            --num;
        }
        return factorial;
    }
    public static void testFactorial(){
        BigInteger result;
        for (int i =-20;i< 100;i++){
            result = factorial(i);
            if (result.signum() != -1) {
                System.out.printf("Number: %d,\tFactorial: %d\n", i, factorial(i));
            }
        }
    }

    public static void main(String[] args) {
        testFactorial();
    }
}

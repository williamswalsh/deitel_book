package recursion;

import java.math.BigInteger;

public class BigFibonacci {
    private static BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) {
        for (int i=0; i<100;i++) {
            System.out.println("i: " + i + ", fibonacci: " + calculate(BigInteger.valueOf(i)));
        }
    }

    public static BigInteger calculate(BigInteger bigInput) {
        if (bigInput.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Fibonacci index: " + bigInput + " must be greater than 0.");
        }
        if (bigInput.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.valueOf(0);
        }
        if (bigInput.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.valueOf(1);
        }
        return calculate(bigInput.subtract(BigInteger.ONE)).add(calculate(bigInput.subtract(TWO)));
    }
}

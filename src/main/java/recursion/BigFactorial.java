package recursion;

import java.math.BigInteger;

public class BigFactorial {

    public static void main(String[] args) {
        for (int i=0; i<100;i++) {
            System.out.println("i: " + i + ", factorial: " + calculate(BigInteger.valueOf(i)));
        }
    }
    public static BigInteger calculate(BigInteger bigInput) {
        if (bigInput.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Factorial number: " + bigInput + " must be greater than 0.");
        }
        if (bigInput.compareTo(BigInteger.ZERO) == 0 || bigInput.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.valueOf(1);
        }
        return bigInput.multiply(calculate(bigInput.subtract(BigInteger.ONE)));
    }
}

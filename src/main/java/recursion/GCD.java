package recursion;

/**
 * Greatest common divisor - recursive method
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(1454, 1240));
    }

    public static int gcd(int a, int b) {
        System.out.println("gcd(" + a + ", " + b + ")");

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

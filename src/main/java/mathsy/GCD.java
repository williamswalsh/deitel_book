package mathsy;

import java.io.IOException;

public class GCD {
    public static void main(String[] args) throws IOException {
        System.out.println(gcd(24, 12));
    }

    private static int gcd(int a, int b) {
        int tmp;

        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}


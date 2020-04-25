package mathsy;

public class Rounding {
    public static void main(String[] args) {
        double x = 0.49999;

        System.out.println(roundToNearestInt(x));
        System.out.println(roundToTenthDecimalPlace(2.555));
        System.out.println(roundToTenthDecimalPlace(3.222));
        System.out.println(roundToHundredthDecimalPlace(45.6778));


        // Round to tenth dp
        // 3.222 * 10                       2.555 * 10
        // >> 32.22                         25.55
        // 32.22 + 0.5                      25.55 + 0.5
        // >> 32.72                         26.05
        // floor(32.72)                     flr(26.05)
        // >> 32                            26
        // 32 / 10                          26 / 10
        // >> 3.2                           2.6
    }


    // Uses double-to-int convert methods floor & ceil
    // NB: Will have same defaults for negative numbers
    private static double roundToNearestInt(double input) {

        double mantissa = input - Math.floor(input);
        if (mantissa >= 0.5) {
            // round up
            return Math.ceil(input);
        } else {
            //round down
            return Math.floor(input);
        }
    }

    private static double roundToTenthDecimalPlace(double input) {
        return Math.floor(input * 10 + 0.5) / 10;
    }

    private static double roundToHundredthDecimalPlace(double input) {
        return Math.floor(input * 100 + 0.5) / 100;
    }
}

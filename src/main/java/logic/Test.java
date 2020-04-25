package logic;

public class Test {
    public static boolean isNull(String testStr) {
        if (testStr == null) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(String testStr) {
        if (testStr == null) {
            return false;
        }
        return true;
    }

    public static boolean isNullOrEmpty(String testStr) {
        if (testStr == null) {
            return true;
        }
        if (testStr.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(String testStr) {
        if (testStr == null) {
            return false;
        }
        if (testStr.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isGTZero(double in) {
        return (in > 0.00)? true : false;
    }
}

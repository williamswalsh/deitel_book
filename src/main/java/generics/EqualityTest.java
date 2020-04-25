package generics;

public class EqualityTest {


    public static void main(String[] args) {

        System.out.println("Result 1: " + isEqualsTo(new Integer(3), new Integer(6)));
        System.out.println("Result 2: " + isEqualsTo(new Integer(3), new Integer(3)));
        System.out.println("Result 3: " + isEqualsTo(new Double(3.78), new Double(3.90)));

        // Reverts to referential equality
        System.out.println("Result 4: " + isEqualsTo(new Object(), new Object()));
    }

    private static <T> boolean isEqualsTo(T a, T b){
        return a.equals(b);
    }
}

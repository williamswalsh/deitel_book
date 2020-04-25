package mathsy;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    private static boolean isPerfect(int num) {
        if (num == 0) {
            return false;
        }

        List<Integer> allFactorsExceptNum = getAllFactorsExceptNumber(num);

        long sum = 0;
        for (Integer factor : allFactorsExceptNum) {
            sum += factor.intValue();
        }
        return (num == sum) ? true : false;
    }


    private static List<Integer> getAllFactorsExceptNumber(int num) {
        List<Integer> factors = new ArrayList<>();

        // Return empty list if 0 -> zero has no factors
        if (num == 0) {
            // 0 has no factors
            return factors;
        }

        // 1 is a factor
        factors.add(1);

        // Don't have to go as far as n/2 can just go to sqrt(num)
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }


    private static List<Integer> getAllFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        // Return empty list if 0
        if (num == 0) {
            // 0 has no factors
            return factors;
        }
        // 1 is a factor
        factors.add(1);

        // Don't have to go as far as n/2 can just go to sqrt(num)
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        // The number itself is a factor
        factors.add(num);
        return factors;
    }

    private static void printListOfInts(List<Integer> ints) {
        if (ints == null || ints.isEmpty()) {
            System.out.println("List of ints is empty.");
            return;
        }
        for (Integer i : ints) {
            System.out.println(i.toString());
        }
    }

    private static void printSomePerfectNumbers (){
        boolean result;
        for (int i = 0; i < 10000000; i++) {

            result = isPerfect(i);
            if (result){
                System.out.printf("%d ", i);
            }
        }
    }
    public static void main(String[] args) {
        printSomePerfectNumbers();
    }

}

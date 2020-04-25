package recursion;

import java.util.ArrayList;

public class Factorial {
    public static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        int input = 10;
        System.out.println(input + "! = " + calculate(input));

        prettyPrint(numbers);
    }

    public static int calculate(int input) {

        if (input < 0) {
            throw new IllegalArgumentException("Factorial number: " + input + " must be greater than 0.");
        }
        if (input == 1 || input == 0) {
            numbers.add(input);
            return 1;
        }
        numbers.add(input);
        return calculate(input - 1) * input;
    }

    public static void prettyPrint(ArrayList<Integer> numbers){
        System.out.println();
        String statement = "";
        for (int i= 0; i < numbers.size(); i++) {
            if (i != 0) {
                statement += " * " + numbers.get(i);
            } else {
                statement += numbers.get(i);
            }
            System.out.println(statement + "!");
        }
    }
}





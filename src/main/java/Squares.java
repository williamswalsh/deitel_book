package ie.william;
import java.util.Scanner;

public class Squares {
	public static void main(String[] args) {
		InputPair pair = getInput();
		
		System.out.println("Summation of Squares: " + sumOfSquares(pair.getNum1(), pair.getNum2())); 
		System.out.println("Difference of Squares: " + diffOfSquares(pair.getNum1(), pair.getNum2())); 
		
		
	}
	
	public static InputPair getInput() {
		
		Scanner in = new Scanner(System.in);
		int num1;
		int num2;
		
		System.out.print("Enter first number: ");
		num1 = in.nextInt();
		
		System.out.print("Enter second number: ");
		num2 = in.nextInt();
		
		return new InputPair(num1, num2);
	}
	
	
	public static int sumOfSquares(int num1, int num2) {
		return (num1 * num1) + (num2 * num2);
	}
	
	public static int diffOfSquares(int num1, int num2) {
		return (num1 * num1) - (num2 * num2);
	}
}




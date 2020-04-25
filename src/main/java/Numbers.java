package ie.william;

import java.util.Scanner;

public class Numbers {
	public static void main(String[] args) {
		
		double y = (3*9*(3+(9*3/(3))));
		System.out.println(y);
		double a = 20;
		double b = 2.3;
		System.out.println("Ans:" + (a % b));
		
		Scanner in = new Scanner(System.in);
		int num1;
		int num2;
		int sum;
		
		System.out.print("Enter first number: ");
		num1 = in.nextInt();
		
		System.out.print("Enter second number: ");
		num2 = in.nextInt();

		sum = num1 + num2;
		
		// Duplicate line - ALT + CMD + UP/DOWN
		
		System.out.printf("SUM: %d%n", sum);
	}
}

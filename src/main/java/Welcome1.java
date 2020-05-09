import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Purpose:
 * Program to print hello world string to console.
 * Also helps with remembering package organisation in Java.
 *
 * Author: William Walsh
 * Last Modified: 17-10-2019
 * */
public class Welcome1 {

	public static void main(String[] args) {
		System.out.print("Welcome Neo, \r");
		System.out.println("this is the matrix.");
		System.out.println("\"WOW   Escaped double quotes!!\"");
		//		CMD + F11 to run program
		//		CTRL + space to autocomplete

		System.out.printf( "%s%n%s%n", "Hello", "World");
		//		Format specifiers
		//		%s		string
		//		%n		newline character -> portable across systems  ** NB \n isn't **

		// Duplicate line - ALT + CMD + UP/DOWN
		// Import -> ctrl + ALT + o
		System.out.println(createSpreadsheetTitle());

	}

	public static String createSpreadsheetTitle() {

		LocalDate lastMonth = LocalDate.now().minusMonths(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM");
		return lastMonth.format(formatter);
	}

}

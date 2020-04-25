package sales;

import java.util.Scanner;

public class SalesInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str="";
        String[] pair;
        System.out.println("Enter the product ID <comma> product cost");
        System.out.println("E.g.      2345       <comma> 6.78");

        while ( in.hasNext()) {
            str = in.nextLine();
            pair = str.split(",");
            System.out.printf("ID: %s, Cost: %s\n", pair[0], pair[1]);
        }

        System.out.println( 10 == 10 );

    }

}

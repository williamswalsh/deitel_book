package searching;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchArrayTest {

    public static void main(String[] args) {
        int searchInt;
        int position;
        BinarySearchArray arr = new BinarySearchArray(200);
        Scanner in = new Scanner(System.in);
        System.out.println(Arrays.toString(arr.data));

        System.out.print("Please enter the integer you would like to search for: ");
        searchInt = in.nextInt();

        while (searchInt != -1)
        {
            System.out.print("Please enter the integer you would like to search for: ");
            searchInt = in.nextInt();
            position = arr.search(searchInt);

            if (position == -1) {
                System.out.println("Integer " + searchInt + " doesn't exist in array");
            } else {
                System.out.println("Integer " + searchInt + " exists in array at position: " + position);
            }
        }
    }
}

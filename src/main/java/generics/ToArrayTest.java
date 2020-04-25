package generics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to test the behaviour of the toArray() method.
 * If the array that is passed to the method is bigger or smaller that the original List
 * it has different behaviour.
 * <p>
 * Passed array is bigger -> newly created array is bigger size with null elements
 * Passed array is smaller -> newly created array is same size as list
 * <p>
 * So:
 * String[] size3 = list.toArray(new String[list.size()]);
 * String[] size3 = list.toArray(new String[1]);
 * have the same end effect.
 */
public class ToArrayTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("hello");
        list.add("hi");
        list.add("heya");
        list.add("ello");
        list.add("hey");
        list.add("Sup!");
        list.add("How ya doin, cant!");

        // List size 7
        // arr  size 3
        // Creates an array with the correct size -> not 3!
        String[] size3 = list.toArray(new String[3]);

        for (String s : size3)
            System.out.println(s);

        System.out.println();

        // List size 7
        // arr  size 23
        // Creates an array of size 23
        // Extra array elements refer to null
        String[] size23 = list.toArray(new String[23]);


        for (String s : size23)
            System.out.println(s);

        // Don't do this
        String[] softwareBooks = { "C++ for Dummies",
                "Java OCA SE7",
                "JS for Dummies",
                "Bash Linux Bible",
                "Java - Dietel",
                "Python Data Analysis",
                "Spring Web Framework 4",
                "The Mythical Man Month",
                "Software Design Patterns",
                "Clean Code",
                "The Pragmatic Programmer"};

        LinkedList<String> softwareBookList = new LinkedList<>(Arrays.asList(softwareBooks));

        String[] correct = softwareBookList.toArray(softwareBooks);
        System.out.println(Arrays.toString(correct));

        String[] b = {"A", "B", "C", "D","E", "F", "G", "H", "I", "J", "K", "L"};
        String[] incorrect = softwareBookList.toArray(b);
        System.out.println(Arrays.toString(incorrect));
        // LAST ELEMENT IS NULL NOT L
        // SEE OUTPUT FOR MORE DETAILS

    }
}

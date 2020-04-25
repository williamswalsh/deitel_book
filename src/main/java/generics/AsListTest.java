package generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class to test behaviour of Arrays.asList() method
 */
public class AsListTest {
    public static void main(String[] args) {
        Integer[] ints = { 33, 4 , 25, 67};
        List<Integer> intsList = Arrays.asList(ints);

        Collections.sort(intsList);
        for (Integer i : ints) {
            System.out.println(i);
        }
    }
}

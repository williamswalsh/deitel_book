package generics;

import java.util.*;

/**
 * This class will remove all elements that exist in both collections
 * from the collection colorList.
 */
public class CollectionTest {
    public static void main(String[] args) {
        // Create arrays
        String[] colors = {"red", "green", "blue", "yellow", "pink", "purple", "violet", "white", "black"};
        String[] removeColors = {"pink", "purple", "violet", "white", "black"};

        // Create Lists from arrays
        List<String> colorList = new ArrayList<>(Arrays.asList(colors));
        List<String> removeList = new ArrayList<>(Arrays.asList(removeColors));

        printCollection(colorList);
        printCollection(removeList);

        removeColors(colorList, removeList);

        printCollection(colorList);
        printCollection(removeList);
    }

    private static void removeColors(Collection<String> total, Collection<String> remove) {

        // Get iterator from total collection
        Iterator<String> iterator = total.iterator();

        // Iterate through total collection
        while (iterator.hasNext()) {

            // If the remove collection contains the current element
            if (remove.contains(iterator.next())) {

                // Remove element from total collection
                iterator.remove();
            }
        }
    }


    /**
     * Print a collection.
     * toString() method is used to get a representation for the object
     *
     * @param collection
     */
    private static void printCollection(Collection collection) {
        for (Object s : collection) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

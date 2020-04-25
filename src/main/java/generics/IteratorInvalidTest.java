package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IteratorInvalidTest {
    public static void main(String[] args) {
        Collection<String> babyNames = new ArrayList<String>();
        babyNames.add("Tom");
        babyNames.add("Stephen");
        babyNames.add("Toddy");
        babyNames.add("John");
        babyNames.add("Donal");

        Iterator i = babyNames.iterator();

        // Modifying collection after iterator is created
        babyNames.remove("Tom");
        babyNames.remove("Stephen");

        while (i.hasNext()){
            System.out.println(i.next());       // Throws ConcurrentModificationException
        }

        // You can modify a list with an iterator.remove() command
        // This won't cause a ConcurrentModificationException
    }
}

package generics;

import java.util.*;

public class ComparatorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(44);
        list.add(4);
        list.add(42);
        list.add(24);
        list.add(4);
        list.add(18);
        list.add(90);
        list.add(0);
        list.add(16);

        // Descending order sort
        Collections.sort(list, new DescendingComparator());

        // Collections has a method to return a descending Comparator
        // No need to create your own Comparator
        Collections.sort(list, Collections.reverseOrder());

        // Ascending/ Natural order sort
//        Collections.sort(list);

        for (Integer i:list) {
            System.out.println(i);
        }

    }

}
class DescendingComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        // Just invert the natural compare to
        return o1.compareTo(o2) * -1;
    }
}

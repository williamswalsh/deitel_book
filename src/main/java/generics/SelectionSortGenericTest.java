package generics;

import sorting.SelectionSortArray;

public class SelectionSortGenericTest {
    public static void main(String[] args) {
        SelectionSortGeneric app = new SelectionSortGeneric(1000, 1000);

        // Passing the generic method an array of Integers
        printArray(app.ints);
        app.selectionSort(app.ints);
        printArray(app.ints);

        // Passing the generic method an array of Doubles
        printArray(app.doubles);
        app.selectionSort(app.doubles);
        printArray(app.doubles);
    }

    private static <T> void printArray(T[] data){
        for (T elem:data) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }
}

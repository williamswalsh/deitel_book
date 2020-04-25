package generics;

import java.util.Random;

public class SelectionSortGeneric {

    public Integer[] ints;
    public Double[] doubles;
    private Random rand;


    public SelectionSortGeneric(int size, int bound) {
        ints = new Integer[size];
        doubles = new Double[size];
        rand = new Random();

        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(bound);
            doubles[i] = rand.nextDouble() * bound;
        }
    }

    protected <T extends Comparable<T>> void selectionSort(T[] data) {
        int smallestIndex;

        for (int i = 0; i < data.length; i++) {
            smallestIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[smallestIndex]) < 0) {
                    smallestIndex = j;
                }
            }
            swap(data, i, smallestIndex);
        }
    }

    private <T> void swap(T[] data, int first, int second) {
        T tmp = data[first];
        data[first] = data[second];
        data[second] = tmp;
    }
}

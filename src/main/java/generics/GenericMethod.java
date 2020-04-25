package generics;

public class GenericMethod {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{4,12, 46, 77, 7};
        printArray(ints);

        Double[] dbls = new Double[]{4.345,12.12312, 46.23432, 77.3424242, 7.23};
        printArray(dbls);
    }


    private static <T> void printArray(T[] array){
        for( T element: array){
            System.out.println(element);
        }
        System.out.println();
    }
}

package mathsy;

public class Polarity {

    public static void main(String[] args) {
        int num = 2;
        System.out.printf("Is %d even: %b", num, isEven(num));
    }



    private static boolean isEven(int i){
        return ( i % 2 == 0 )? true : false;
    }

    private static boolean isOdd(int i){
        return ( i % 2 == 1 )? true : false;
    }

    // Less performant
    // More pretty :-D
    // Can swap both functions meaning more simply
    // Use case for doing this swap is an huge edge case
    // Not using this method
    // more cost than benefit

//    private static boolean isOdd(int i){
//        return !isEven(i);
//    }
}

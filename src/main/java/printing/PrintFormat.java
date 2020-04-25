package printing;

public class PrintFormat {
    public static void main(String[] args) {

        // %050d -> prefix 0's up to 50 spaces if blank
        // %8d -> right align to 8 spaces
        // %9.2 -> 9 digts before decimal point
        //      -> 2 digits after decimal point
        System.out.printf("%050d %8d %9.2f", 10000, 30, 778687898.8768);
        System.out.println();

    }
}

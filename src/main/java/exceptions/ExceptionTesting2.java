package exceptions;

public class ExceptionTesting2 {

    public static void main(String[] args) throws Exception {
        Exception e = new Exception("This is my msg.");
        System.out.println("e: " + e);
        System.out.println("e.getMessage(): " + e.getMessage());


        // Passing Exception objects to Logger.<log_level>





    }

}

package assertions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyAssertions {

    public static void main(String[] args) throws IOException {

        fx1(100);
        fx1(100);
        boolean expression = true;


        // 1 -> If true no Error - Otherwise AssertionError
        assert expression;

        // 2 -> with error string
        assert !expression : "This is an error string.";
    }


    public static void fx1(int in) throws FileNotFoundException, IOException {
        if (in > 10) {
            throw new FileNotFoundException("in > 10");
        } else {
            throw new IOException("in !> 10");
        }
    }
}

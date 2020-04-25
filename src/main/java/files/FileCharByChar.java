package files;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileCharByChar {
    public static void main(String[] args) {

        int i;
        try (InputStream inputStream = new FileInputStream("read_char_by_char.txt")) {

            while ((i = inputStream.read()) != -1) {
                char c = (char) i;
                System.out.print(c + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

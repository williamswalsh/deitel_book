package http;

import org.bouncycastle.util.encoders.UrlBase64;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTesting {
    public static void main(String[] args) throws IOException {

//        Create URL
        URL url = new URL("https://www.google.ie/");

//        Create inputStream & inputStreamReader & associate the objects
        try (InputStream inputStream = url.openStream(); InputStreamReader reader = new InputStreamReader(inputStream)) {

//            Read a character
            int data = reader.read();

//            Loop until end of file character detected
            while (data != -1) {
//                Cast to char data type
                char theChar = (char) data;
                System.out.print(theChar);
                data = reader.read();
            }
        }
    }
}

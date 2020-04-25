package persisting_data;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLDecoding {

    private static final String SERIALIZED_FILE_NAME = "dvd.xml";

    public static void main(String[] args) throws FileNotFoundException {

        DVD bourneSeries = null;

        Object obj = decodeFromXMLFile(SERIALIZED_FILE_NAME);
        if (obj instanceof DVD) {
            bourneSeries = (DVD) obj;
        }
        if (bourneSeries != null) {
            System.out.println(bourneSeries.getMovies().get(3).getName());
        }
    }


    public static Object decodeFromXMLFile(String fileName) throws FileNotFoundException {
        Object object = null;

        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName))) {
            object = decoder.readObject();
        }
        return object;
    }
}
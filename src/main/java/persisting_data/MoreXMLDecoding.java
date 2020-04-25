package persisting_data;

import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MoreXMLDecoding {
    public static void main(String[] args) throws FileNotFoundException {

        //String -> Byte[]
        String a = "hello world";
        byte[] byteArr = a.getBytes();


        // Create XML decoder from input stream
        final InputStream xmlStream = new FileInputStream("ABC.txt");
        final XMLDecoder xmlDecoder = new XMLDecoder(xmlStream);
    }


    public static List ObjectXmlDecoder(String objSource) throws FileNotFoundException, IOException, Exception {
        List objList = new ArrayList();
        File fin = new File(objSource);
        FileInputStream fis = new FileInputStream(fin);
        XMLDecoder decoder = new XMLDecoder(fis);
        Object obj = null;//from   w ww  . j  a v a2  s.co  m
        try {
            while ((obj = decoder.readObject()) != null) {
                objList.add(obj);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
        fis.close();
        decoder.close();
        return objList;
    }





    // Genereic to Object type from xml decoder
    public static <T> T toObjectWithXMLDecoder(final String xmlString) {

        XMLDecoder dec = null;
        T obj = null;
        try {
            final InputStream is = new ByteArrayInputStream(xmlString.getBytes());
            dec = new XMLDecoder(is);

            obj = (T) dec.readObject();

        } finally {
            if (dec != null) {
                dec.close();
            }
        }
        return obj;
    }
}

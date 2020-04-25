package generics;

import java.io.*;
import java.util.*;

public class PropertiesTest {

    public static void main(String[] args) {

        String[] strs = { "a", "b"};
        new LinkedList<>(Arrays.asList(strs));
        Properties globalAppProps = new Properties();
        globalAppProps.setProperty("smtp_host", "10.80.10.80");
        globalAppProps.setProperty("smtp_user", "D|GiT@rwhy");
        globalAppProps.setProperty("smtp_pwd", "12389900sfdfsfd");

        System.out.println("Smtp User: " + globalAppProps.getProperty("smtp_user"));

        storeProperties(globalAppProps);
        globalAppProps.clear();

        System.out.println("Smtp User: " + globalAppProps.getProperty("smtp_user"));

        loadProperties(globalAppProps);

        System.out.println("Smtp User: " + globalAppProps.getProperty("smtp_user"));
    }


    private static void storeProperties(Properties props) {
        try (FileOutputStream fos = new FileOutputStream("props.dat")) {
            props.store(fos, "Global Properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saving properties to file complete");
    }

    private static void loadProperties(Properties props) {
        try(FileInputStream fis = new FileInputStream("props.dat")){
            props.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("Loading properties from file complete");
    }
}
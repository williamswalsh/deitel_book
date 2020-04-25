package mathsy;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hypotenuse {
    public static void main(String[] args) {
        String filePath = "/Users/will/repository/Java - Deitel/Chpt_3/src/main/resources/test.csv";
        List<MyPair> pairs = readCSVPairFromFile(filePath);

        int possibleMultiple;
        int multiplicand;

        for (MyPair pair : pairs) {

            possibleMultiple = pair.getA();
            multiplicand = pair.getB();

            System.out.printf("Is  multiple:\t%b\n", isMultiple(possibleMultiple, multiplicand));
        }
    }

    private static List<MyPair> readCSVPairFromFile(String filePath) {

        List<MyPair> pairs = new ArrayList<>();
        String[] line;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {

            while ((line = csvReader.readNext()) != null) {
                pairs.add(new MyPair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }
        } catch (FileNotFoundException ioe) {
            System.out.println("[ERROR] - FileNotFoundException - CSV File " + filePath + " not found");
            return new ArrayList<MyPair>();
        } catch (IOException ioe) {
            System.out.println("[ERROR] - IOException - CSV File " + filePath);
            return new ArrayList<MyPair>();
        }
        return pairs;
    }

    private static double calcHypotenuse(double side1, double side2) {
        // hypotenuse = sqrt( side1 ^ 2 + side2 ^ 2 )
        return Math.sqrt(Math.pow(side1, 2.0) + Math.pow(side2, 2.0));
    }

    private static boolean isMultiple(int possibleMultiple, int multiplicand) {
        if (((double) possibleMultiple % multiplicand) == 0.0) {
            return true;
        }
        return false;
    }


    private static boolean printIsMultiple(int possibleMultiple, int multiplicand) {
        if (((double) possibleMultiple % multiplicand) == 0.0) {
            return true;
        }
        return false;
    }
}

class MyPair {
    private int a;
    private int b;

    public MyPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

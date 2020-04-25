package generics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class LetterDistribution {
    public static void main(String[] args) {
        String filePath = "character_distribution.txt";
        char[] chars = getCharsfromFile(filePath);

        HashMap<Character, Integer> charDist = new HashMap<>();

        for (char c : chars) {
            if (charDist.containsKey(c)) {
                int count = charDist.get(c);
                charDist.put(c, ++count);
            } else {
                charDist.put(c, 1);
            }
        }

        Set<Character> keys = charDist.keySet();
        for(Character character: keys){
            System.out.println("Letter: " + character + ", Occurrences: " + " " + charDist.get(character));
        }
        System.out.println("Total Number of characters used: " + keys.size());
    }

    private static char[] getCharsfromFile(String filePath) {
        StringBuilder fileData = new StringBuilder(1000);
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            char[] buf = new char[10];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[1024];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData.toString().toCharArray();
    }
}


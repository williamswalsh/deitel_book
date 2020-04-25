package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PatternAndMatcher {
    public static void main(String[] args) {

        // If only using regex expression once just use Pattern. matches
        boolean result = Pattern.matches("\\d{5}", "56788");
        System.out.println(result);

        // If you are using a regex to match something several times
        // Use Pattern.compile once at beginning
        // Pattern.matches is an expensive operation if scaled
        // Matcher.matches(); -> is designed for repeated use


        // 1
        // Learn this strange method
        Pattern pattern = Pattern.compile("\\w{5}");
        Matcher matcher = pattern.matcher("string to match");
        System.out.println(matcher.matches());



        // 2
        // Pass the pattern & new string
        matcher = pattern.matcher("12345");
        System.out.println(matcher.matches());
    }
}

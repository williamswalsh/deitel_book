package strings;

public class Regexes {
    public static void main(String[] args) {

        String salutation = new String("These are my school stars: * * * * *");
        System.out.println(salutation.replaceAll("\\*", "&"));

    }
}

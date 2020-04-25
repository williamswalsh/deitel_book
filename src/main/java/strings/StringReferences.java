package strings;

public class StringReferences {
    public static void main(String[] args) {

        String a = "Hello World";
        String b = "Hello World";

        System.out.println(b.equals(a));    // TRUE
        //  deepcode ignore StringEquals: This is an intentional use of == to compare String references
        System.out.println(b == a);         // TRUE -> Same object being referenced
        // String literals don't define a new string in memory if one exists already with same string literal

        String c = new String("Hello World");
        String d = new String("Hello World");

        System.out.println(c.equals(d));    // TRUE
        System.out.println(c == d);         // FALSE
        // -> How the strings are defined new String creates a new object with distinct ref
        // References are not equal


        // String Concatenation
        String e = "hello";

        // New String object created
        e = e + " world";
        System.out.println(e);


        String f = "hi";
        String g = "World";
        System.out.println(f.concat(g));
        System.out.println(f);  // f remains unchanged

    }
}

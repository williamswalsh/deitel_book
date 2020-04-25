public class StaticClassWideVars {

    // Static primitive variables are initialised to their defaults int -> 0, float -> 0.0, boolean -> false, str -> null
    static int x;
    private static int privateX;
    static String str;
}
class JustForMain{
    public static void main(String[] args) {
        // Static vars can be accessed before any object of the class are created ** NB
        StaticClassWideVars.x= 44;

        // Private static variable cannot be accessed outside defining class
        // StaticClassWideVars.privateX = 3;
    }
}

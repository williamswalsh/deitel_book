package contained_classes;

public class StaticNestedClassTest {
    public static void main(String[] args) {
//        Note how you "construct" the inner static class
        StaticNestedClassExample.StaticNestedClass example = new StaticNestedClassExample.StaticNestedClass();


        StaticNestedClassExample.StaticNestedClass sic1 = new StaticNestedClassExample.StaticNestedClass();
        StaticNestedClassExample.StaticNestedClass sic2 = new StaticNestedClassExample.StaticNestedClass();

        sic1.var = 10;
        System.out.println(sic2.var);
    }
}

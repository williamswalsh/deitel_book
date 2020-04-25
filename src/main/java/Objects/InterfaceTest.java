package Objects;

public class InterfaceTest implements Payable {
    public static void main(String[] args) {

    }

    @Override
    public String abstractMethod(String string) {
        return string + this.getClass().getName();
    }
}

interface Payable{

    // Implicitly abstract
    String abstractMethod(String string);

    public static final int publicStaticFinalVar = 10000;

//    void concreteMethod(String string){
//        System.out.println("hey");
//    }
}

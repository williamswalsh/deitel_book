package Objects;

public class InstanceOfTesting {
    public static void main(String[] args) {

        // Super variable storing subclass reference
        C object = new D();
        object.hey();
        if (object instanceof D) {

            // Have to downcast to refer to variables only in subclass
            // Don't Have to downcast to refer to overridden methods in subclass -> Polymorphism
            ((D) object).x = 10;
            System.out.println("the d");
        }

        System.out.println("My object is of type: " + object.getClass().getName());
    }
}

class C{
    int common;
    int y;
    void hey(){
        System.out.println("Hello World");
    }
}

class D extends C{

    // Same variable in sub & super hides super variable in subclass
    int common;
    int x;

    @Override
    void hey(){
        System.out.println("Yo World");
    }
}

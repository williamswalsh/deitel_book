package inheritance;

public class A {

    public void print() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        A a1 = new A();
        a1.print(); // Guess: A

        A a2 = new B();
        a2.print(); // Guess: B

        B b1 = new B();
        b1.print(); // Guess: B
    }
}


class B extends A {

    @Override
    public void print() {
        System.out.println("B");
    }
}
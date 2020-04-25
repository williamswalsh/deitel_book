package Objects;

public class ObjectMethods {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(10,"hey");
        A a2 = (A)a.clone();
        System.out.println(a2.y + " " + a2.x);

        System.out.println(a);
    }
}

class A{
    int x;
    String y;

    A(int x, String y){
        this.x = x;
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new A(this.x,this.y);
    }
}
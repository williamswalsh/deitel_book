package constructors;

public class Construct1 {
    public static void main(String[] args) {
        A a1 = new A(5);
        System.out.println(a1.num);

        A a2 = new A();
        System.out.println(a2.num);


        a2.test();
    }
}

class A{
    int num;
    public A (int x){
        num = x;
    }
    public A (){
//        Call to other constuctor must be 1st line -> sout will break constructor
//        System.out.println("default");
        this(0);
    }


    public void test(){
//        Cannot call constructor from method static or non-static
//        Doesn't make sense
//        this();
    }
}

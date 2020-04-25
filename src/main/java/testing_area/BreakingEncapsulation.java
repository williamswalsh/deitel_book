package testing_area;



public class BreakingEncapsulation {
    public static void main(String[] args) {
        Example e = new Example();
        e.setA(111);

        Example e2 = new Example(e);
        System.out.println(e2.getA());
    }
}

class Example{
    private int a;

    public Example() {}

    public Example(Example toCopy){

// 2 objects of same time can refer to their fields even if private

        this.setA(toCopy.a);
//        Should be this.setA(toCopy.getA());
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

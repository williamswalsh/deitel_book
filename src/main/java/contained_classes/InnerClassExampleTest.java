package contained_classes;

public class InnerClassExampleTest {
    public static void main(String[] args) {

        InnerClassExample.PublicX publicX = new InnerClassExample().new PublicX();
        InnerClassExample.PublicX publicX2 = new InnerClassExample().new PublicX();

        InnerClassExample.ProtectedX protectedX = new InnerClassExample().new ProtectedX();

        InnerClassExample.PackagePrivateX packagePrivateX = new InnerClassExample().new PackagePrivateX();

//        Cannot refer to private class outside of class body code
//        InnerClassExample eg = new InnerClassExample();
//        InnerClassExample.PrivateX privateX = new InnerClassExample().new PrivateX();
//        InnerClassExample.PrivateX privateX2 = eg.new PrivateX();
    }
}

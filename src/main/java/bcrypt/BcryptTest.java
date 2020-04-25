package bcrypt;

public class BcryptTest {
    public static void main(String[] args) {
        DefaultBcryptProvider b = new DefaultBcryptProvider();

        // generate salt
        String salt = b.generateSalt(4);
        System.out.printf("Hashed Password: %s, Password: %s", b.hashPassword(args[0], salt), args[0]);
    }

}


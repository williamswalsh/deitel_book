package patterns;

public class Test {
    public static void main(String[] args) {

        BankAccount account = new BankAccount.Builder(12345)
                .atBranch("Listowel")
                .atRate(0.03)
                .openingBalance(2000.00)
                .withOwner("William Walsh")
                .build();
        
    }

}

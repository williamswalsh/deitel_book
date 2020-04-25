package department_store;

public class AccountTest {
    public static void main(String[] args) {
        Customer c1 = new Customer("William", "Walsh");
        Customer c2 = new Customer("Peter", "Griffin");
        Customer c3 = new Customer("Ciaran", "Mckenna");

        c1.getCustomerAccount().setBalance(100.00);
        c1.getCustomerAccount().setTotalCreditApplied(100.00);
        c1.getCustomerAccount().setTotalItemsCharged(160.00);
        System.out.printf("Credit Limit Exceeded: %b", c1.getCustomerAccount().isCreditLimitExceeded());

    }
}

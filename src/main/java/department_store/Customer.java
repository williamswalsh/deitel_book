package department_store;

public class Customer extends human.Human{

    private Account customerAccount;

    public Customer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        customerAccount = new Account();
    }

    public Customer(String firstName, String lastName, int age, Account account) {
        super(firstName, lastName, age);
        customerAccount = account;
    }

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
        customerAccount = new Account();
    }

    public Customer(String firstName, String lastName, Account account) {
        super(firstName, lastName);
        customerAccount = account;
    }

    public Account getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(Account customerAccount) {
        this.customerAccount = customerAccount;
    }
}

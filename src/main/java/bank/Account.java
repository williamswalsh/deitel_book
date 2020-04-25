package bank;

public class Account {
    private double balance;
    private String name;

    public Account(String name) {
        setName(name);
    }
    public Account(String name, double deposit) {
        setName(name);
        deposit(deposit);
    }

    public void setName(String name) {
        // Shortcircuiting OR operator important here to avoid NPE's
        if (name == null || name.isEmpty()) {
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0.0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > balance){
            System.out.printf("Debit amount: %f exceeded account balance: %f. Cancelling...\n", amount, balance);
            return;
        }

        if (amount > 0.0) {
            this.balance -= amount;
            // Output cash
            return;
        }
        System.out.printf("Withdrawal amount %f must be greater than 0. Cancelling...", amount);
    }

    public void displayBalance() {
        // Print balance to 2 decimal places
        System.out.printf("%s's balance is: %.2f\n", getName(), getBalance());
    }
}


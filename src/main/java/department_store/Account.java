package department_store;

import logic.Test;

public class Account {

    private String accountNo;
    private double balance;
    private double totalItemsCharged;
    private double totalCreditApplied;
    private double creditLimit;

    // Do I want to be able to call the default constructor like this?
    public Account() {
        this.setBalance(0.0);
        this.setTotalItemsCharged(0.0);
        this.setTotalCreditApplied(0.0);
        this.setCreditLimit(-20.00);
    }

    public Account(String accountNo, double balance, double creditLimit) {

        // Defaults values applied
        this();
        this.accountNo = accountNo;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    public Account(String accountNo, double balance, double totalItemsCharged, double totalCreditApplied, double creditLimit) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.totalItemsCharged = totalItemsCharged;
        this.totalCreditApplied = totalCreditApplied;
        this.creditLimit = creditLimit;
    }

    public boolean isCreditLimitExceeded() {
        if ((this.balance + this.totalCreditApplied - this.totalItemsCharged) > this.creditLimit){
            return false;
        }else{
            return true;
        }
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        if (Test.isNotNullOrEmpty(accountNo)) {
            this.accountNo = accountNo;
        } else {
            // Log error
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        // You can start with a +'ve /-'ve balance
        this.balance = balance;
    }

    public double getTotalItemsCharged() {
        return totalItemsCharged;
    }

    public void setTotalItemsCharged(double totalItemsCharged) {
        this.totalItemsCharged = totalItemsCharged;
    }

    public double getTotalCreditApplied() {
        return totalCreditApplied;
    }

    public void setTotalCreditApplied(double totalCreditApplied) {
        this.totalCreditApplied = totalCreditApplied;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    protected void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}

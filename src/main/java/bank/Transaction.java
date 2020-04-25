package bank;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String accountNo;
    private double amount;
    private String sender;
    private String receiver;

    public Transaction(String accountNo, double amount, String sender, String receiver) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountNo='" + accountNo + '\'' +
                ", amount=" + amount +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                '}';
    }
}
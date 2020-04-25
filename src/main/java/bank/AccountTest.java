package bank;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {

    public static void main(String[] args) {

        Account account1 = new Account("account1");
        Account account2 = new Account("account2",781.98);
        Account account3 = new Account("account3",10865.86);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        for (Account a: accountList){
            a.displayBalance();
        }
        System.out.println();

        account1.deposit(30.00);
        account2.deposit(1206.00);
        account3.deposit(3400.00);

        for (Account a: accountList){
            a.displayBalance();
        }
        System.out.println();

        account1.withdraw(8.00);
        account2.deposit(676.00);
        account3.deposit(3400.00);

        for (Account a: accountList){
            a.displayBalance();
        }
        System.out.println();
    }
}

package files;

import sun.lwawt.macosx.CSystemTray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreditInquiry {


    private MenuOptions accountType;
    private Scanner in;
    private final static MenuOptions[] choices = {MenuOptions.ZERO_BALANCE, MenuOptions.DEBIT_BALANCE, MenuOptions.CREDIT_BALANCE, MenuOptions.END};

    private void readRecords() {
        AccountRecord record = new AccountRecord();

        try {
            in = new Scanner(new File("clients.txt"));

            while (in.hasNext()) {
                record.setAccount(in.nextInt());
                record.setFirstName(in.next());
                record.setLastName(in.next());
                record.setBalance(in.nextDouble());

                if (shouldDisplay(record.getBalance())) {
                    System.out.printf("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
                }
            }

        } catch (NoSuchElementException nsee) {
            System.err.println("File not correctly formatted.");
            in.close();
            System.exit(1);
        } catch (IllegalStateException ise) {
            System.err.println("Error reading from file.");
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("File cannot be found.");
            System.exit(1);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private boolean shouldDisplay(double balance) {
        if ((accountType == MenuOptions.CREDIT_BALANCE) && balance < 0) {
            return true;
        } else if ((accountType == MenuOptions.DEBIT_BALANCE) && balance > 0) {
            return true;
        } else if ((accountType == MenuOptions.ZERO_BALANCE) && balance == 0) {
            return true;
        }
        return false;
    }


    private MenuOptions getRequest() {

        Scanner in = new Scanner(System.in);
        int request = 1;

        System.out.printf("\n%s\n%s\n%s\n%s\n", "Please enter account type request",
                "1 - List account balances with Zero balances",
                "2 - List account balances with credit balances",
                "3 - List account balances with debit balances", "4 - end application");

        try{
            do{
                System.out.println("\n?");
                request = in.nextInt();
            }while( request > 4 || request < 0);
        }catch (NoSuchElementException nsee){
            System.err.println("invalid input");
            System.exit(1);
        }
        return choices[request -1]; // 0 index
    }

    public void processRequests(){
        accountType = getRequest();

        while(accountType != MenuOptions.END){
            switch (accountType){
                case ZERO_BALANCE:
                    System.out.printf("Accounts with Zero Balances:\n");
                    break;
                case CREDIT_BALANCE:
                    System.out.printf("Accounts with credit Balances:\n");
                    break;
                case DEBIT_BALANCE:
                    System.out.printf("Accounts with debit Balances:\n");
                    break;
            }
            readRecords();
            accountType = getRequest();
        }

    }
}

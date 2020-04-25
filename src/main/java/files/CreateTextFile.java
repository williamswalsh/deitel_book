package files;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    private Formatter out;

    public void openFile(String fileName) {
        try {
            out = new Formatter(fileName);
        } catch (SecurityException se) {
            System.out.println("You don't have write access to this file.");
            System.exit(1);
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found.");
            System.exit(1);
        }
    }

    public void addRecords(){
        AccountRecord record = new AccountRecord();

        Scanner in = new Scanner(System.in);

        System.out.println("To terminate input enter EOF character -> MacOS -> <ctrl> d <enter>");
        System.out.println("Enter account #, first name, last name & balance");

        while ( in.hasNext()){
            try{
                record.setAccount(in.nextInt());
                record.setFirstName(in.next());
                record.setLastName(in.next());
                record.setBalance(in.nextDouble());

                if ( record.getAccount() > 0){
                    out.format("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
                }else{
                    System.out.println("Account # must be greater than 0.");
                }
            }catch (FormatterClosedException fce){
                System.err.println("Error writing to file.");
                return;
            }catch (NoSuchElementException nsee){
                System.err.println("Invalid input please try again.");
                in.nextLine();
            }

            System.out.printf("%s %s\n%s", "Enter account number (>0),", "first name, lastname & balance", "?");
        }
    }
    public void closeFile(){
        if(out != null){
            out.close();
        }
    }
}





























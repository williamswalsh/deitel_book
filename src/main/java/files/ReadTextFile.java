package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
    private Scanner in;

    public void openFile(){
        try{
            in = new Scanner(new File("clients.txt"));      // File located in root of project
            // in = new Scanner(new File("./clients.txt"));           // File located in root of project
            // in = new Scanner(new File("./src/main/java/files/clients.txt"));     // File located in same dir
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public void readRecords(){
        AccountRecord record = new AccountRecord();
        System.out.printf("%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance");

        try {
            while (in.hasNext()) {
                record.setAccount(in.nextInt());
                record.setFirstName(in.next());
                record.setLastName(in.next());
                record.setBalance(in.nextDouble());

                System.out.printf("%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
            }
        }catch(NoSuchElementException nsee){
            System.err.println("File not correctly formatted.");
            in.close();
            System.exit(1);
        }catch (IllegalStateException ise){
            System.err.println("Error reading from file.");
            System.exit(1);
        }
    }

    public void closeFile(){
        if( in != null){
            in.close();
        }
    }
}

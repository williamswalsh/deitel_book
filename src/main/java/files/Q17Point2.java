package files;

import bank.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Q17Point2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("oldmast.txt")); // Searches in project root
        // /Users/will/repository/Java - Deitel/Chpt_3/src/main/java/files/oldmast.txt
        in.close();

        Formatter out = new Formatter(new File("output.txt")); // Searches in project root
        out.format("Write this to a file.");

        // If you don't close the formatter it won't update the file
        if (out != null) {
            out.close();
        }
        Transaction transaction = null;
        ArrayList<Transaction> transactions = new ArrayList<>();
        in = new Scanner(new File("trans.txt"));
        while (in.hasNext()) {
            transaction = new Transaction(
                    in.next(),
                    in.nextDouble(),
                    in.next(),
                    in.next());

            transactions.add(transaction);
            System.out.println(transaction);
        }
        in.close();
    }
}

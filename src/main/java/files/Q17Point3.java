package files;

import bank.Transaction;

import java.io.*;

public class Q17Point3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Transaction t1 = new Transaction("238", 30.78, "William Walsh", "James O Conner");
        Transaction t2 = new Transaction("238", 30.78, "William Walsh", "James O Conner");
        File file = new File("transactions.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);
        oos.writeObject(t2);
        oos.close();fos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("transactions.txt")));
        t1 = (Transaction) ois.readObject();
        t2 = (Transaction) ois.readObject();
        System.out.println(t1);
        System.out.println(t2);


    }
}

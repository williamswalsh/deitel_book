package persisting_data.serial_version_uid;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Phone p = new Phone();
        p.setType("SmartPhone");
        FileOutputStream fos = new FileOutputStream("/Users/will/file.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(p);
        oos.close();

        Object o = readIn();
        p = (Phone)o;
        System.out.println(p.getType());
    }

    private static Object readIn() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/Users/will/file.ser")));
        return ois.readObject();
    }
    private static void writeOut(java.io.Serializable obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/Users/will/file.ser")));
        oos.writeObject(obj);
        oos.close();
    }
}

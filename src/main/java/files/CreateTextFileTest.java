package files;

public class CreateTextFileTest {
    public static void main(String[] args) {
        CreateTextFile app = new CreateTextFile();
        app.openFile("clients.txt");
        app.addRecords();
        app.closeFile();
    }
}

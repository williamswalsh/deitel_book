package networking.fileserver;

public class FileClientTest {
    public static void main(String[] args) {
        FileClient fileClient = new FileClient("localhost");
        fileClient.run();
    }
}

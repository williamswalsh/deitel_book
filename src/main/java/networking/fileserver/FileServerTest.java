package networking.fileserver;

public class FileServerTest {
    public static void main(String[] args) {
        FileServer fileServer = new FileServer();
        fileServer.listenForConnections();
    }
}

package networking.fileserver;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends JFrame {
    private ServerSocket serverSocket;
    private Socket socket;
    private final int port = 7777;

    public FileServer() {
        super();

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Failed to start server on port: " + port);
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Transfer Server");
        setSize(400, 400);
        setVisible(true);
    }

    protected void run() {


    }
    protected void listenForConnections() {
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("There was an exception while accepting client connections");
            System.exit(0);
        }
    }

}

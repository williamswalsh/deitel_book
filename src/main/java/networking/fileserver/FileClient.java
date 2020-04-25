package networking.fileserver;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient extends JFrame {
    private Socket socket;
    private int port = 7777;
    private InetAddress serverHost;

    public FileClient(String server) {
        super();

        try {
            serverHost = InetAddress.getByName(server);
        } catch (UnknownHostException e) {
            System.out.println("The server hostname: " + serverHost + " was unrecognized.");
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Transfer Client");
        setSize(400, 400);
        setVisible(true);
    }


    protected void run() {
        try {
            connectToServer();
        } catch (IOException e) {
            System.out.println("Issue while creating client socket.");
        }
    }

    protected void connectToServer() throws IOException {
        socket = new Socket(serverHost, port);
        System.out.println("Connected to Server: " + serverHost.getHostName() + " at address: " + serverHost.getHostAddress());
    }
}

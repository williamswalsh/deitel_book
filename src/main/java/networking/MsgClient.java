package networking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MsgClient extends JFrame {

    private JTextField msgView;
    private JTextArea chatView;
    private Socket socket;
    private String chatServer;
    private String clientMsgPrefix;

    //    I/O Streams
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public MsgClient(String host) {
        super();


//        Valurise declared members
        chatServer = host;
        clientMsgPrefix = "CLIENT: ";
        msgView = new JTextField("Please enter your message here:");
        msgView.setEditable(false);
        chatView = new JTextArea();

//        Add component listeners
        msgView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData(e.getActionCommand());
                msgView.setText("");
            }
        });

//        Add components to JFrame
        add(msgView, BorderLayout.NORTH);
        add(new JScrollPane(chatView), BorderLayout.CENTER);

//        JFrame settings
        setSize(400, 400);
        setVisible(true);
    }

    protected void runClient() {
        try {
            connectToServer();
            getStreams();
            processConnection();
        } catch (EOFException e) {
            displayMsg(clientMsgPrefix + "Client terminated connection");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void connectToServer() throws IOException {
        displayMsg(clientMsgPrefix + "Initiating Connection");
        socket = new Socket(InetAddress.getByName(chatServer), 7777);
        displayMsg(clientMsgPrefix + "Connecting to " + socket.getInetAddress().getHostName());
    }

    private void getStreams() throws IOException {
        displayMsg(clientMsgPrefix + "Getting I/O Streams");
        inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.flush();       // Provides header details to Client -> Object ServialVersionID data
        displayMsg(clientMsgPrefix + "I/O Streams attained");
    }

    private void processConnection() throws IOException {
        String msg = "Connection Successful";
        sendData(clientMsgPrefix + msg);
        setTextFieldEditable(true);

        do {
            try {
                msg = inputStream.readObject().toString();
                displayMsg("" + msg);
            } catch (ClassNotFoundException e) {
                displayMsg("Unknown object type received");
            }
        } while (!msg.equals("SERVER: TERMINATE"));
    }

    private void sendData(String msg) {
        try {
            outputStream.writeObject(clientMsgPrefix + msg);
            outputStream.flush();
            displayMsg(clientMsgPrefix + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            displayMsg(clientMsgPrefix + "Closing IO Streams and client socket");
            setTextFieldEditable(false);
            outputStream.close();
            inputStream.close();
            socket.close();
            displayMsg(clientMsgPrefix + "IO Streams & client socket closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMsg(final String msgToDisplay) {
        SwingUtilities.invokeLater(() -> chatView.append("\n" + msgToDisplay));
    }

    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(() -> msgView.setEditable(editable));
    }
}
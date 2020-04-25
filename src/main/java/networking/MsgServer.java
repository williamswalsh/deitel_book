package networking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MsgServer extends JFrame {

    private String serverMsgPrefix = "SERVER: ";
    private JTextField msgView;
    private JTextArea chatView;
    private ServerSocket serverSocket;
    private Socket socket;
    private int counter = 1;

    //    I/O Streams
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public MsgServer() {
        super();

//        Valurise declared components
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

    protected void runServer(){
        try{
            serverSocket = new ServerSocket(7777, 100);

            while(true){
                try{
                    waitForConnection();
                    getStreams();
                    processConnection();
                }catch(EOFException e){
                    displayMsg(serverMsgPrefix + "terminated connection");
                }finally {
                    closeConnection();
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitForConnection() throws IOException {
        displayMsg(serverMsgPrefix + "Waiting for connection");
        socket = serverSocket.accept();
        displayMsg(serverMsgPrefix + "Connection number: " +  counter +" received from: " + socket.getInetAddress().getHostAddress());
    }

    private void getStreams() throws IOException {
        displayMsg("Getting I/O Streams");

        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.flush();       // Provides header details to Client -> Object ServialVersionID data

        inputStream = new ObjectInputStream(socket.getInputStream());
        displayMsg("I/O Streams attained");
    }

    private void processConnection() throws IOException {
        String msg = "Connection Successful";
        sendData(msg);
        setTextFieldEditable(true);

        do{
            try {
                msg = inputStream.readObject().toString();
                displayMsg(msg);
            } catch (ClassNotFoundException e) {
                displayMsg("Unknown object type received");
            }
        }while(!msg.equals("CLIENT: TERMINATE"));
    }

    private void sendData(String msg){
        try {
            outputStream.writeObject(serverMsgPrefix + msg);
            outputStream.flush();
            displayMsg(serverMsgPrefix + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try{
            displayMsg(serverMsgPrefix + "Closing IO Streams and client socket");
            setTextFieldEditable(false);
            outputStream.close();
            inputStream.close();
            socket.close();
            displayMsg(serverMsgPrefix + "IO Streams & client socket closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void displayMsg(final String msgToDisplay) {
        SwingUtilities.invokeLater(() -> chatView.append("\n"+ msgToDisplay));
    }

    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(() -> msgView.setEditable(editable));
    }
}
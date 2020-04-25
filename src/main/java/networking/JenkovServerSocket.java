package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JenkovServerSocket {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;

        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            boolean isStopped = false;
            while (!isStopped) {
                clientSocket = serverSocket.accept();
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                System.out.println(dis.readUTF());
                isStopped = true;
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }

//        Only one incoming connection is opened for each call to the accept() method.
//        Additionally, incoming connections can only be accepted while the thread running the server has
//        called accept ().All the time the thread is executing outside of this method no clients can
//        connect.Therefore the "accepting" thread normally passes incoming connections(Socket
//        's) on to a pool of worker threads, who then communicate with the client.
//        Closing Client Sockets
//        Once a client request is finished, and no further requests will be received from that client, you must close
//        that Socket, just like you would close a normal client Socket.This is done by calling:
    }
}
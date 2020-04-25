package networking;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
//        Socket socket = new Socket("127.0.0.1" , 9000);
        OutputStreamWriter toServer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        String msg = "Hello World, Server";
        toServer.write(msg, 0, msg.length());


        toServer.close();           // OutputStreamWriter.close()
        socket.close();             // Socket.close()
    }
}

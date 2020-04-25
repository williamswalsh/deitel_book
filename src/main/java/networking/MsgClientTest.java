package networking;

import javax.swing.*;

public class MsgClientTest {

//        notes directory
//        cp /Users/will/repo/Java_Deitel_Book/Chpt_3/src/main/java/networking/MsgClient.java networking/MsgClient.java
//        javac networking/*.java && java networking/MsgClientTest

    public static void main(String[] args) {
        MsgClient client;
        if(args.length == 0){
            client = new MsgClient("127.0.0.1");
        }else{
            client = new MsgClient(args[0]);
        }
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.runClient();
    }
}

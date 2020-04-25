package networking;

import javax.swing.*;

public class MsgServerTest {
    public static void main(String[] args) {
        MsgServer app = new MsgServer();
        app.runServer();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

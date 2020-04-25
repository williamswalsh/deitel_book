package ui;

import javax.swing.*;

public class EventListenerFrameTest {
    public static void main(String[] args) {
        JFrame jframe = new EventListenerFrame();
        jframe.setSize(400,400);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

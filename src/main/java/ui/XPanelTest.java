package ui;

import javax.swing.JFrame;

public class XPanelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        XPanel panel = new XPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 250, 250 );
        frame.setVisible( true );
    }
}

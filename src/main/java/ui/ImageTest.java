package ui;

import javax.swing.*;
import java.awt.*;

public class ImageTest extends JFrame {
    public JLabel myLabel;
    ImageTest(){
        super("Testing JLabel");
        setLayout(new FlowLayout());
        Icon myIcon = new ImageIcon(getClass().getResource("bug.png"));
        myLabel = new JLabel("Label with text and icon", myIcon, SwingConstants.BOTTOM);
        add(myLabel);
    }

    public static void main(String[] args) {
        ImageTest it = new ImageTest();
        it.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        it.setSize(400,260);
        it.setVisible(true);
    }
}

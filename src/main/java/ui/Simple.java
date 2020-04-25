package ui;

import javax.swing.*;
import java.awt.*;

public class Simple extends JFrame{
    public static void main(String[] args) {

        // Modal dialog -> User can only interact with the dialog in focus

        // Retrieve data
        String input = JOptionPane.showInputDialog("Please enter data: ");
        // Hitting cancel returns null

        // Output data
        // 1) Where to position the dialog on the screen
        //    You could position it with reference to another dialog -> Parent Window
        //    If null -> appears in screen centre
        JOptionPane.showMessageDialog(null, "Data: " + input, "Title of Dialog", JOptionPane.PLAIN_MESSAGE);


        // Convert String to integer
        Integer.parseInt("1234");

//        // Icon myIcon = new ImageIcon( getClass().getResource("bug.png"));
//        JLabel myLabel = new JLabel("Label with text and icon", myIcon, SwingConstants.BOTTOM);
    }
}

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListenerFrame extends JFrame {
    private JTextField textField1;
    private JTextField textField2;

    public EventListenerFrame(){
        setLayout(new FlowLayout());
        textField1 = new JTextField();
        textField2 = new JTextField();

        textField1.setColumns(30);
        textField2.setColumns(30);

        textField1.setEditable(false);

        add(textField1);
        add(textField2);

        TextFieldHandler handler = new TextFieldHandler();

        textField1.addActionListener(handler);
//        textField2.addActionListener(handler);
    }
    private class TextFieldHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String string = "";

            if(event.getSource() == textField1){
                string = "Text Field 1" + event.getActionCommand();
            }
            else if(event.getSource() == textField2){
                string = "Text Field 2" + event.getActionCommand();
            }
            JOptionPane.showMessageDialog(null, string);
        }
    }
}

package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListFrame extends JFrame {
    private JList colorList;
    private static final Color[] colors={ Color.black, Color.yellow };
    private static final String[] colorStrings={ "black", "yellow" };

    public ListFrame(){
        super("List test");
        setLayout(new FlowLayout());
        colorList = new JList(colorStrings);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorList.setVisibleRowCount(2);
        add(new JScrollPane(colorList));

        colorList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(colors[colorList.getSelectedIndex()]);
            }
        });

    }
}

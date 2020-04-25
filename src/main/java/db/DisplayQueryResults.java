package db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class DisplayQueryResults extends JFrame {

    // host
    // port
    // user
    // pwd

    private final String DATABASE_URL = "";
    private final String username = "";
    private final String password = "";
    private final String DEFAULT_QUERY = "SELECT * FROM organisation";

    private ResultSetTableModel tableModel;
    private JTextArea queryArea;

    public DisplayQueryResults() {
        super("Displaying Query Results");

        try {
            tableModel = new ResultSetTableModel(DATABASE_URL, username, password, DEFAULT_QUERY);

            queryArea = new JTextArea(DEFAULT_QUERY, 5, 10);
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);


            JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            JButton submitBtn = new JButton("Submit Query");

            Box northBox = Box.createHorizontalBox();
            northBox.add(scrollPane);
            northBox.add(submitBtn);
            add(northBox, BorderLayout.NORTH);


            JTable jTable = new JTable(tableModel);
//            Testing why table text isn't appearing
//            jTable.setBackground(Color.decode("#058dc7"));
//            jTable.setForeground(Color.BLACK);
            Box southBox = Box.createHorizontalBox();
//            southBox.add(jTable);


            add(new JScrollPane(jTable), BorderLayout.CENTER);
            add(southBox, BorderLayout.SOUTH);


            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        tableModel.setQuery(queryArea.getText());
                    } catch (SQLException ex1) {
                        JOptionPane.showMessageDialog(null, ex1.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

                        try {
                            tableModel.setQuery(DEFAULT_QUERY);
                            queryArea.setText(DEFAULT_QUERY);

                        } catch (SQLException ex2) {
                            JOptionPane.showMessageDialog(null, ex2.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                            tableModel.disconnectFromDB();
                            System.exit(1);
                        }
                    }
                }
            });
            setSize(1000, 500);
            setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE );
            tableModel.disconnectFromDB();
            System.exit(1);
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                tableModel.disconnectFromDB();
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new DisplayQueryResults();
    }
}

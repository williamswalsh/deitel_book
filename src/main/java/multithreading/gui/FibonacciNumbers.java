package multithreading.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciNumbers extends JFrame {

    private final JPanel workerJPanel = new JPanel(new GridLayout(2,2,5,5));
    private final JTextField numberJTextField = new JTextField();
    private final JButton goJButton = new JButton("Go");
    private final JLabel fibonnaciJLabel = new JLabel();


    private final JPanel eventDispatcherJPanel = new JPanel(new GridLayout(2,2,5,5));
    private long n1 = 0;
    private long n2 = 1;
    private int count = 1;
    private final JLabel nJLabel = new JLabel("Fibonacci of 1:");
    private final JLabel nFibJLabel = new JLabel(String.valueOf(n2));
    private final JButton nextJButton = new JButton("Next Number");

    public FibonacciNumbers() {
        super("Fibonacci Numbers");
//        Set layout at start
        setLayout(new GridLayout(2,1, 10, 10));

        goJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n;
                try {
                    n = Integer.parseInt(numberJTextField.getText());
                } catch (NumberFormatException ex) {
                    fibonnaciJLabel.setText("Enter an integer");
                    return;
                }
                fibonnaciJLabel.setText("Calculating...");

                BackgroundCalc task = new BackgroundCalc(n, fibonnaciJLabel);
                task.execute();
            }
        });
        workerJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "With SwingWorker"));

//        Add components to Panel
        workerJPanel.add(numberJTextField);
        workerJPanel.add(goJButton);
        workerJPanel.add(fibonnaciJLabel);


        nextJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long tmp = n1 + n2;
                n1 = n2;
                n2 = tmp;
                ++count;

                nJLabel.setText("Fibonacci of " + count + ": ");
                nFibJLabel.setText(String.valueOf(n2));
            }
        });

        eventDispatcherJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Without SwingWorker"));

        //        Add components to Panel
        eventDispatcherJPanel.add(nJLabel);
        eventDispatcherJPanel.add(nFibJLabel);
        eventDispatcherJPanel.add(nextJButton);

//        Add Panels to Frame
        add(workerJPanel);
        add(eventDispatcherJPanel);

//        Config Frame
        setSize(275, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

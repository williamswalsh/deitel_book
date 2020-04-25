package multithreading.gui;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class PrimeCalc extends SwingWorker<Integer, Integer> {

    private final Random generator = new Random();
    private final JTextArea intermediateJTextArea;
    private final JButton getPrimesJButton;
    private final JButton cancelJButton;
    private final JLabel statusJlabel;
    private final boolean[] primes;

    public PrimeCalc(int max, JTextArea intermediateJTextArea, JButton getPrimesJButton, JButton cancelJButton, JLabel statusJlabel) {
        this.intermediateJTextArea = intermediateJTextArea;
        this.getPrimesJButton = getPrimesJButton;
        this.cancelJButton = cancelJButton;
        this.statusJlabel = statusJlabel;
        this.primes = new boolean[max];
        Arrays.fill(primes, true);
    }


    @Override
    protected Integer doInBackground() throws Exception {
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (isCancelled()) {
                return count;
            } else {
                setProgress((100 * (i + 1)) / primes.length);
                try {
                    Thread.sleep(generator.nextInt(5));
                } catch (InterruptedException e) {
                    statusJlabel.setText("Worker thread interrupted");
                    return count;
                }
                if (primes[i]) {
                    publish(i);
                    ++count;
                    for (int j = i + i; j < primes.length; j++) {
                        primes[j] = false;
                    }
                }
            }
        }
        return count;
    }

    @Override
    protected void process(List<Integer> publishValues) {
        for (int i = 0; i < publishValues.size(); i++) {
            intermediateJTextArea.append(publishValues.get(i) + "\n");
        }
    }

    @Override
    protected void done() {
        getPrimesJButton.setEnabled(true);
        cancelJButton.setEnabled(false);

        int numPrimes;

        try {
            numPrimes = get();
        } catch (InterruptedException e) {
            statusJlabel.setText("Interrupted while waiting for results.");
            return;
        } catch (ExecutionException e) {
            statusJlabel.setText("Cancelled.");
            return;
        }
        statusJlabel.setText("Found " + numPrimes + " primes.");
    }

}

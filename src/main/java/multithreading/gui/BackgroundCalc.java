package multithreading.gui;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class BackgroundCalc extends SwingWorker<Long, Object> {

    private final int n;
    private final JLabel resultJLabel;

    public BackgroundCalc(int n, JLabel resultJLabel) {
        this.n = n;
        this.resultJLabel = resultJLabel;
    }

    @Override
    protected Long doInBackground() throws Exception {
        return fibonacci(n);
    }

    @Override
    protected void done() {
        try{
            resultJLabel.setText(get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private long fibonacci(long number){
        if (number == 0 || number == 1){
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

}

package multithreading;

import java.util.Random;

public class PrintTask implements Runnable {
    private static Random generator = new Random();
    private String taskName;
    private int sleepTime;

    public PrintTask(String taskName) {
        this.taskName = taskName;
        sleepTime = generator.nextInt(5000);
    }

    @Override
    public void run() {
        System.out.println("Starting task: " + taskName);
        try{
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completing task: " + taskName);
    }
}

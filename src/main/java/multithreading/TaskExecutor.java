package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args) {
        PrintTask task1 = new PrintTask("Task 1 - Print word doc");
        PrintTask task2 = new PrintTask("Task 2 - Print excel sheet");
        PrintTask task3 = new PrintTask("Task 3 - Output image to screen");
        PrintTask task4 = new PrintTask("Task 4 - Backup word doc");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);

        executorService.shutdown();                 // Stops executor service from accepting new tasks, continues executing curr tasks
        // executorService.shutdownNow();           // Stops executor service from accepting new tasks, stops executing curr tasks InterruptedException
        System.out.println("Tasks started - main ending");
    }
}

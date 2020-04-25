package multithreading;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        RunnableTest test = new RunnableTest();


//        Executed in the main thread
        test.run();


        Thread t = new Thread(new Runnable(){

            @Override
            public void run() {

            }
        });

        ExecutorService executorService = Executors.newCachedThreadPool();

//        Executed in another thread
        executorService.execute(test);
        executorService.shutdown();
    }
}

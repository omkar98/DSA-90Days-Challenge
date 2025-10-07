package DSA.Rapid7DSAPractice.Practice6.CallableAndFuture;

import java.util.concurrent.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // ExecutorService manages a pool of threads
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit a Callable task
        Callable<String> task = () -> {
            Thread.sleep(1000); // simulate work
            return "Hello from Callable!";
        };

        Future<String> future = executor.submit(task);

        System.out.println("Task submitted... doing other work");

        // future.get() blocks until result is ready
        String result = future.get();
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}



package kapyrin.test.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static kapyrin.test.executor.IncrementClass.incrementTask;

public class ExecutorWithOutCompletableFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> firstFuture = executor.submit(() -> incrementTask());
        Future<Integer> secondFuture = executor.submit(() -> incrementTask());
        Future<Integer> thirdFuture = executor.submit(() -> incrementTask());

        try {
            int result = firstFuture.get() + secondFuture.get() + thirdFuture.get();
            System.out.println("The result is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

   }


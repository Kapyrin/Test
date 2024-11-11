package kapyrin.test.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static kapyrin.test.executor.IncrementClass.incrementTask;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        Future<Integer> firstFuture = singleExecutor.submit(() -> incrementTask());
        Future<Integer> secondFuture = singleExecutor.submit(() -> incrementTask());
        Future<Integer> thirdFuture = singleExecutor.submit(() -> incrementTask());

        try {
            int result = firstFuture.get() + secondFuture.get() + thirdFuture.get();
            System.out.println("The result is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            singleExecutor.shutdown();
        }
    }
}

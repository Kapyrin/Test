package kapyrin.test.anothertest.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static kapyrin.test.anothertest.executor.IncrementClass.incrementTask;

public class CashedThreadPool
{
    public static void main(String[] args) {
        ExecutorService cashedExecutor = Executors.newCachedThreadPool();
        Future<Integer> firstFuture = cashedExecutor.submit(() -> incrementTask());
        Future<Integer> secondFuture =cashedExecutor.submit(() -> incrementTask());
        Future<Integer> thirdFuture = cashedExecutor.submit(() -> incrementTask());

        try {
            int result = firstFuture.get() + secondFuture.get() + thirdFuture.get();
            System.out.println("The result is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            cashedExecutor.shutdown();
        }
    }
}

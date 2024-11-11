package kapyrin.test.anothertest.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static kapyrin.test.anothertest.executor.IncrementClass.incrementTask;

public class WorkStealingPool {
    public static void main(String[] args) {
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(() -> incrementTask(), workStealingPool);
        CompletableFuture<Integer> secondTask = CompletableFuture.supplyAsync(() -> incrementTask(), workStealingPool);
        CompletableFuture<Integer> thirdTask = CompletableFuture.supplyAsync(() -> incrementTask(), workStealingPool);

        CompletableFuture<Integer> result = firstTask.thenCombine(secondTask, (a, b) -> a + b).thenCombine(thirdTask, (a, b) -> a + b);
        result.thenAccept((totalResult) -> System.out.println(totalResult));
        workStealingPool.shutdown();
    }
}


package kapyrin.test.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static kapyrin.test.executor.IncrementClass.incrementTask;

public class ExecutorWithCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(() -> incrementTask(), executorService);
        CompletableFuture<Integer> secondTask = CompletableFuture.supplyAsync(() -> incrementTask(), executorService);
        CompletableFuture<Integer> thirdTask = CompletableFuture.supplyAsync(() -> incrementTask(), executorService);

//        int result = firstTask.get() + secondTask.get() + thirdTask.get();
//        System.out.println(result);

        CompletableFuture<Integer> result = firstTask.thenCombine(secondTask, (a, b) -> a + b).thenCombine(thirdTask, (a, b) -> a + b);
        result.thenAccept((totalResult) ->System.out.println(totalResult));

        CompletableFuture<Integer> sameResult = firstTask.thenCombine(secondTask,Integer::sum).thenCombine(thirdTask,Integer::sum);
        sameResult.thenAccept((totalResult) ->System.out.println(totalResult));
        executorService.shutdown();
    }


}

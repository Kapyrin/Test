package kapyrin.test.executor;

import java.util.concurrent.CompletableFuture;

import static kapyrin.test.executor.IncrementClass.incrementTask;

public class CompletableFutureWithOutExecutorService {
    public static void main(String[] args) {

        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(()->incrementTask());
        CompletableFuture<Integer> secondTask = CompletableFuture.supplyAsync(()->incrementTask());
        CompletableFuture<Integer> thirdTask = CompletableFuture.supplyAsync(()->incrementTask());

        CompletableFuture<Integer> result = firstTask.thenCombine(secondTask, Integer::sum).thenCombine(thirdTask, Integer::sum);

        result.thenAccept(total -> System.out.println(total));

    }
}

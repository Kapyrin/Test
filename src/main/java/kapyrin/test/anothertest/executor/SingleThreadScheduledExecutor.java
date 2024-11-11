package kapyrin.test.anothertest.executor;

import java.util.concurrent.*;

import static kapyrin.test.anothertest.executor.IncrementClass.incrementTask;

public class SingleThreadScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService singleScheduler = Executors.newSingleThreadScheduledExecutor();

        Future<Integer> firstTask = singleScheduler.schedule(() -> incrementTask(), 1, TimeUnit.SECONDS);
        Future<Integer> secondTask = singleScheduler.schedule(() -> incrementTask(), 5, TimeUnit.SECONDS);
        Future<Integer> thirdTask = singleScheduler.schedule(() -> incrementTask(), 10, TimeUnit.SECONDS);

        try {
            System.out.println("Performing first task");
            int firstResult = firstTask.get();
            System.out.println("First task result: " + firstResult);
            System.out.println("Performing second task");
            int secondResult = secondTask.get();
            System.out.println("Second task result: " + secondResult);
            System.out.println("Performing third task");
            int thirdResult = thirdTask.get();
            System.out.println("Third task result: " + thirdResult);

            int totalResult = firstResult + secondResult + thirdResult;
            System.out.println("Total result: " + totalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            singleScheduler.shutdown();
        }
    }
}


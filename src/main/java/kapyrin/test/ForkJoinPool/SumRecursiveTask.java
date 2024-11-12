package kapyrin.test.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumRecursiveTask extends RecursiveTask<Long> {
    private static final int TASK_SIZE = 1_000_000;
    private final int[] numbers;
    private final int start;
    private final int end;

    public SumRecursiveTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if (end - start <= TASK_SIZE) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumRecursiveTask left = new SumRecursiveTask(numbers, start, mid);
            SumRecursiveTask right = new SumRecursiveTask(numbers, mid, end);

            left.fork();

            long rightResult = right.compute();
            long leftResult = left.join();
            return leftResult + rightResult;
        }

    }

    public static void main(String[] args) {
        int[] numbers = new int[100_0000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        SumRecursiveTask task = new SumRecursiveTask(numbers, 0, numbers.length);
        long startTimeForkJoin = System.nanoTime();
        long sumWIthForkJoinPool = pool.invoke(task);
        long endTimeForkJoin = System.nanoTime();
        System.out.println("Working time with ForkJoinPool " + (endTimeForkJoin - startTimeForkJoin) + " nanoseconds " + "Sum is " + sumWIthForkJoinPool);

        long starTimeWithOutForkJoin = System.nanoTime();
        long sumWithOutForkJoin = arraySum(numbers);
        long endTimeWithOutForkJoin = System.nanoTime();
        System.out.println("Working time without ForkJoinPool " + (endTimeWithOutForkJoin - starTimeWithOutForkJoin) + " nanoseconds " + "Sum is " + sumWithOutForkJoin);
        System.out.println();

        System.out.println("UsingForkJoinPoll is faster at " + (double) (endTimeWithOutForkJoin - starTimeWithOutForkJoin) / (endTimeForkJoin - startTimeForkJoin) + " times");

    }

    public static long arraySum(int[] numbers) {
        long result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
}

package kapyrin.test.deadlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
//    Map<String, Double> map = new HashMap<>();
//
//    Executor executor = command -> new Thread(command).start();
//    ExecutorService executorService = Executors.newFixedThreadPool(2);
//    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//    Callable<Integer> task = () -> {
//        Thread.sleep(1000);
//        return 123;
//    };

    public void firstLock() {

        synchronized (lock1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            synchronized (lock2) {
                System.out.printf("First lock 1: %s\n", Thread.currentThread().getName());
            }
        }
    }

    public void secondLock() {
        synchronized (lock2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            synchronized (lock1) {
                System.out.printf("Second lock 1: %s\n", Thread.currentThread().getName());

            }
        }
    }

    public static void main(String[] args) {
        DeadLock lock = new DeadLock();
        Thread thread1 = new Thread(lock::firstLock);
        Thread thread2 = new Thread(lock::secondLock);
        thread1.start();
        thread2.start();
    }
}

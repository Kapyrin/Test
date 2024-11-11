package kapyrin.test.threadarray;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] myArray = new int[10];
        for (int i = 0; i < 10; i++) {
            myArray[i] = i + 1;
        }
        System.out.println("Array before changes:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + "  ");
        }
        Thread[] threads = new Thread[myArray.length];

        for (int i = 0; i < myArray.length; i++) {
            threads[i] = new Thread(new ArrayRunnable(myArray, i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println();
        System.out.println("Array after changes:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");

        }
    }
}

package kapyrin.test.threadarray;

public class ArrayRunnable implements Runnable {

    private int[] array;
    private int index;

    public ArrayRunnable(int[] array, int index) {
        this.array = array;
        this.index = index;
    }

    @Override
    public void run() {
        array[index] = array[index] * 5;
    }
}
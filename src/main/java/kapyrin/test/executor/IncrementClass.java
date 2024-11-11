package kapyrin.test.executor;


public class IncrementClass {

    static int incrementTask() {
        int counter = 0;
        for (int i = 0; i < 10_000; i++) {
            counter++;
        }
        return counter;
    }
}

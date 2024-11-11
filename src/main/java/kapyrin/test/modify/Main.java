package kapyrin.test.modify;

import org.checkerframework.checker.units.qual.K;

public class Main {


    public static void main(String[] args) throws Exception {
        int a;
//        Interf a = new Klass();
//        Klass b = new Klass();
//        b.method();
//        ((Klass) a).method();
        try {
            a = 5;
            throw new Exception("1");
        } catch (Exception e) {
            a = 10;
            throw new Exception("2");
        } finally {
            a = 15;
            System.out.println(a);
            throw new Exception("3");
        }

    }

}

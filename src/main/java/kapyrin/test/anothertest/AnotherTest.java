package kapyrin.test.anothertest;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class AnotherTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2));

        List<Integer> unmodifiable = Collections.unmodifiableList(list);

        list.add(3);

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(Arrays.toString(unmodifiable.toArray()));

    }

}



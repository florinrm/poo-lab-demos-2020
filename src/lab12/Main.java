package lab12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Animal.print();
        Animal human = new Human();
        human.makeSound();
        human.shakeTail();

        FInterface sumOp = Integer::sum;
        System.out.println(sumOp.sum(1, 2));

        Streams.testPredicate();

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Stream<Integer> stream = list.stream();

        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(arr);

        List<Integer> resultFilter = stream.filter(x -> x % 2 == 0).collect(Collectors.toList());

        // int[] arrResultFilter = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).toArray();

        int sum = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println(sum);

        Streams.testFlatMap();
    }
}

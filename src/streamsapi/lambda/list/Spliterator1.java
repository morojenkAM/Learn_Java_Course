package streamsapi.lambda.list;

import java.util.List;

public class Spliterator1 {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "D", "E", "F", "G", "H");

        java.util.Spliterator<String> spliterator = list.spliterator();
        ((java.util.Spliterator<?>) spliterator).forEachRemaining(System.out::println);


    }
}

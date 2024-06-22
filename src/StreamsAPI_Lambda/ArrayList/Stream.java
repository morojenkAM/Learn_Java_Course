package StreamsAPI_Lambda.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        //Stream FlatMap()
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        List<String> list1 = new ArrayList<>();
        list1.add("E");
        list1.add("F");
        list1.add("G");
        list1.add("H");

        List<String> finalJoin = java.util.stream.Stream.of(list,list1)
                .flatMap(x -> x.stream())//este deosebit de util atunci când fiecare element al fluxului original poate fi transformat în mai multe elemente ale fluxului rezultat
                .collect(Collectors.toList());//de a colecta si finaliza datele dintr-un flux intr-o colectie List standard
        System.out.println(finalJoin);

    }
}

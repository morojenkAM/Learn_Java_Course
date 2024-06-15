package StreamsAPI_Lambda.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class SecondMethod {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        List<String> list1 = new ArrayList<>();
        list1.add("F");
        list1.add("G");
        list1.add("H");
        list1.add("I");

        List<String> list2 = new ArrayList<>(list1);
        list2.removeAll(list);
        list.addAll(list2);
        System.out.println(list);
    }
}

package streamsapi.lambda.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
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


        List<String> joinendlist2 = new ArrayList<>(list);
       for (String item : list1) {
           joinendlist2.add(item);
           System.out.println("Using loop" + joinendlist2);
       }
    }
}

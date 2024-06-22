package StreamsAPI_Lambda.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class AddAll {
    //adAll
    public static void main(String[] args) {
       List<String> list1 = new ArrayList<>();
       list1.add("A");
       list1.add("B");
       list1.add("C");
       list1.add("D");
       List<String> list2 = new ArrayList<>();
       list2.add("G");
       list2.add("H");
       list2.add("I");
       list2.add("J");

       list1.addAll(list2);
       System.out.println(list1);
    }
}

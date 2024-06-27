package streamsapi.lambda.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Iterator {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("D");
        list2.add("E");
        list2.add("F");


        List<String> concatenatedList = new ArrayList<>(list1);
        java.util.Iterator<String> iterator = list2.iterator();
while (iterator.hasNext()) {
    concatenatedList.add(iterator.next());
}

        System.out.println("Concatenated List: " + concatenatedList);
    }
}

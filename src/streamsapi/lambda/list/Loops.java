package streamsapi.lambda.list;

import java.util.ArrayList;
import java.util.List;

public class Loops {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            
        }
    }
}

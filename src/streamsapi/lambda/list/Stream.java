package streamsapi.lambda.list;

import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

       list.stream().forEach(
               (listWithElements) -> System.out.println(listWithElements));
        }
    }


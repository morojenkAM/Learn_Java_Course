package StreamsAPI_Lambda.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class ForEach {
    public static void main(String[] args) {
        Map<Integer, String> customers = new HashMap<>();
        customers.put(1, "Ajay");
        customers.put(2, "Barkha");
        customers.put(3, "Cathy");

        System.out.println("Using foreach");
    customers.forEach((k, v) -> System.out.println(k + ": " + v));
    }

}

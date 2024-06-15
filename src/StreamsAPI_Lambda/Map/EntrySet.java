package StreamsAPI_Lambda.Map;

import java.util.HashMap;
import java.util.Map;

public class EntrySet {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Alice", 95);
        scores.put("Bob", 88);
        scores.put("Charlie", 78);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

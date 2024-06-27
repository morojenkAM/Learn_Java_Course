package streamsapi.lambda.map;

import java.util.HashMap;
import java.util.Map;

public class Streams {
    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Apple", 1.99);
        prices.put("Banana", 0.99);
        prices.put("Orange", 1.49);

        prices.forEach((key, value) -> System.out.println("Item: " + key + ", Price: " + value));
    }
}

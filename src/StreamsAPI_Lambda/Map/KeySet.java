package StreamsAPI_Lambda.Map;

import java.util.HashMap;
import java.util.Map;

public class KeySet {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put("USA", "Washington, D.C.");
        countries.put("France", "Paris");
        countries.put("Japan", "Tokyo");

        for (String country : countries.keySet()) {
            System.out.println("Country: " + country + ", Capital: " + countries.get(country));
        }
    }
}

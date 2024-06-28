package streamsapi.lambda;

import java.util.HashMap;
import java.util.Map;

public class Repetitive {
    public static void main(String[] args) {

        char[] charArray = "google".toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                int currentCounter = map.get(c);
                map.put(c, ++currentCounter);
            }
        }
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

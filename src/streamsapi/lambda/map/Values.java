package streamsapi.lambda.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class Values {
    public static void main(String[] args) {
        Map<Integer, String> months = new LinkedHashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");

        for (String month : months.values()) {
            System.out.println("Month: " + month);
        }
    }
}

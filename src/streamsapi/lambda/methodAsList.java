package streamsapi.lambda;
import java.util.Arrays;
import java.util.List;

public class methodAsList {
    public static void main(String[] args) {

        //array input
        String flowersArray [] = { "Rose" , "Daisy" , " Jasmine" , "Lily" , "Iris", "Orchid" };

        //printing input elements for comparison
        System.out.println("Array input; " + Arrays.asList(flowersArray));

        //converting array into Colection
        //with asList()
        List<String> flowers = Arrays.asList(flowersArray);

        System.out.println("Converted elements; " + flowers);

        }
    }


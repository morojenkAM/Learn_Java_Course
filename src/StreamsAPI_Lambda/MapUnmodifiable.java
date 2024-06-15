package StreamsAPI_Lambda;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class MapUnmodifiable {
    public static void main(String[] args) {
//List of Integer
        Map<Integer,String> fruits = new HashMap();

        fruits.put(1, "Banana");
        fruits.put(2, "Apple");
        fruits.put(3, "Orange");
        fruits.put(4, "Mango");
        fruits.put(5, "Pear");


        //transform in flux,after then prints them
        fruits.entrySet().stream().forEach(System.out::println);

        //add element
        fruits.put(5, "Cherry");
        fruits.put(6, "Tomato");

        fruits.remove(6);

        fruits.put(1, "Kiwi");
        System.out.println("\n After Performing Some Operations");

        fruits.entrySet().stream().forEach(System.out::println);

        System.out.println("\n Hence By default Collections object is Readable and Writable");

        // Making Read-Only List
        // Using unmodifiableList() method.

        try {
            fruits = Collections.unmodifiableMap(fruits);

            //This line will generate an Exception
            fruits.remove(2);
        }catch (UnsupportedOperationException e) {
            System.out.println("Exception is " + e);
        }
        finally {
            System.out.print(fruits + " elements in fruits ,map");
        }

    }}

package StreamsAPI_Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ListUnmodifiable {
    public static void main(String[] args) {
//List of Integer
        List<String> fruits = new ArrayList<>();

        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Pear");


        //transform in flux,after then prints them
        fruits.stream().forEach(System.out::println);

        //add element
        fruits.add("Cherry");
        fruits.add("Tomato");

        fruits.remove("Tomato");

        fruits.set(1, "Kiwi");
        System.out.println("\n After Performing Some Operations");

        fruits.stream().forEach(System.out::println);

        System.out.println("\n Hence By default Collections object is Readable and Writable");

        // Making Read-Only List
        // Using unmodifiableList() method.

        try {
            fruits = Collections.unmodifiableList(fruits);

            //This line will generate an Exception
            fruits.remove("Apple");
        }catch (UnsupportedOperationException e) {
            System.out.println("Exception is " + e.getMessage());
        }
        finally {
            System.out.print(fruits.size() + " elements in fruits list");
            System.out.println("\n Now list is only Read-Only");
        }

}}

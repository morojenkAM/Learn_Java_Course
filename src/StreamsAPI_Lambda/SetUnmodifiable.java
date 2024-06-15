package StreamsAPI_Lambda;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class SetUnmodifiable {
    public static void main(String[] args) {

        Set<String> fruits = new HashSet<>();

        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Pear");


        //transform in flux,after then prints them
        fruits.stream().forEach(System.out::println);

        //add element
        fruits.add("Banana1");
        fruits.add("Tomato");

        fruits.remove("Tomato");

        System.out.println("\n After Performing Some Operations");

        fruits.stream().forEach(System.out::println);

        System.out.println("\n Hence By default Collections object is Readable and Writable");

        // Making Read-Only List
        // Using unmodifiableList() method.

        try {
            fruits = Collections.unmodifiableSet(fruits);

            //This line will generate an Exception
            fruits.remove("Banana");
        }catch (UnsupportedOperationException e) {
            System.out.println("Exception is " + e.getMessage());
        }
        finally {
            System.out.print(fruits );

        }

    }}

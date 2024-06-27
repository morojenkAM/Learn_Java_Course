package streamsapi.lambda.list;

import java.util.*;
public class Iterator2 {

    public static void main(String args[]) {

        List<String> myList = new ArrayList<String>();


        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");

        // Iterator
        Iterator<String> it = myList.iterator();

        // Condition check for elements in List
        // using hasNext() method returning true till
        // there is single element in a List
        while (it.hasNext()) {

            // Print all elements of List
            System.out.println(it.next());
        }
    }}


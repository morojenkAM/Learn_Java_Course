package VariablesAndDataTypes;

import java.awt.*;
import java.util.Date;

public class Working_with_Data_Types {
    public static void main(String[] args) {

        //Primitive Data Types
        byte age = 23;
        long viewCount = 1_113_345_678;
        float price = 234.5F;
        char gender = 'M';
        boolean isValid = false;
        System.out.println("Age: " + age);
        System.out.println("ViewCount: " + viewCount);
        System.out.println("Price: " + price);
        System.out.println("Gender: " + gender);
        System.out.println("isValid: " + isValid);

        System.out.println('\n');
        //Non primitive data types
        String name = "King Kochhar";
        System.out.println(name);
        Date now = new Date();
        System.out.println(now);

        Point point1 = new Point(10, 20);
        Point point2 = point1;
        System.out.println(point1.x + " " + point1.y);
        System.out.println(point2.x + " " + point2.y);
        point1.y = 25;
        System.out.println(point1.x + " " + point1.y);
        System.out.println(point2.x + " " + point2.y);
    }
}

package StreamsAPI_Lambda;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Repetitive {


    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        list.add("1. Add Elements");
        list.add("2. Display Elements");
        list.add("3. Choose the word to decrypt by entering its key");

        boolean running = true;

        while (running) {
            list.stream().forEach(System.out::println);

            switch (sc.nextLine()) {
                case "1":
                    System.out.println("You have chosen to add elements to the map");
                    boolean addMore = true;

                    while (addMore) {
                        try {
                            System.out.print("Enter the key (integer): ");
                            int key = Integer.parseInt(sc.nextLine());

                            System.out.print("Enter the value: ");
                            String value = sc.nextLine();

                            map.put(key, value);

                            System.out.println("Element added:");
                            map.entrySet().forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));


                            System.out.println("Do you want to add more elements?");
                            System.out.println("1. Yes");
                            System.out.println("2. No (Back to Menu)");

                            String option = sc.nextLine();
                            if (!option.equals("2")) {
                                addMore = true;
                            } else {
                                list.stream().forEach(System.out::println);
                                break;

                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input,please try again");
                        }
                    }
                case "2":
                    if (map.isEmpty()) {
                        System.out.println("Dont have element");
                    } else {
                        map.entrySet().forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
                    }
                    break;

                case "3":
                    System.out.println("Introducing key") ;
                    int key = Integer.parseInt(sc.nextLine());

                    if (map.containsKey(key)) {
                        String value = map.get(key);
                        Map<Character, Integer> charCount = new HashMap<>();

                        value.chars()
                                .mapToObj(ch -> (char) ch)
                                .filter(Character::isLetter).forEach(ch -> {
                                    charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
                                });

                        System.out.println("Character occurrences:");
                        charCount.forEach((ch, count) -> {
                            System.out.println("'" + ch + "' occurs " + count + " times.");
                        });
                    }else {
                        System.out.println("Key not found");
                    }
                    break;
                default:
                    running = false;
                    break;

            }
        }


    }


}




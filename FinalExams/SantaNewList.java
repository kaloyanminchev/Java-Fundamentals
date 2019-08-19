package FinalExams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SantaNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> children = new TreeMap<>();
        LinkedHashMap<String, Integer> presents = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            if (input.contains("Remove")) {
                String childName = tokens[1];
                children.remove(childName);
            } else {
                String childName = tokens[0];
                String typeOfToy = tokens[1];
                int amount = Integer.parseInt(tokens[2]);
                if (!children.containsKey(childName)) {
                    children.put(childName, amount);
                    if (!presents.containsKey(typeOfToy)) {
                        presents.put(typeOfToy, amount);
                    } else {
                        presents.put(typeOfToy, presents.get(typeOfToy) + amount);
                    }
                } else {
                    children.put(childName, children.get(childName) + amount);
                    if (!presents.containsKey(typeOfToy)) {
                        presents.put(typeOfToy, amount);
                    } else {
                        presents.put(typeOfToy, presents.get(typeOfToy) + amount);
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Children:");
        children.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));

        System.out.println("Presents:");
        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            System.out.println(String.format("%s -> %d", entry.getKey(), entry.getValue()));
        }
    }
}


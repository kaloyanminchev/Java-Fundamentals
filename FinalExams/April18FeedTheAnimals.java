package FinalExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class April18FeedTheAnimals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> animals = new TreeMap<>();
        LinkedHashMap<String, Integer> areas = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"Last Info".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String animalName = tokens[1];
            String area = tokens[3];

            if (command.equals("Add")) {
                int dailyFoodLimit = Integer.parseInt(tokens[2]);
                if (!animals.containsKey(animalName)) {
                    animals.put(animalName, dailyFoodLimit);
                    if (!areas.containsKey(area)) {
                        areas.put(area, 1);
                    } else {
                        areas.put(area, areas.get(area) + 1);
                    }
                } else {
                    animals.put(animalName, animals.get(animalName) + dailyFoodLimit);
                }
            } else if (command.equals("Feed")) {
                int food = Integer.parseInt(tokens[2]);
                if (animals.containsKey(animalName)) {
                    animals.put(animalName, animals.get(animalName) - food);
                    if (animals.get(animalName) <= 0) {
                        animals.remove(animalName);
                        System.out.println(animalName + " was successfully fed");
                        areas.put(area, areas.get(area) - 1);
                    }
                }
            }

            input = reader.readLine();
        }

        System.out.println("Animals:");
        animals.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s -> %dg%n", entry.getKey(), entry.getValue()));

        System.out.println("Areas with hungry animals:");
        areas.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s : %d%n", entry.getKey(), entry.getValue()));
    }
}

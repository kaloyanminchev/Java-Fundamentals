package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class April14PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<String>> finalRoads = new TreeMap<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String road = tokens[1];
            switch (command) {
                case "Add":
                    String racer = tokens[2];
                    if (!finalRoads.containsKey(road)) {
                        finalRoads.put(road, new ArrayList<>());
                        finalRoads.get(road).add(racer);
                    } else {
                        finalRoads.get(road).add(racer);
                    }
                    break;
                case "Move":
                    String nameRacer = tokens[2];
                    String nextRoad = tokens[3];
                    if (finalRoads.get(road).contains(nameRacer)) {
                        finalRoads.get(road).remove(nameRacer);
                        finalRoads.get(nextRoad).add(nameRacer);
                    }
                    break;
                case "Close":
                    finalRoads.remove(road);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("April18FeedTheAnimals sessions:");
        finalRoads.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(e -> System.out.println("++" + e));
                });
    }
}

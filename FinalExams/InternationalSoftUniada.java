package FinalExams;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class InternationalSoftUniada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> collection = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(" -> ");
            String country = tokens[0];
            String contestant = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            if (!collection.containsKey(country)) {
                collection.put(country, new LinkedHashMap<>());
                collection.get(country).put(contestant, points);
            } else {
                if (!collection.get(country).containsKey(contestant)) {
                    collection.get(country).put(contestant, points);
                } else {
                    collection.get(country).put(contestant, collection.get(country).get(contestant) + points);
                }
            }
            input = scanner.nextLine();
        }

        collection.entrySet().stream()
                .sorted((e1, e2) ->
                        e2.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum() -
                                e1.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum())
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d",
                            entry.getKey(),
                            entry.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum()));
                    entry.getValue().entrySet()
                            .forEach(n -> System.out.printf(" -- %s -> %d%n", n.getKey(), n.getValue()));
                });
    }
}

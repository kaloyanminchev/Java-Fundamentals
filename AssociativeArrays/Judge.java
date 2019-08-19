package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, Integer>> statistics = new LinkedHashMap<>();
        TreeMap<String, Integer> individualStats = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"no more time".equals(input)) {
            String[] tokens = input.split("\\s+->\\s+");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            if (!statistics.containsKey(contest)) {
                statistics.put(contest, new TreeMap<>());
                statistics.get(contest).put(username, points);
            } else {
                if (statistics.get(contest).containsKey(username)) {
                    if (statistics.get(contest).get(username) < points) {
                        statistics.get(contest).put(username, points);
                    }
                } else {
                    statistics.get(contest).put(username, points);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : statistics.entrySet()) {
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                if (individualStats.containsKey(innerEntry.getKey())) {
                    individualStats.put(innerEntry.getKey(), individualStats.get(innerEntry.getKey()) + innerEntry.getValue());
                } else {
                    individualStats.put(innerEntry.getKey(), innerEntry.getValue());
                }
            }
        }


        AtomicInteger count = new AtomicInteger(1);
        statistics.entrySet()
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d participants", entry.getKey(), entry.getValue().size()));
                    entry.getValue().entrySet()
                            .stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(e -> {
                                System.out.printf(count + ". %s <::> %d\n", e.getKey(), e.getValue());
                                count.incrementAndGet();
                            });
                    count.set(1);
                });

        AtomicInteger standingCount = new AtomicInteger(1);
        System.out.println("Individual standings:");
        individualStats.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    System.out.printf(standingCount + ". %s -> %d\n", entry.getKey(), entry.getValue());
                    standingCount.incrementAndGet();
                });
    }
}

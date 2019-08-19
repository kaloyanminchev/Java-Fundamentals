package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> contests = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"end of contests".equals(input)) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String passwordForContest = tokens[1];
            contests.put(contest, passwordForContest);

            input = scanner.nextLine();
        }

        TreeMap<String, Map<String, Integer>> submissions = new TreeMap<>();

        String secondInput = scanner.nextLine();
        while (!"end of submissions".equals(secondInput)) {
            String[] array = secondInput.split("=>");
            String contest = array[0];
            String password = array[1];
            String username = array[2];
            int points = Integer.parseInt(array[3]);

            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                if (!submissions.containsKey(username)) {
                    submissions.put(username, new TreeMap<>());
                    submissions.get(username).put(contest, points);
                } else {
                    if (submissions.get(username).containsKey(contest)) {
                        if (points > submissions.get(username).get(contest)) {
                            submissions.get(username).put(contest, points);
                        }
                    } else {
                        submissions.get(username).put(contest, points);
                    }
                }
            }

            secondInput = scanner.nextLine();
        }

        int bestTotalPoints = 0;
        String name = "";

        for (Map.Entry<String, Map<String, Integer>> entry : submissions.entrySet()) {
            int totalPoints = entry.getValue().entrySet().stream().mapToInt(e -> e.getValue()).sum();
            if (totalPoints > bestTotalPoints) {
                bestTotalPoints = totalPoints;
                name = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", name, bestTotalPoints);
        System.out.println("Ranking: ");
        submissions.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
                });
    }
}

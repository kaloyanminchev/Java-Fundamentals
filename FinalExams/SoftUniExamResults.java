package FinalExams;

import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> participants = new TreeMap<>();
        TreeMap<String, Integer> submissions = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];

            if (input.contains("banned")) {
                participants.remove(username);
            } else {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                if (!participants.containsKey(username)) {
                    participants.put(username, points);
                } else {
                    if (points > participants.get(username)) {
                        participants.put(username, points);
                    }
                }
                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language) + 1);
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        participants.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(entry -> System.out.printf("%s | %d%n", entry.getKey(), entry.getValue()));

        System.out.println("Submissions:");
        submissions.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
    }
}

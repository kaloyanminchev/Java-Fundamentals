package AssociativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SoftUniExamResults10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> participants = new HashMap<>();
        HashMap<String, Integer> submissions = new HashMap<>();

        String input = reader.readLine();
        while (!"exam finished".equals(input)) {
            String[] tokens = input.split("-");
            String username = tokens[0];
            if (!tokens[1].equals("banned")) {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                if (!participants.containsKey(username)) {
                    participants.put(username, points);
                } else {
                    if (participants.get(username) < points) {
                        participants.put(username, points);
                    }
                }
                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language) + 1);
                }
            } else {
                participants.remove(username);
            }

            input = reader.readLine();
        }

        System.out.println("Results:");
        participants
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = e2.getValue().compareTo(e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(entry -> System.out.println(String.format("%s | %d", entry.getKey(), entry.getValue())));

        System.out.println("Submissions:");
        submissions
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(entry -> System.out.println(String.format("%s - %d", entry.getKey(), entry.getValue())));
    }
}

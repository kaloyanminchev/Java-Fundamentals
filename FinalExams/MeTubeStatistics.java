package FinalExams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class MeTubeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> collectionForViews = new LinkedHashMap<>();
        HashMap<String, Integer> collectionForLikes = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stats time")) {
            if (input.contains("-")) {
                String[] tokens = input.split("-");
                String videoName = tokens[0];
                int views = Integer.parseInt(tokens[1]);
                if (!collectionForViews.containsKey(videoName)) {
                    collectionForViews.put(videoName, views);
                    collectionForLikes.put(videoName, 0);
                } else {
                    collectionForViews.put(videoName, collectionForViews.get(videoName) + views);
                }
            } else {
                String[] tokens = input.split(":");
                String command = tokens[0];
                String video = tokens[1];
                switch (command) {
                    case "like":
                        if (collectionForLikes.containsKey(video)) {
                            collectionForLikes.put(video, collectionForLikes.get(video) + 1);
                        }
                        break;
                    case "dislike":
                        if (collectionForLikes.containsKey(video)) {
                            collectionForLikes.put(video, collectionForLikes.get(video) - 1);
                        }
                        break;
                }
            }
            input = scanner.nextLine();
        }

        String lastInput = scanner.nextLine();
        if (lastInput.contains("views")) {
            collectionForViews.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> System.out.printf("%s - %d views - %d likes%n", entry.getKey(), entry.getValue(), collectionForLikes.get(entry.getKey())));
        } else if (lastInput.contains("likes")) {
            collectionForLikes.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> System.out.printf("%s - %d views - %d likes%n", entry.getKey(), collectionForViews.get(entry.getKey()), entry.getValue()));
        }
    }
}

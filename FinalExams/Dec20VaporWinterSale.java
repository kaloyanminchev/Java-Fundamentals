package FinalExams;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Dec20VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        LinkedHashMap<String, Double> gameWithPrice = new LinkedHashMap<>();
        LinkedHashMap<String, String> gameWithDLC = new LinkedHashMap<>();

        for (String currentInput : input) {
            String[] tokens = currentInput.split("-|:");
            String game = tokens[0];
            if (currentInput.contains("-")) {
                double price = Double.parseDouble(tokens[1]);
                if (!gameWithPrice.containsKey(game)) {
                    gameWithPrice.put(game, price);
                }
            } else if (currentInput.contains(":")) {
                String DLC = tokens[1];
                if (gameWithPrice.containsKey(game)) {
                    if (!gameWithDLC.containsKey(game)) {
                        gameWithDLC.put(game, DLC);
                        gameWithPrice.put(game, gameWithPrice.get(game) * 1.20);
                    }
                }
            }
        }

        for (Map.Entry<String, Double> entry : gameWithPrice.entrySet()) {
            String currentGame = entry.getKey();
            if (!gameWithDLC.containsKey(currentGame)) {
                gameWithPrice.put(currentGame, gameWithPrice.get(currentGame) * 0.80);
            } else {
                gameWithPrice.put(currentGame, gameWithPrice.get(currentGame) * 0.50);
            }
        }

        gameWithPrice
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> {
                    if (gameWithDLC.containsKey(entry.getKey())) {
                        System.out.printf("%s - %s - %.2f%n", entry.getKey(),
                                gameWithDLC.get(entry.getKey()),
                                entry.getValue());
                    }
                });

        gameWithPrice
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    if (!gameWithDLC.containsKey(entry.getKey())) {
                        System.out.printf("%s - %.2f%n", entry.getKey(),
                                entry.getValue());
                    }
                });
    }
}

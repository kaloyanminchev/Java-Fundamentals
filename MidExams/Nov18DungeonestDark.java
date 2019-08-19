package MidExams;

import java.util.*;
import java.util.stream.Collectors;

public class Nov18DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|+")).collect(Collectors.toList());
        int health = 100;
        int coins = 0;
        int counter = 0;

        for (int i = 0; i < rooms.size(); i++) {
            String[] tokens = rooms.get(i).split("\\s+");
            String type = tokens[0];
            int number = Integer.parseInt(tokens[1]);
            counter++;
            switch (type) {
                case "potion":
                    if (health + number > 100) {
                        number = 100 - health;
                        health = 100;
                    } else {
                        health += number;
                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    System.out.printf("You found %d coins.%n", number);
                    coins += number;
                    break;
                default:
                    health -= number;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", type);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", type);
                        System.out.printf("Best room: %d", counter);
                        return;
                    }
                    break;
            }
        }

        System.out.println("You've made it!");
        System.out.printf("Coins: %d", coins).println();
        System.out.printf("Health: %d", health);
    }
}


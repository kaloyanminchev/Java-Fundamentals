package MidExams;

import java.util.Scanner;

public class DemoMarchBreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] events = scanner.nextLine().split("\\|+");
        int energy = 100;
        int coins = 100;

        for (int i = 0; i < events.length; i++) {
            String[] tokens = events[i].split("-");
            String type = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            if (type.equals("rest")) {
                if (energy + number > 100) {
                    number = 100 - energy;
                    energy = 100;
                } else {
                    energy += number;
                }
                System.out.printf("You gained %d energy.%n", number);
                System.out.printf("Current energy: %d.%n", energy);
            } else if (type.equals("order")) {
                if (energy - 30 < 0) {
                    energy += 50;
                    System.out.println("You had to rest!");
                } else {
                    coins += number;
                    energy -= 30;
                    System.out.printf("You earned %d coins.%n", number);
                }
            } else {
                coins -= number;
                if (coins > 0) {
                    System.out.printf("You bought %s.%n", type);
                } else {
                    System.out.printf("Closed! Cannot afford %s.", type);
                    return;
                }
            }
        }

        System.out.println("Day completed!");
        System.out.printf("Coins: %d%n", coins);
        System.out.printf("Energy: %d", energy);
    }
}

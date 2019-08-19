package MidExams;

import java.util.Scanner;

public class March10thGroup2HuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int countPlayers = Integer.parseInt(scanner.nextLine());
        double energy = Double.parseDouble(scanner.nextLine());
        double water = Double.parseDouble(scanner.nextLine());
        double food = Double.parseDouble(scanner.nextLine());

        double totalWater = days * countPlayers * water;
        double totalFood = days * countPlayers * food;

        for (int i = 1; i <= days; i++) {
            double loss = Double.parseDouble(scanner.nextLine());
            energy -= loss;
            if (energy <= 0) {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
                return;
            }
            if (i % 2 == 0) {
                energy *= 1.05;
                totalWater *= 0.70;
            }
            if (i % 3 == 0) {
                totalFood -= (totalFood / countPlayers);
                energy *= 1.10;
            }
        }

        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energy);
    }
}

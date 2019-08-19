package MidExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class March10thGroup2SeizeTheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("#");
        int water = Integer.parseInt(scanner.nextLine());
        double effort = 0;
        List<Integer> putOutCells = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split(" = ");
            String typeOfFire = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            switch (typeOfFire) {
                case "High":
                    if (value >= 81 && value <= 125 && value <= water) {
                        water -= value;
                        effort += 0.25 * value;
                        putOutCells.add(value);
                    }
                    break;
                case "Medium":
                    if (value >= 51 && value <= 80 && value <= water) {
                        water -= value;
                        effort += 0.25 * value;
                        putOutCells.add(value);
                    }
                    break;
                case "Low":
                    if (value >= 1 && value <= 50 && value <= water) {
                        water -= value;
                        effort += 0.25 * value;
                        putOutCells.add(value);
                    }
                    break;
            }
        }
        System.out.println("Cells:");
        for (Integer cell : putOutCells) {
            System.out.println(" - " + cell);
        }
        System.out.printf("Effort: %.2f%n", effort);
        System.out.println("Total Fire: " + putOutCells.stream().mapToInt(e -> e).sum());
    }
}
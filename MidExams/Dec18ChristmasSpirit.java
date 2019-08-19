package MidExams;

import java.util.Scanner;

public class Dec18ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantity = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int cost = 0;
        int spirit = 0;
        for (int i = 1; i <= days; i++) {
            if (i % 11 == 0) {
                quantity += 2;
            }
            if (i % 2 == 0) {
                cost += quantity * 2;
                spirit += 5;
            }
            if (i % 3 == 0) {
                cost += (quantity * 5) + (quantity * 3);
                spirit += 13;
            }
            if (i % 5 == 0) {
                cost += quantity * 15;
                spirit += 17;
                if (i % 3 == 0) {
                    spirit += 30;
                }
            }
            if (i % 10 == 0) {
                spirit -= 20;
                cost += 5 + 3 + 15;
            }
        }
        if (days % 10 == 0) {
            spirit -= 30;
        }
        System.out.println("Total cost: " + cost);
        System.out.println("Total spirit: " + spirit);

    }
}

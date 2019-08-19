package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String typeGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;

        switch (typeGroup) {
            case "Students":
                if ("Friday".equals(day)) {
                    price = 8.45;
                } else if ("Saturday".equals(day)) {
                    price = 9.80;
                } else {
                    price = 10.46;
                }
                break;
            case "Business":
                if ("Friday".equals(day)) {
                    price = 10.90;
                } else if ("Saturday".equals(day)) {
                    price = 15.60;
                } else {
                    price = 16;
                }
                break;
            case "Regular":
                if ("Friday".equals(day)) {
                    price = 15;
                } else if ("Saturday".equals(day)) {
                    price = 20;
                } else {
                    price = 22.50;
                }
                break;
        }

        if ("Business".equals(typeGroup) && number >= 100) {
            price *= (number - 10);
        } else {
            price *= number;
        }

        if ("Students".equals(typeGroup) && number >= 30) {
            price *= 0.85;
        }

        if ("Regular".equals(typeGroup) && number >= 10 && number <= 20) {
            price *= 0.95;
        }
        System.out.printf("Total price: %.2f", price);

    }
}

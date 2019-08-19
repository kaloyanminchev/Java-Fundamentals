package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum = 0;
        while (!"Start".equals(input)) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1.0 || coin == 2.0) {
                sum += coin;
            } else {
                System.out.println(String.format("Cannot accept %.2f", coin));
            }
            input = scanner.nextLine();
        }
        String purchase = scanner.nextLine();
        double price = 0;
        while (!"End".equals(purchase)) {
            switch (purchase) {
                case "Nuts":
                    price = 2;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    purchase = scanner.nextLine();
                    continue;
            }
            if (sum >= price) {
                sum -= price;
                System.out.printf("Purchased %s%n", purchase);
            } else {
                System.out.println("Sorry, not enough money");
            }
            purchase = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}

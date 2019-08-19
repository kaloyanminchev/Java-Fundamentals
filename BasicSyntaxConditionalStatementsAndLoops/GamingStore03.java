package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class GamingStore03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double price = 0.0;
        double spent = 0.0;
        boolean noMoney = false;
        while (!"Game Time".equals(input)) {
            switch (input) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    input = scanner.nextLine();
                    continue;
            }
            if (currentBalance < price) {
                System.out.println("Too Expensive");
            } else {
                System.out.println("Bought " + input);
                spent += price;
                currentBalance -= price;
            }
            if (currentBalance == 0) {
                System.out.println("Out of money!");
                noMoney = true;
                break;
            }
            input = scanner.nextLine();
        }
        if (!noMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, currentBalance);
        }

    }
}

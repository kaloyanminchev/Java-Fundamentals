package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double priceHeadset = Double.parseDouble(scanner.nextLine());
        double priceMouse = Double.parseDouble(scanner.nextLine());
        double priceKeyboard = Double.parseDouble(scanner.nextLine());
        double priceDisplay = Double.parseDouble(scanner.nextLine());

        double rageExpense =
                (lostGames / 2) * priceHeadset +
                (lostGames / 3) * priceMouse +
                (lostGames / 6) * priceKeyboard +
                (lostGames / 12) * priceDisplay;

        System.out.printf("Rage expenses: %.2f lv.", rageExpense);
    }
}

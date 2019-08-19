package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceSabre = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double priceNeeded = priceSabre * (students + Math.ceil(0.10 * students))
                + priceRobe * students + priceBelt * (students - students / 6);

        if (priceNeeded <= amount) {
            System.out.printf("The money is enough - it would cost %.2flv.", priceNeeded);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", priceNeeded - amount);
        }

    }
}

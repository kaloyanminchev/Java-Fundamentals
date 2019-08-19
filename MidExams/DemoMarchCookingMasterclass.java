package MidExams;

import java.util.Scanner;

public class DemoMarchCookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        double sum = apronPrice * Math.ceil(1.2 * students) + students * (10 * eggPrice) + flourPrice * (students - students / 5);

        if (budget >= sum) {
            System.out.printf("Items purchased for %.2f$.", sum);
        } else {
            System.out.printf("%.2f$ more needed.", sum - budget);
        }
    }
}

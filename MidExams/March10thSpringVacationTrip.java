package MidExams;

import java.util.Scanner;

public class March10thSpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        double fuelPrice = Double.parseDouble(scanner.nextLine());
        double foodExpensesPerDay = Double.parseDouble(scanner.nextLine());
        double priceNight = Double.parseDouble(scanner.nextLine());

        double totalFoodExpenses = foodExpensesPerDay * people * days;
        double totalPriceNights = priceNight * people * days;
        if (people > 10) {
            totalPriceNights *= 0.75;
        }
        double currentExpenses = totalFoodExpenses + totalPriceNights;

        for (int i = 1; i <= days; i++) {
            double distance = Double.parseDouble(scanner.nextLine());
            double consumedFuel = fuelPrice * distance;
            currentExpenses += consumedFuel;
            if (i % 3 == 0 || i % 5 == 0) {
                currentExpenses *= 1.40;
            }
            if (i % 7 == 0) {
                currentExpenses -= (currentExpenses / people);
            }
            if (currentExpenses > budget) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentExpenses - budget);
                return;
            }
        }
        System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - currentExpenses);
    }
}

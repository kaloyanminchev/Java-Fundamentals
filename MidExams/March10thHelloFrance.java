package MidExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class March10thHelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|+");
        double budget = Double.parseDouble(scanner.nextLine());
        double sumOldPrices = 0;
        List<Double> newPrices = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split("->");
            String item = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            switch (item) {
                case "Clothes":
                    if (price <= 50 && price <= budget) {
                        sumOldPrices += price;
                        budget -= price;
                        newPrices.add(price * 1.40);
                    }
                    break;
                case "Shoes":
                    if (price <= 35 && price <= budget) {
                        sumOldPrices += price;
                        budget -= price;
                        newPrices.add(price * 1.40);
                    }
                    break;
                case "Accessories":
                    if (price <= 20.50 && price <= budget) {
                        sumOldPrices += price;
                        budget -= price;
                        newPrices.add(price * 1.40);
                    }
                    break;
            }
        }

        double sumNewPrices = newPrices.stream().mapToDouble(e -> e).sum();
        double profit = sumNewPrices - sumOldPrices;

        for (Double newPrice : newPrices) {
            System.out.printf("%.2f ", newPrice);
        }
        System.out.println();
        System.out.println(String.format("Profit: %.2f", profit));

        if (sumNewPrices + budget >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}

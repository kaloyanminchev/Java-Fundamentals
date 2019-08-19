package MidExams;

import java.util.Scanner;

public class SantaCookiesArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfBatches = Integer.parseInt(scanner.nextLine());

        int totalBoxes = 0;

        for (int i = 0; i < amountOfBatches; i++) {
            int flour = Integer.parseInt(scanner.nextLine());
            int sugar = Integer.parseInt(scanner.nextLine());
            int cocoa = Integer.parseInt(scanner.nextLine());

            int flourCups = flour / 140;
            int sugarSpoons = sugar / 20;
            int cocoaSpoons = cocoa / 10;
            if (flourCups <= 0 || sugarSpoons <= 0 || cocoaSpoons <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
            } else {
                double totalCookies = Math.floor((140 + 10 + 20)
                        * Math.min(flourCups, Math.min(sugarSpoons, cocoaSpoons)) / 25);
                int boxesPerBatch = (int) totalCookies / 5;
                totalBoxes += boxesPerBatch;
                System.out.printf("Boxes of cookies: %d%n", boxesPerBatch);
            }
        }

        System.out.printf("Total boxes: %d", totalBoxes);
    }
}

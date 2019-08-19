package MidExams;

import java.util.Scanner;

public class April19EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggsPrice = 0.75 * flourPrice;
        double milkPrice = 1.25 * flourPrice;
        double neededMilkPrice = 0.250 * milkPrice;

        double cozonac = flourPrice + eggsPrice + neededMilkPrice;

        int countCozonac = 0;
        int coloredEggs = 0;
        while (budget >= cozonac) {
            countCozonac++;
            budget -= cozonac;
            coloredEggs += 3;
            if (countCozonac % 3 == 0) {
                coloredEggs -= (countCozonac - 2);
            }
        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", countCozonac, coloredEggs, budget);
    }
}

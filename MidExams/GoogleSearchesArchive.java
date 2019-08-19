package MidExams;

import java.util.Scanner;

public class GoogleSearchesArchive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int users = Integer.parseInt(scanner.nextLine());
        double moneyPerSearch = Double.parseDouble(scanner.nextLine());

        double totalMoney = 0;

        for (int i = 1; i <= users; i++) {
            int wordsCount = Integer.parseInt(scanner.nextLine());
            if (wordsCount <= 5) {
                double moneyPerUser = moneyPerSearch * days;
                if (wordsCount == 1) {
                    moneyPerUser *= 2;
                }
                if (i % 3 == 0) {
                    moneyPerUser *= 3;
                }
                totalMoney += moneyPerUser;
            }
        }
        System.out.printf("Total money earned for %d days: %.2f", days, totalMoney);
    }
}

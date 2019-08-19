package MidExams;

import java.util.Scanner;

public class Nov18PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int coins = 0;
        for (int i = 1; i <= days; i++) {
            if (i % 10 == 0) {
                size -= 2;
            }
            if (i % 15 == 0) {
                size += 5;
            }
            coins += 50;
            coins -= 2 * size;

            if (i % 3 == 0) {
                coins -= 3 * size;
            }
            if (i % 5 == 0) {
                coins += 20 * size;
                if (i % 3 == 0) {
                    coins -= 2 * size;
                }
            }
        }
        int coinsEach = coins / size;
        System.out.printf("%d companions received %d coins each.", size, coinsEach);
    }
}

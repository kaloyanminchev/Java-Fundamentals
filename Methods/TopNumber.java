package Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTopNumber(n);
    }

    static void printTopNumber(int n) {
        for (int i = 1; i <= n; i++) {
            boolean isOdd = false;
            int sum = 0;
            int currentNumber = i;
            while (currentNumber > 0) {
                if ((currentNumber % 10) % 2 != 0) {
                    isOdd = true;
                }
                sum += currentNumber % 10;
                currentNumber /= 10;
            }
            if (sum % 8 == 0 && isOdd) {
                System.out.println(i);
            }
        }
    }
}

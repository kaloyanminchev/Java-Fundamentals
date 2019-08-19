package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNumber = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int num = Integer.parseInt(scanner.nextLine());

        if (num == 0) {
            System.out.println(0);
        } else {
            int remainder = 0;
            int currentMultiplication = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = bigNumber.length() - 1; i >= 0; i--) {
                int currentDigit = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
                currentMultiplication = currentDigit * num;
                currentMultiplication += remainder;
                sb.append(currentMultiplication % 10);
                remainder = currentMultiplication / 10;
            }

            if (remainder > 0) {
                sb.append(remainder);
            }

            for (int i = sb.length() - 1; i >= 0; i--) {
                System.out.print(sb.charAt(i));
            }
        }
    }
}

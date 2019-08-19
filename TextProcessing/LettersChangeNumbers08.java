package TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String currentNumber : numbers) {
            char before = currentNumber.charAt(0);
            char after = currentNumber.charAt(currentNumber.length() - 1);
            double digit = Double.parseDouble(currentNumber.substring(1, currentNumber.length() - 1));

            if (Character.isUpperCase(before)) {
                int position = before - '@';
                digit /= position;
            } else {
                int position = before - '`';
                digit *= position;
            }

            if (Character.isUpperCase(after)) {
                int position = after - '@';
                digit -= position;
            } else {
                int position = after - '`';
                digit += position;
            }
            sum += digit;
        }

        System.out.printf("%.2f", sum);
    }
}

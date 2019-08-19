package DataTypesAndVariables;

import java.util.Scanner;

public class FromLeftToTheRight02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String delimiter = " ";
            String[] splitNumbers = input.split(delimiter);
            long leftNum = Long.parseLong(splitNumbers[0]);
            long rightNum = Long.parseLong(splitNumbers[1]);

            long biggerNum = 0;
            if (leftNum > rightNum) {
                biggerNum = leftNum;
            } else {
                biggerNum = rightNum;
            }
            int sumOfDigits = 0;
            while (biggerNum != 0) {
                sumOfDigits += biggerNum % 10;
                biggerNum /= 10;
            }
            System.out.println(Math.abs(sumOfDigits));
        }

    }
}
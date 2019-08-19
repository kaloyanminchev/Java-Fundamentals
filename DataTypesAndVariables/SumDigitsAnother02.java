package DataTypesAndVariables;

import java.util.Scanner;

public class SumDigitsAnother02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String numberInStr = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < numberInStr.length(); i++) {
            int digit = Integer.parseInt(String.valueOf((numberInStr.charAt(i))));
            sum += digit;
        }
        System.out.println(sum);
    }
}

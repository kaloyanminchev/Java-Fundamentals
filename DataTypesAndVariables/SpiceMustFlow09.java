package DataTypesAndVariables;

import java.util.Scanner;

public class SpiceMustFlow09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int starringYield = Integer.parseInt(scanner.nextLine());
        int atLeast = 100;
        int countDays = 0;
        int totalAmount = 0;

        if (starringYield < 100) {
            System.out.println(0);
            System.out.println(0);
        } else {
            while (starringYield >= atLeast) {
                countDays++;
                totalAmount += starringYield - 26;
                starringYield -= 10;
            }
            totalAmount -= 26;
            System.out.println(countDays);
            System.out.println(totalAmount);
        }
    }
}


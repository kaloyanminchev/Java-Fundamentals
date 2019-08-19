package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Messages05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersToPush = Integer.parseInt(scanner.nextLine());

        String message = "";

        for (int i = 0; i < numbersToPush; i++) {
            String digits = scanner.nextLine();
            int digitLength = digits.length();
            char oneDigit = digits.charAt(0);
            int mainDigit = Integer.parseInt(String.valueOf(oneDigit));
            int offset = (mainDigit - 2) * 3;

            if (mainDigit == 8 || mainDigit == 9) {
                offset = (mainDigit - 2) * 3 + 1;
            }

            int letterIndex = offset + digitLength - 1;
            int letterCode = letterIndex + 97;
            char letter = (char) letterCode;

            if (mainDigit == 0) {
                letter = (char) (mainDigit + 32);
            }
            message += letter;


        }
        System.out.println(message);

    }
}

package Methods;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            printPalindromeOrNot(input);
            input = scanner.nextLine();
        }
    }

    static void printPalindromeOrNot(String input) {
        boolean isSame = true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                isSame = false;
                System.out.println("false");
                break;
            }
        }
        if (isSame) {
            System.out.println("true");
        }
    }
}

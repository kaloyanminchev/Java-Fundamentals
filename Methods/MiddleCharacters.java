package Methods;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.length() % 2 == 0) {
            System.out.print(s.charAt(s.length() / 2 - 1));
            printMiddle(s);
        } else {
            printMiddle(s);
        }
    }

    static void printMiddle(String s) {
        System.out.print(s.charAt(s.length() / 2));
    }
}

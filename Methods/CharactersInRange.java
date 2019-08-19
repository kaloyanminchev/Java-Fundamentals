package Methods;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);
        if (a < b) {
            printRange(a, b);
        } else {
            printRange(b, a);
        }
    }
    private static void printRange(char a, char b) {
        for (int i = a + 1; i < b; i++) {
            System.out.print((char) (i) + " ");
        }
    }
}

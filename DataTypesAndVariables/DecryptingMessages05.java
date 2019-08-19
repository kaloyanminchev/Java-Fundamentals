package DataTypesAndVariables;

import java.util.Scanner;

public class DecryptingMessages05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String message = "";
        for (int i = 1; i <= n; i++) {
            char currentChar = scanner.nextLine().charAt(0);
            message += (char)(currentChar + key);
        }
        System.out.println(message);
    }
}

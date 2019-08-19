package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String reversedUsername = "";

        for (int i = 0; i < username.length(); i++) {
            reversedUsername += username.charAt(username.length() - i - 1);
        }
        String input = scanner.nextLine();
        int counter = 0;
        while (!input.equals(reversedUsername)) {
            counter++;
            if (counter == 4) {
                System.out.printf("User %s blocked!\n", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }

        if (input.equals(reversedUsername)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}

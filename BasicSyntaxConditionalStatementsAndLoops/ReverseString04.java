package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class ReverseString04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reversedInput = "";

        for (int i = 0; i < input.length(); i++) {
            reversedInput += input.charAt(input.length() - i - 1);
        }
        System.out.println(reversedInput);

    }
}

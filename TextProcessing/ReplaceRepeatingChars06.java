package TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        StringBuilder output = new StringBuilder();
        output.append(string.charAt(0));

        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) != string.charAt(i + 1)) {
                output.append(string.charAt(i + 1));
            }
        }
        System.out.println(output);
    }
}

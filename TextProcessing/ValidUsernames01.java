package TextProcessing;

import java.util.Scanner;

public class ValidUsernames01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(", ");
        for (String word : words) {
            if (wordValidator(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean wordValidator(String word) {
        if (word.length() < 3 || word.length() > 16) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetterOrDigit(word.charAt(i))
                    && word.charAt(i) != '-'
                    && word.charAt(i) != '_') {
                return false;
            }
        }
        return true;
    }
}

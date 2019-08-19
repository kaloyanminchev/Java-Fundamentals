package TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String first = input.substring(0, input.indexOf(' '));
        String second = input.substring(input.lastIndexOf(' ') + 1).trim();
        int sum = getTotalSum(first, second);
        System.out.println(sum);

    }

    private static int getTotalSum(String first, String second) {
        int sum = 0;
        int minLength = Math.min(first.length(), second.length());
        for (int i = 0; i < minLength; i++) {
            sum += first.charAt(i) * second.charAt(i);
        }

        String maxLength = first.length() > second.length() ? first : second;
        for (int i = minLength; i < maxLength.length(); i++) {
            sum += maxLength.charAt(i);
        }

        return sum;
    }
}

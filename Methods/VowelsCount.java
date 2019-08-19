package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(countVowels(input));
    }

    static int countVowels(String input) {
        String table = "aeiouAEIOU";
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (table.contains(String.valueOf(letter))) {
                counter++;
            }
        }
        return counter;
    }
}

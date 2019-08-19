package TextProcessing;

import java.util.Scanner;

public class StringExplosion07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        int strength = 0;

        for (int i = 0; i < text.length(); i++) {
            result.append(text.charAt(i));

            if (text.charAt(i) == '>') {
                strength += Integer.parseInt(String.valueOf(text.charAt(i + 1)));
            }

            while (strength > 0) {
                i++;
                if (i + 1 == text.length() || text.charAt(i + 1) == '>') {
                    break;
                }
                strength--;
            }
        }
        System.out.println(result);
    }
}

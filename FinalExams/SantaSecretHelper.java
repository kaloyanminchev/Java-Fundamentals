package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String message = scanner.nextLine();
        while (!"end".equals(message)) {
            String decodesMessage = "";
            for (int i = 0; i < message.length(); i++) {
                decodesMessage += (char) (message.charAt(i) - key);
            }

            String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*!([GN])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decodesMessage);
            if (matcher.find() && matcher.group(2).equals("G")) {
                System.out.println(matcher.group("name"));
            }

            message = scanner.nextLine();
        }
    }
}

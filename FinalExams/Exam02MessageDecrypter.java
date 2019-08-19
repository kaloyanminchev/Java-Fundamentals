package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam02MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();

            Matcher matcher = Pattern.compile("^([$%])(?<tag>[A-Z][a-z]{3,})\\1: (\\[(?<num1>\\d+)\\]\\|\\[(?<num2>\\d+)\\]\\|\\[(?<num3>\\d+)\\]\\|)$")
                    .matcher(message);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String firstGroup = matcher.group("num1");
                char firstLetter = (char) (Integer.parseInt(firstGroup));

                String secondGroup = matcher.group("num2");
                char secondLetter = (char) (Integer.parseInt(secondGroup));

                String thirdGroup = matcher.group("num3");
                char thirdLetter = (char) (Integer.parseInt(thirdGroup));

                String decryptedMessage = "" + firstLetter + secondLetter + thirdLetter;

                System.out.printf("%s: %s%n", tag, decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}

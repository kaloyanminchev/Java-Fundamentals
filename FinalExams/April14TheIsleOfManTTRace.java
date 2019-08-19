package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class April14TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([#$%*&])(?<name>[A-Za-z]+)\\1=(?<length>\\d+)!!(?<code>.+)";
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);

        while (true) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String code = matcher.group("code");
                if (length == code.length()) {
                    String geohashcode = "";
                    for (int i = 0; i < code.length(); i++) {
                        geohashcode += (char) (code.charAt(i) + length);
                    }
                    System.out.printf("Coordinates found! %s -> %s", name, geohashcode);
                    return;
                }
            }
            System.out.println("Nothing found!");
            input = scanner.nextLine();
        }
    }
}

package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class April14ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?<name>[A-Za-z0-9!@#$?]+)=(?<length>\\d+)<<(?<code>.+)$";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!input.equals("Last note")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String code = matcher.group("code");

                if (code.length() == length) {
                    String peakName = "";
                    for (int i = 0; i < name.length(); i++) {
                        if (Character.isLetterOrDigit(name.charAt(i))) {
                            peakName += name.charAt(i);
                        }
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s", peakName, code));
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }

            input = scanner.nextLine();
        }
    }
}



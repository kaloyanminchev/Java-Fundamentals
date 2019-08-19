package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[@]{6,}|[$]{6,}|[#]{6,}|[\\^]{6,}";
        Pattern pattern = Pattern.compile(regex);

        String[] collectionOfTickets = scanner.nextLine().split("[,\\s]+");
        for (String ticket : collectionOfTickets) {
            if (ticket.length() == 20) {
                String left = ticket.substring(0, 10);
                String right = ticket.substring(10);

                String leftMatch = "l";
                String rightMatch = "r";

                Matcher leftMatcher = pattern.matcher(left);
                Matcher rightMatcher = pattern.matcher(right);
                if (leftMatcher.find()) {
                    leftMatch = leftMatcher.group();
                }
                if (rightMatcher.find()) {
                    rightMatch = rightMatcher.group();
                }

                if (leftMatch.substring(0, 1).equals(rightMatch.substring(0, 1))) {
                    int matchCount = Math.min(leftMatch.length(), rightMatch.length());
                    if (matchCount == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!\n", ticket, matchCount, leftMatch.substring(0, 1));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%s\n", ticket, matchCount, leftMatch.substring(0, 1));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match\n", ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}

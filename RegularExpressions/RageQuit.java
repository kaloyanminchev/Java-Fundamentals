package RegularExpressions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "([^\\d]+)(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);


        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            String lettersToPrint = matcher.group(1).toUpperCase();
            int count = Integer.parseInt(matcher.group(2));
            for (int i = 0; i < count; i++) {
                output.append(lettersToPrint);
            }
        }
        HashSet<Character> uniqueSymbols = new HashSet<>();
        for (int i = 0; i < output.length(); i++) {
            uniqueSymbols.add(output.charAt(i));
        }

        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(output);
    }
}

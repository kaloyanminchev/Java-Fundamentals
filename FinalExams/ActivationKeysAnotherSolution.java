package FinalExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeysAnotherSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> result = new ArrayList<>();

        String[] line = scanner.nextLine().split("&");
        for (String key : line) {
            Matcher matcher = Pattern.compile("^[A-Za-z0-9]+$").matcher(key);
            if (matcher.find() && (key.length() == 16 || key.length() == 25)) {
                key = key.toUpperCase();
                StringBuilder groupedKey = new StringBuilder();
                if (key.length() == 16) {
                    int start = 0;
                    int end = 4;
                    for (int i = 0; i < 4; i++) {
                        groupedKey.append(key, start, end);
                        if (end != 16) {
                            groupedKey.append("-");
                        }
                        start += 4;
                        end += 4;
                    }
                } else {
                    int start = 0;
                    int end = 5;
                    for (int i = 0; i < 5; i++) {
                        groupedKey.append(key.substring(start, end));
                        if (end != 25) {
                            groupedKey.append("-");
                        }
                        start += 5;
                        end += 5;
                    }
                }
                for (int i = 0; i < groupedKey.length(); i++) {
                    char ch = groupedKey.charAt(i);
                    if (Character.isDigit(ch)) {
                        ch = (char) ('9' - ch + '0');
                        groupedKey.setCharAt(i, ch);
                    }
                }
                result.add(groupedKey.toString());
            }
        }

        System.out.println(String.join(", ", result));
    }
}

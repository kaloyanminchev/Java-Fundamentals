package FinalExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        int[] emojiCodes = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        String nameEmoji = "";

        for (int emojiCode : emojiCodes) {
            nameEmoji += (char) emojiCode;
        }

        String emojiRegex = "(?<=\\s)(:(?<emoji>[a-z]{4,}):)(?=[\\s,.!?])";
        Pattern pattern = Pattern.compile(emojiRegex);
        Matcher matcher = pattern.matcher(text);

        List<String> emojis = new ArrayList<>();
        int totalPower = 0;
        while (matcher.find()) {
            emojis.add(matcher.group(1));
            for (int i = 0; i < matcher.group("emoji").length(); i++) {
                totalPower += matcher.group("emoji").charAt(i);
            }
        }

        if (emojis.contains(":" + nameEmoji + ":")) {
            totalPower *= 2;
        }

        if (!emojis.isEmpty()) {
            System.out.println("Emojis found: " + String.join(", ", emojis));
        }
        System.out.println("Total Emoji Power: " + totalPower);
    }
}

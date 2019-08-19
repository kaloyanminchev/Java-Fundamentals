package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexLetters = "[A-Za-z]";
        Pattern pattern = Pattern.compile(regexLetters);
        String regexDigits = "[0-9]";
        Pattern pattern1 = Pattern.compile(regexDigits);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        LinkedHashMap<String, Integer> infoToStore = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            Matcher matcher = pattern.matcher(input);
            Matcher matcher1 = pattern1.matcher(input);
            String name = "";
            while (matcher.find()) {
                name += matcher.group();
            }
            int distance = 0;
            while (matcher1.find()) {
                distance += Integer.parseInt(matcher1.group());
            }

            if (participants.contains(name)) {
                if (!infoToStore.containsKey(name)) {
                    infoToStore.put(name, distance);
                } else {
                    infoToStore.put(name, infoToStore.get(name) + distance);
                }
            }

            input = scanner.nextLine();
        }

        List<String> topThree = new ArrayList<>();
        infoToStore.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(entry -> topThree.add(entry.getKey()));

        System.out.printf("1st place: %s%n2nd place: %s%n3rd place: %s", topThree.get(0), topThree.get(1), topThree.get(2));
    }
}

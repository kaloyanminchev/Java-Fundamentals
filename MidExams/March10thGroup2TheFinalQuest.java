package MidExams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class March10thGroup2TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split("\\s")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!"Stop".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Delete":
                    int index = Integer.parseInt(tokens[1]) + 1;
                    if (index >= 0 && index < words.size()) {
                        words.remove(index);
                    }
                    break;
                case "Swap":
                    String firstWord = tokens[1];
                    String secondWord = tokens[2];
                    if (words.contains(firstWord) && words.contains(secondWord)) {
                        int firstIndex = words.indexOf(firstWord);
                        int secondIndex = words.indexOf(secondWord);
                        words.set(firstIndex, secondWord);
                        words.set(secondIndex, firstWord);
                    }
                    break;
                case "Put":
                    String word = tokens[1];
                    int previousIndex = Integer.parseInt(tokens[2]) - 1;
                    if (previousIndex >= 0 && previousIndex <= words.size()) {
                        words.add(previousIndex, word);
                    }
                    break;
                case "Sort":
                    Collections.sort(words);
                    Collections.reverse(words);
                    break;
                case "Replace":
                    String one = tokens[1];
                    String two = tokens[2];
                    if (words.contains(two)) {
                        int indexTwo = words.indexOf(two);
                        words.set(indexTwo, one);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", words));
    }
}

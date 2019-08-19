package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuaryAnotherSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalWeight = 0;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            Matcher matcher = Pattern.compile("^n:(?<name>[^;]+);t:(?<kind>[^;]+);c--(?<country>[A-Za-z\\s]+)$")
                    .matcher(message);

            if (matcher.find()) {
                String name = matcher.group("name");
                String kind = matcher.group("kind");
                String country = matcher.group("country");

                String animalName = getCorrectString(name);
                String animalKind = getCorrectString(kind);
                String animalCountry = getCorrectString(country);

                totalWeight += getWeight(name);
                totalWeight += getWeight(kind);

                System.out.printf("%s is a %s from %s\n", animalName, animalKind, animalCountry);
            }
        }
        System.out.printf("Total weight of animals: %dKG", totalWeight);
    }

    private static int getWeight(String string) {
        int weight = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isDigit(ch)) {
                weight += Integer.parseInt(String.valueOf(ch));
            }
        }
        return weight;
    }

    private static String getCorrectString(String string) {
        String correctString = "";
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isLetter(ch) || Character.isWhitespace(ch)) {
                correctString += ch;
            }
        }
        return correctString;
    }
}

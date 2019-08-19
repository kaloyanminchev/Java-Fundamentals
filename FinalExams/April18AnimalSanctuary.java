package FinalExams;

import java.util.Scanner;

public class April18AnimalSanctuary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int totalWeight = 0;

        for (int i = 0; i < n; i++) {
            String[] message = scanner.nextLine().split(";");
            if (message.length == 3) {
                String animalName = message[0];
                String animalKind = message[1];
                String animalCountry = message[2];
                if (validateMessage(animalName, animalKind, animalCountry)) {
                    String name = findAnimalName(animalName);
                    String kind = findAnimalKind(animalKind);
                    String country = findAnimalCountry(animalCountry).trim();

                    System.out.println(String.format("%s is a %s from %s", name, kind, country));

                    totalWeight += calcWeight(animalName, animalKind);
                }
            }
        }
        System.out.printf("Total weight of animals: %dKG", totalWeight);
    }

    private static int calcWeight(String animalName, String animalKind) {
        int weight = 0;
        for (char s : animalName.toCharArray()) {
            if (Character.isDigit(s)) {
                weight += Integer.parseInt(String.valueOf(s));
            }
        }
        for (char s : animalKind.toCharArray()) {
            if (Character.isDigit(s)) {
                weight += Integer.parseInt(String.valueOf(s));
            }
        }
        return weight;
    }

    private static boolean validateMessage(String animalName, String animalKind, String animalCountry) {
        for (int i = 3; i < animalCountry.length(); i++) {
            if (!Character.isLetter(animalCountry.charAt(i))
                    && animalCountry.charAt(i) != ' ') {
                return false;
            }
        }
        return animalName.substring(0, 2).equals("n:")
                && animalKind.substring(0, 2).equals("t:")
                && animalCountry.substring(0, 3).equals("c--");
    }

    private static String findAnimalCountry(String animalCountry) {
        StringBuilder result = new StringBuilder();
        for (int i = 3; i < animalCountry.length(); i++) {
            char symbol = animalCountry.charAt(i);
            if (Character.isLetter(symbol) || symbol == ' ') {
                result.append(symbol);
            }
        }
        return result.toString();

    }

    private static String findAnimalKind(String animalKind) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < animalKind.length(); i++) {
            char symbol = animalKind.charAt(i);
            if (Character.isLetter(symbol) || symbol == ' ') {
                result.append(symbol);
            }
        }
        return result.toString();

    }

    private static String findAnimalName(String animalName) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < animalName.length(); i++) {
            char symbol = animalName.charAt(i);
            if (Character.isLetter(symbol) || symbol == ' ') {
                result.append(symbol);
            }
        }
        return result.toString();
    }
}

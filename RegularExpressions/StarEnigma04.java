package RegularExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            Matcher matcher = Pattern.compile("[starSTAR]").matcher(message);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            StringBuilder decryptedMessage = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                decryptedMessage.append((char) (message.charAt(j) - count));
            }

            matcher = Pattern.compile("@([A-Za-z]+)[^@!:>-]*:(\\d+)[^@!:>-]*!([AD])![^@!:>-]*->(\\d+)")
                    .matcher(decryptedMessage);
            if (matcher.find()) {
                String planet = matcher.group(1);
                String attackType = matcher.group(3);

                if (attackType.equals("A")) {
                    attackedPlanets.add(planet);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planet);
                }
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.println("Attacked planets: " + attackedPlanets.size());
        for (String attackedPlanet : attackedPlanets) {
            System.out.println("-> " + attackedPlanet);
        }

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        for (String destroyedPlanet : destroyedPlanets) {
            System.out.println("-> " + destroyedPlanet);
        }
    }
}

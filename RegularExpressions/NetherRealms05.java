package RegularExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("[, ]+")).sorted().collect(Collectors.toList());

        for (String demon : input) {
            Matcher matcher = Pattern.compile("[^0-9+\\-*\\/\\.]")
                    .matcher(demon);

            int totalHealth = 0;
            while (matcher.find()) {
                totalHealth += (char) (matcher.group().charAt(0));
            }

            matcher = Pattern.compile("(\\-?\\d+\\.?\\d+)(?!\\.)|(\\-?\\d+)(?!\\.)")
                    .matcher(demon);

            double damage = 0;
            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }
            if (demon.contains("*") || demon.contains("/")) {
                for (int i = 0; i < demon.length(); i++) {
                    if (demon.charAt(i) == '*') {
                        damage *= 2;
                    } else if (demon.charAt(i) == '/') {
                        damage /= 2;
                    }
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demon, totalHealth, damage);
        }
    }
}

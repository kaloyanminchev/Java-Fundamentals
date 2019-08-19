package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timeDishes = 0;
        int timeCleaning = 0;
        int timeLaundry = 0;

        String input = scanner.nextLine();
        while (!"wife is happy".equals(input)) {
            String dishesRegex = "<(?<dishes>[a-z0-9]+)>";
            Pattern dishesPattern = Pattern.compile(dishesRegex);
            Matcher dishesMatcher = dishesPattern.matcher(input);
            if (dishesMatcher.find()) {
                String dishes = dishesMatcher.group("dishes");
                for (int i = 0; i < dishes.length(); i++) {
                    if (Character.isDigit(dishes.charAt(i))) {
                        timeDishes += Integer.parseInt(String.valueOf(dishes.charAt(i)));
                    }
                }
            }

            String cleaningRegex = "\\[(?<cleaning>[A-Z0-9]+)\\]";
            Pattern cleaningPattern = Pattern.compile(cleaningRegex);
            Matcher cleaningMatcher = cleaningPattern.matcher(input);
            if (cleaningMatcher.find()) {
                String cleaning = cleaningMatcher.group("cleaning");
                for (int i = 0; i < cleaning.length(); i++) {
                    if (Character.isDigit(cleaning.charAt(i))) {
                        timeCleaning += Integer.parseInt(String.valueOf(cleaning.charAt(i)));
                    }
                }
            }

            String laundryRegex = "\\{(.+)}";
            Pattern laundryPattern = Pattern.compile(laundryRegex);
            Matcher laundryMatcher = laundryPattern.matcher(input);
            if (laundryMatcher.find()) {
                String laundry = laundryMatcher.group(1);
                for (int i = 0; i < laundry.length(); i++) {
                    if (Character.isDigit(laundry.charAt(i))) {
                        timeLaundry += Integer.parseInt(String.valueOf(laundry.charAt(i)));
                    }
                }
            }

            input = scanner.nextLine();
        }

        int totalMinutes = timeDishes + timeCleaning + timeLaundry;
        System.out.printf("Doing the dishes - %d min.%n", timeDishes);
        System.out.printf("Cleaning the house - %d min.%n", timeCleaning);
        System.out.printf("Doing the laundry - %d min.%n", timeLaundry);
        System.out.printf("Total - %d min.", totalMinutes);
    }
}

package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<furniture>[A-Z]+[a-z]*)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> result = new ArrayList<>();
        double totalSpent = 0;

        String input = scanner.nextLine();
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                result.add(furniture);
                totalSpent += price * quantity;
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String name : result) {
            System.out.println(name);
        }
        System.out.printf("Total money spend: %.2f", totalSpent);
    }
}

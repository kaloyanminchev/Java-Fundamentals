package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.0-9]*(?<price>\\d+.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalPrice = 0;
        String input = scanner.nextLine();
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                price *= count;
                totalPrice += price;
                System.out.printf("%s: %s - %.2f%n", customer, product, price);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalPrice);
    }
}

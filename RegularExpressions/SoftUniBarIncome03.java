package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%([^%$|.]*)<(?<product>\\w+)>([^%$|.]*)\\|(?<count>\\d+)\\|([^%$|.]*?)(?<price>\\d+\\.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;
        String input = scanner.nextLine();
        while (!input.equals("end of shift")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = count * price;
                totalIncome += totalPrice;
                System.out.println(String.format("%s: %s - %.2f", name, product, totalPrice));
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}

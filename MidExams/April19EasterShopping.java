package MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class April19EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shops = Arrays.stream(scanner.nextLine().split("\\s")).collect(Collectors.toList());
        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Include":
                    shops.add(tokens[1]);
                    break;
                case "Visit":
                    String firstOrLast = tokens[1];
                    int numberOfShops = Integer.parseInt(tokens[2]);
                    if (numberOfShops <= shops.size()) {
                        if ("first".equals(firstOrLast)) {
                            for (int j = 0; j < numberOfShops; j++) {
                                shops.remove(0);
                            }
                        } else {
                            for (int j = 0; j < numberOfShops; j++) {
                                shops.remove(shops.size() - 1);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    if (firstIndex >= 0 && firstIndex < shops.size() && secondIndex >= 0 && secondIndex < shops.size()) {
                        String temp = shops.get(firstIndex);
                        shops.set(firstIndex, shops.get(secondIndex));
                        shops.set(secondIndex, temp);
                    }
                    break;
                case "Place":
                    int index = Integer.parseInt(tokens[2]) + 1;
                    if (index >= 0 && index < shops.size()) {
                        shops.add(index, tokens[1]);
                    }
                    break;
            }
        }
        System.out.println("Shops left:");
        System.out.println(String.join(" ", shops));
    }
}

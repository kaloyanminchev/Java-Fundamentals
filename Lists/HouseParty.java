package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+");
            String name = tokens[0];

            if (command.contains("is going")) {
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name);
                }
            } else {
                if (!guests.remove(name)) {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}

package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("\\s+");
        List<Integer> wagon = new ArrayList<>();
        for (String element : arr) {
            wagon.add(Integer.parseInt(element));
        }
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            if (command.contains("Add")) {
                String[] tokens = command.split("\\s+");
                int passengers = Integer.parseInt(tokens[1]);
                wagon.add(passengers);
            } else {
                int passengers = Integer.parseInt(command);
                for (int i = 0; i < wagon.size(); i++) {
                    if (wagon.get(i) + passengers <= maxCapacity) {
                        wagon.set(i, wagon.get(i) + passengers);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(wagon.toString().replaceAll("[\\[\\],]", ""));
    }
}

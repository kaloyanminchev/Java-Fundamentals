package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!"end".equalsIgnoreCase(command)) {
            String[] tokens = command.split("\\s+");
            String type = tokens[0];
            switch (type) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, Integer.parseInt(tokens[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int i = Integer.parseInt(tokens[1]);
                    if (i >= 0 && i < numbers.size()) {
                        numbers.remove(i);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    if ("left".equals(direction)) {
                        for (int j = 0; j < count; j++) {
                            int firstElement = numbers.remove(0);
                            numbers.add(firstElement);
                        }
                    } else {
                        for (int j = 0; j < count; j++) {
                            int lastElement = numbers.remove(numbers.size() - 1);
                            numbers.add(0, lastElement);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}

package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        String input = scanner.nextLine();
        while (true) {
            if ("end".equals(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(tokens[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String type = tokens[1];
                    if ("even".equals(type)) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int integer = Integer.parseInt(tokens[2]);
                    switch (condition) {
                        case "<":
                            for (Integer number : numbers) {
                                if (number < integer) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (Integer number : numbers) {
                                if (number > integer) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (Integer number : numbers) {
                                if (number >= integer) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (Integer number : numbers) {
                                if (number <= integer) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
